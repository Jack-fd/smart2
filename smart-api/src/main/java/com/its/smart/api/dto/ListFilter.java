package com.its.smart.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询对象
 *
 * @author mq
 */
@Data
public class ListFilter implements Serializable {

    private List<SearchFilter> filters = new ArrayList<>();

    private List<SearchFilter> andFilters = new ArrayList<>();

    private Sort sort;

    private boolean autoBusinessFilter = true;

    public void addFilters(SearchFilter searchFilter) {
        filters.add(searchFilter);
    }

    public void addAndFilters(SearchFilter searchFilter) {
        andFilters.add(searchFilter);
    }
}
