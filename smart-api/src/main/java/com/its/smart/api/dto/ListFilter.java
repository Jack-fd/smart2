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

    private List<SearchFilter> filters;

    private List<SearchFilter> andFilters;

    private Sort sort;

    private boolean autoBusinessFilter = true;

    public void addFilters(SearchFilter searchFilter) {
        if (filters == null) {
            filters = new ArrayList<>();
        }
        filters.add(searchFilter);
    }

    public void addAndFilters(SearchFilter searchFilter) {
        if (andFilters == null) {
            andFilters = new ArrayList<>();
        }
        andFilters.add(searchFilter);
    }
}
