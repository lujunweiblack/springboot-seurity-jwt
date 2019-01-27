package com.example.seurity.service;

import com.example.seurity.mapper.PanelPermissionConfigurationMapper;
import com.example.seurity.model.SysPermission;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 13:11 2019/1/27
 * @des:
 */
@Service
public class PanelPermissionConfigurationServiceImpl implements PanelPermissionConfigurationService {

    @Autowired
    private PanelPermissionConfigurationMapper panelPermissionConfigurationMapper;

    @Override
    public List<SysPermission> dynamicMenuQuery(String roles) {

        List<SysPermission> sysPermissions = panelPermissionConfigurationMapper.querySysPermissionByRoles(roles);
        return sysPermissions;
    }

    @Override
    public List<SysPermission> dynamicMenuQueryByParent(String roles,SysPermission sysPermission) {
        return panelPermissionConfigurationMapper.dynamicMenuQueryByParent(roles,sysPermission);
    }
}
