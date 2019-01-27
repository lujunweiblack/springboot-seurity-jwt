package com.example.seurity.ctrl;

import com.example.seurity.common.StringDataUtils;
import com.example.seurity.model.ResultBean;
import com.example.seurity.model.SysPermission;
import com.example.seurity.model.SysUser;
import com.example.seurity.service.PanelPermissionConfigurationService;
import com.example.seurity.service.UserService;
import com.example.seurity.vo.MenuVO;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: lujunwei
 * @time: 14:02 2019/1/27
 * @des:
 */
@Slf4j
@RestController
@RequestMapping("/menu")
public class MenuCtrl {


    @Autowired
    private PanelPermissionConfigurationService panelPermissionConfigurationService;

    @Autowired
    private UserService userService;


    @PostMapping("/dynamicMenuQuery")
    public String dynamicMenuQuery() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> strs = new ArrayList<>();
        for (GrantedAuthority authority : authorities) {
            strs.add(authority.getAuthority());
        }

        String roles = StringDataUtils.commaSpliceStr(strs, "'", "'", ",");
        List<SysPermission> sysPermissions = panelPermissionConfigurationService.dynamicMenuQuery(roles);
        SysUser sysUser = userService.findUserByUserName(authentication.getName());
        log.info("############ 父级菜单封装完毕 ##############");

       return ResultBean.resultInit(ResultBean.SUCCESS, new MenuVO(sysUser, sysPermissions));
    }
}
