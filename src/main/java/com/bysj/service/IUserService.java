package com.bysj.service;

import com.bysj.entity.User;

public interface IUserService {
    User isExitEmail(String email);

    User getByUserName(String userName);

    Integer InsertUser(User user);

    User login(String userName, String passWord);

    int updatePassword(String passWord, Integer id);
}
