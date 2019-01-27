package com.example.seurity.service.impl;

import com.example.seurity.mapper.PermissionMapper;
import com.example.seurity.model.SysRole;
import com.example.seurity.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<SysRole> getPermByPermCode(String requestUrl) {
        return permissionMapper.getPermByPermCode(requestUrl);
    }
}
