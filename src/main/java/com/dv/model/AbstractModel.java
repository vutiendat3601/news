package com.dv.model;

import java.security.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractModel<T> {
    private Long id;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private String createdBy;
    private String modifiedBy;

    // Util
    private Long[] ids;
    private List<T> resultList;
    private Integer page;
	private Integer maxPageItem;
	private Integer totalPage;
	private Long totalItem;
	private String sortName;
	private String sortBy;
	private String alert;
	private String message;
	private String type;
}
