package com.example.seurity.service.impl;

import com.example.seurity.mapper.UserMapper;
import com.example.seurity.model.SysUser;
import com.example.seurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lujunwei
 * @time: 15:24 2019/1/16
 * @des:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public SysUser findUserByUserName(String userName) {

        return userMapper.findUserByUserName(userName);
    }
}
