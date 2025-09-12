package com.easy.web.service;

import com.easy.web.pojo.User;

public interface IUserService {
    User login(String name, String password);
}
