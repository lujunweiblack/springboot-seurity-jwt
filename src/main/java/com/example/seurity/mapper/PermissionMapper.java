package com.example.seurity.mapper;

import com.example.seurity.model.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {

    @Select("select t3.* from sys_permission t1, sys_role_perm t2,sys_role t3 where t1.permission_id = t2.perm_id and t3.role_id = t2.role_id and t1.permission_code = #{requestUrl}")
    List<SysRole> getPermByPermCode(String requestUrl);
}
