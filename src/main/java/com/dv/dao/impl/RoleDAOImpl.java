package com.dv.dao.impl;

import java.util.List;

import com.dv.dao.RoleDAO;
import com.dv.mapper.RoleMapper;
import com.dv.mapper.RowMapper;
import com.dv.model.RoleModel;

public class RoleDAOImpl extends AbstractDAO<RoleModel> implements RoleDAO {

    @Override
    public List<RoleModel> findAll() {
        String sql = "SELECT * FROM role";
        RowMapper<RoleModel> mapper = new RoleMapper();
        List<RoleModel> roles = query(sql, mapper);
        return roles;
    }

    @Override
    public RoleModel findOne(Long id) {
        String sql = "SELECT * FROM role WHERE id = ?";
        RowMapper<RoleModel> mapper = new RoleMapper();
        List<RoleModel> roles = query(sql, mapper, id);
        RoleModel role = roles.isEmpty() ? null : roles.get(0);
        return role;
    }
}
