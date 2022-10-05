package com.dv.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentModel extends AbstractModel {
    private String content;

    // Foreign key
    private Long userId;
    private Long newsId;
}
