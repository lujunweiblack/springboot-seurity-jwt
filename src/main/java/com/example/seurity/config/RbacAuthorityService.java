package com.example.seurity.config;

import com.example.seurity.model.SysRole;
import com.example.seurity.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component("rbacauthorityservice")
public class RbacAuthorityService {

    @Autowired
    private PermissionService permissionService;

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {


        boolean hasPermission = false;

        if (authentication.getPrincipal() instanceof UserDetails) {
            //配置规则
            Set<String> urls = new HashSet();
            urls.add("/user/**"); //需要role权限
            urls.add("/admin/**"); //需要admin权限

            AntPathMatcher antPathMatcher = new AntPathMatcher();

            for (String url : urls) {
                if (antPathMatcher.match(url, request.getRequestURI())) {
                    hasPermission = true;
                    break;
                }
            }

            if (hasPermission) {
                //遍历当前用户所具有的权限
                Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                //查询当前url需要什么角色可以访问
                List<SysRole> roles = permissionService.getPermByPermCode(request.getRequestURI());
                for (SysRole sysRole : roles) {
                    for (GrantedAuthority authority : authorities) {
                        //用户角色        authority.getAuthority()
                        //路径需要的角色   sysRole.getRoleCode()
                        if (authority.getAuthority().equals(sysRole.getRoleCode())) {
                            return hasPermission;
                        }
                    }
                }
            }
            return false;
        } else {
            return false;
        }
    }
}
