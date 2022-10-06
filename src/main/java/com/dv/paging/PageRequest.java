package com.dv.paging;

import com.dv.sort.Sorter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PageRequest implements Pageable {

    private Integer page;
    private Integer maxPageItem;
    private Sorter sorter;

    @Override
    public Integer getPage() {
        return page;
    }

    @Override
    public Integer getOffset() {
        Integer offset = null;
        if (page != null && maxPageItem != null) {
            offset = (page - 1) * maxPageItem;
        }
        return offset;
    }

    @Override
    public Integer getLimit() {
        return maxPageItem;
    }

    @Override
    public Sorter getSorter() {
        return sorter;
    }
}
