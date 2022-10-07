package com.dv.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.dv.dao.RoleDAO;
import com.dv.dao.UserDAO;
import com.dv.model.RoleModel;
import com.dv.model.UserModel;
import com.dv.service.UserService;

public class UserServiceImpl implements UserService {

    @Inject
    UserDAO userDAO;

    @Inject
    RoleDAO roleDAO;

    @Override
    public List<UserModel> findAll() {
        List<UserModel> users = userDAO.findAll();
        return users;
    }

    @Override
    public UserModel findOne(Long id) {
        UserModel user = userDAO.findOne(id);
        return user;
    }

    @Override
    public UserModel save(UserModel user) {
        // <---
        RoleModel role = roleDAO.findOneByCode(user.getRoleCode());
        user.setRoleId(role.getId());
        Long id = userDAO.save(user);

        // --->
        user = userDAO.findOne(id);
        return user;
    }

    @Override
    public UserModel findByUsernameAndPasswordAndStatus(String username, String password, Integer status) {
        UserModel user = userDAO.findByUsernameAndPasswordAndStatus(username, password, status);
        return user;
    }

}
