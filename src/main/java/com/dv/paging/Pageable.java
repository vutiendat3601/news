package com.dv.paging;

import com.dv.sort.Sorter;

public interface Pageable {
    Integer getPage();

    Integer getOffset();

    Integer getLimit();

    Sorter getSorter();
}
