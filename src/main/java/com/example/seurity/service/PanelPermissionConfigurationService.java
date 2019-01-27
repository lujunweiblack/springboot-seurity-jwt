package com.example.seurity.service;

import com.example.seurity.model.SysPermission;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 13:11 2019/1/27
 * @des:
 */
public interface PanelPermissionConfigurationService {
    List<SysPermission> dynamicMenuQuery(String roles);

    List<SysPermission> dynamicMenuQueryByParent(String roles,SysPermission sysPermission);
}
