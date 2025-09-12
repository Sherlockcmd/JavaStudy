package com.easy.web.dao;

import com.easy.web.pojo.User;

public interface IUserDao {
    User login(String name, String password);
}
