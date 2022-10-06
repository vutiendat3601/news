package com.dv.service;

import java.util.List;

import com.dv.model.RoleModel;

public interface RoleService {
    List<RoleModel> findAll();

    RoleModel findOne(Long id);

    RoleModel save(RoleModel role);
}
