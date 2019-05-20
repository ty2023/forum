package com.bysj.service.impl;

import com.bysj.dao.IUserMapper;
import com.bysj.entity.User;
import com.bysj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 29029
 * @Version 1.0
 * @Time 12:49
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public User isExitEmail(String email) {
        return userMapper.isExitEmail(email);
    }

    @Override
    public User getByUserName(String userName) {
        return userMapper.getByUserName(userName);
    }

    @Override
    public Integer InsertUser(User user) {
        return userMapper.InsertUser(user);
    }

    @Override
    public User login(String userName, String passWord) {
        return userMapper.login(userName,passWord);
    }

    @Override
    public int updatePassword(String passWord, Integer id) {
        return userMapper.updatePassword(passWord,id);
    }
}
