package com.bysj.dao;

import com.bysj.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 29029
 */
public interface IUserMapper {

    User isExitEmail(String email);

    User getByUserName(String userName);

    Integer InsertUser(User user);

    User login(@Param("userName") String userName,@Param("passWord") String passWord);

    int updatePassword(@Param("passWord") String passWord,@Param("id") Integer id);
}
