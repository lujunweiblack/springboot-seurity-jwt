package com.example.seurity.mapper;

import com.example.seurity.MapperSqlProvider.PanelPermissionConfigurationProvider;
import com.example.seurity.model.SysPermission;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 13:13 2019/1/27
 * @des:
 */
public interface PanelPermissionConfigurationMapper {

    @SelectProvider(type = PanelPermissionConfigurationProvider.class, method = "querySysPermissionByRoles")
    List<SysPermission> querySysPermissionByRoles(String roles);
}
