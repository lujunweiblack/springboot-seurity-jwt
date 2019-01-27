package com.example.seurity.service;


import com.example.seurity.model.SysRole;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 15:03 2019/1/18
 * @des:
 */
public interface RoleService {
    List<SysRole> findRoleByUserId(long userId);
}
