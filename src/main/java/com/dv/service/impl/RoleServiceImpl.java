package com.dv.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.dv.dao.RoleDAO;
import com.dv.model.RoleModel;
import com.dv.service.RoleService;

public class RoleServiceImpl implements RoleService {

    @Inject
    RoleDAO roleDAO;

    @Override
    public List<RoleModel> findAll() {
        List<RoleModel> roles = roleDAO.findAll();
        return roles;
    }

    @Override
    public RoleModel findOne(Long id) {
        RoleModel role = roleDAO.findOne(id);
        return role;
    }

    @Override
    public RoleModel save(RoleModel role) {
        Long id = roleDAO.save(role);
        role = roleDAO.findOne(id);
        return role;
    }

}
