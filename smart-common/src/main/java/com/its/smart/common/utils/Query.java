package com.its.smart.common.utils;

import com.google.common.collect.Maps;
import com.its.smart.api.dto.ListFilter;
import com.its.smart.api.dto.PageSearch;
import com.its.smart.api.dto.SearchFilter;
import com.its.smart.api.dto.Sort;
import com.its.smart.common.xss.SQLFilter;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 查询参数
 *
 * @author mq
 */
@Data
public class Query extends LinkedHashMap<String, Object> {

    /**
     * 当前页码
     */
    private int page;

    /**
     * 每页条数
     */
    private int limit;

    public Query(Map<String, Object> params) {
        this.putAll(params);

        //分页参数
        this.page = Integer.parseInt(params.get("page").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
        this.put("offset", (page - 1) * limit);
        this.put("page", page);
        this.put("limit", limit);

        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String sidx = params.get("sidx").toString();
        String order = params.get("order").toString();
        this.put("sidx", SQLFilter.sqlInject(sidx));
        this.put("order", SQLFilter.sqlInject(order));
    }

    public static Query fromListFilter(ListFilter listFilter) {
        List<SearchFilter> filterList = listFilter.getFilters();
        StringBuffer filterSql = new StringBuffer();
        for (SearchFilter searchFilter : filterList) {
            if (searchFilter.getOperator().equals(SearchFilter.Operator.EQ)) {
                filterSql.append(" OR ").append(searchFilter.getFieldName()).append(" = '").append(searchFilter.getValue()).append("'");
            }

        }

        List<SearchFilter> andFilterList = listFilter.getAndFilters();
        for (SearchFilter searchFilter : andFilterList) {
            filterSql.append(" AND ").append(searchFilter.getFieldName()).append(searchFilter.getOperator()).append(searchFilter.getValue());
        }

        Map<String, Object> filterSqlMap = Maps.newHashMap();
        filterSqlMap.put("filterSql", filterSql);
        Sort sort = listFilter.getSort();
        if (sort != null) {
            Optional<String> sidx = Optional.ofNullable(sort.getFieldName());
            filterSqlMap.put("sidx", sidx.orElse(""));
            Optional<String> order = Optional.ofNullable(sort.getDirection());
            filterSqlMap.put("order", order.orElse(""));
        } else {
            filterSqlMap.put("sidx", "");
            filterSqlMap.put("order", "");
        }
        filterSqlMap.put("page", 1);
        filterSqlMap.put("limit", 100000);
        return new Query(filterSqlMap);
    }

    public static Query fromPageSearch(PageSearch pageSearch) {
        List<SearchFilter> filterList = pageSearch.getFilters();
        StringBuffer filterSql = new StringBuffer();
        for (SearchFilter searchFilter : filterList) {
            filterSql.append(" OR ").append(searchFilter.getFieldName()).append(searchFilter.getOperator()).append(searchFilter.getValue());
        }

        List<SearchFilter> andFilterList = pageSearch.getAndFilters();
        for (SearchFilter searchFilter : andFilterList) {
            filterSql.append(" AND ").append(searchFilter.getFieldName()).append(searchFilter.getOperator()).append(searchFilter.getValue());
        }

        Map<String, Object> filterSqlMap = Maps.newHashMap();
        filterSqlMap.put("filterSql", filterSql);
        Sort sort = pageSearch.getSort();
        if (sort != null) {
            Optional<String> sidx = Optional.ofNullable(sort.getFieldName());
            filterSqlMap.put("sidx", sidx.orElse(""));
            Optional<String> order = Optional.ofNullable(sort.getDirection());
            filterSqlMap.put("order", order.orElse(""));
        }
        filterSqlMap.put("page", pageSearch.getPageNumber());
        filterSqlMap.put("limit", pageSearch.getPageSize());
        return new Query(filterSqlMap);
    }
}
