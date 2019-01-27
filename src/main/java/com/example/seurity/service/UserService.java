package com.example.seurity.service;

import com.example.seurity.model.SysUser;

/**
 * @author: lujunwei
 * @time: 15:24 2019/1/16
 * @des:
 */
public interface UserService {

    SysUser findUserByUserName(String userName);
}
