package com.example.seurity.service.impl;

import com.example.seurity.mapper.RoleMapper;
import com.example.seurity.model.SysRole;
import com.example.seurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 16:20 2019/1/18
 * @des:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<SysRole> findRoleByUserId(long userId) {
        return roleMapper.findRoleByUserId(userId);
    }
}
