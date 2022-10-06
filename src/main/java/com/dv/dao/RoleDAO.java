package com.dv.dao;

import java.util.List;

import com.dv.model.RoleModel;

public interface RoleDAO {
    List<RoleModel> findAll();

    RoleModel findOne(Long id);

    RoleModel findOneByCode(String code);

    Long save(RoleModel role);
}
