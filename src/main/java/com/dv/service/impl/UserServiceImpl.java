package com.dv.service.impl;

import java.util.List;

import com.dv.dao.RoleDAO;
import com.dv.dao.UserDAO;
import com.dv.dao.impl.RoleDAOImpl;
import com.dv.dao.impl.UserDAOImpl;
import com.dv.model.RoleModel;
import com.dv.model.UserModel;
import com.dv.service.UserService;

public class UserServiceImpl implements UserService {

    UserDAO userDAO = new UserDAOImpl();

    RoleDAO roleDAO = new RoleDAOImpl();

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

}
