package com.dv.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel extends AbstractModel {
    private String fullName;
    private String username;
    private String password;
    private Integer status;
    // Foreign key
    private Long roleId;
    private String roleCode;
}