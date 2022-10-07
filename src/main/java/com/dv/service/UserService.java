package com.dv.service;

import java.util.List;

import com.dv.model.UserModel;

public interface UserService {
    List<UserModel> findAll();

    UserModel findOne(Long id);

    UserModel save(UserModel user);

    UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status);
}
