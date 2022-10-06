package com.dv.dao;

import java.util.List;

import com.dv.model.UserModel;

public interface UserDAO {
    List<UserModel> findAll();

    UserModel findOne(Long id);

    Long save(UserModel role);
}
