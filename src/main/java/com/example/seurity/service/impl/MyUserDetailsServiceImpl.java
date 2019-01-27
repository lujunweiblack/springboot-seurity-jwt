package com.example.seurity.service.impl;

import com.example.seurity.model.ResultBean;
import com.example.seurity.model.SysRole;
import com.example.seurity.model.SysUser;
import com.example.seurity.service.MyUserDetailsService;
import com.example.seurity.service.RoleService;
import com.example.seurity.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lujunwei
 * @time: 15:08 2019/1/18
 * @des:
 */
@Slf4j
@Service
public class MyUserDetailsServiceImpl implements MyUserDetailsService {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser sysUser;
        try {
            sysUser = userService.findUserByUserName(userName);
        } catch (Exception e) {
            log.info("############ 根据用户名查询报错 ############");
            throw new UsernameNotFoundException(ResultBean.resultInit("error","根据用户名查询报错"));
        }
        if (sysUser == null) {
            log.info("############ 用户不存在 ############");
            throw new UsernameNotFoundException(ResultBean.resultInit("error","用户不存在"));
        } else {
            try {
                List<SysRole> roles = roleService.findRoleByUserId(sysUser.getId());
                List<SimpleGrantedAuthority> simpleGrantedAuthorities = createAuthorities(roles);
                return new User(sysUser.getUserCode(), sysUser.getPassWord(), simpleGrantedAuthorities);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("############ 查询用户角色报错 ############");
                throw new UsernameNotFoundException(ResultBean.resultInit("error","查询用户角色报错"));
            }

        }
    }

    /**
     * 权限字符串转化
     * <p>
     * 如 "USER,ADMIN" -> SimpleGrantedAuthority("USER") + SimpleGrantedAuthority("ADMIN")
     */
    private List<SimpleGrantedAuthority> createAuthorities(List<SysRole> roles) {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (SysRole role : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getCode()));
        }
        return simpleGrantedAuthorities;
    }
}
