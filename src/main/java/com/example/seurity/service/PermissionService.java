package com.example.seurity.service;


import com.example.seurity.model.SysRole;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 15:06 2019/1/18
 * @des:
 */
public interface PermissionService {
    List<SysRole> getPermByPermCode(String requestUrl);
}
