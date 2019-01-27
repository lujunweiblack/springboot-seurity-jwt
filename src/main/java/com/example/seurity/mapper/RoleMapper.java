package com.example.seurity.mapper;

import com.example.seurity.model.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 16:30 2019/1/18
 * @des:
 */
public interface RoleMapper {

    @Select("SELECT * FROM sys_role t1, sys_user_role t2 where t2.role_id = t1.role_id and t2.user_id = #{userId}")
    List<SysRole> findRoleByUserId(long userId);
}
