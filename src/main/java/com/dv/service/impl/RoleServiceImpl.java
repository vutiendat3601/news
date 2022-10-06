package com.dv.service.impl;

import java.util.List;

import com.dv.dao.RoleDAO;
import com.dv.dao.impl.RoleDAOImpl;
import com.dv.model.RoleModel;
import com.dv.service.RoleService;

public class RoleServiceImpl implements RoleService {

    RoleDAO roleDAO = new RoleDAOImpl();

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
