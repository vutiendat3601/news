package com.dv.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryModel extends AbstractModel<CategoryModel> {
    private String name;
    private String code;
}
