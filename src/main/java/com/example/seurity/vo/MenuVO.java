package com.example.seurity.vo;


import com.example.seurity.model.SysPermission;
import com.example.seurity.model.SysUser;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 15:26 2019/1/16
 * @des:
 */
public class MenuVO {
    private SysUser sysUser;
    private List<SysPermission> sysPermissionList;

    public MenuVO() {
    }
    public MenuVO(SysUser sysUser, List<SysPermission> sysPermissionList) {
        this.sysUser = sysUser;
        this.sysPermissionList = sysPermissionList;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public List<SysPermission> getSysPermissionList() {
        return sysPermissionList;
    }

    public void setSysPermissionList(List<SysPermission> sysPermissionList) {
        this.sysPermissionList = sysPermissionList;
    }
}
