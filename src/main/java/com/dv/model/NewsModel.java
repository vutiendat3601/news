package com.dv.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsModel extends AbstractModel {
    private String title;
    private String thumbnail;
    private String shortDescription;
    private String content;

    // Foreign key
    private Long categoryId;
    private String categoryCode;
}
