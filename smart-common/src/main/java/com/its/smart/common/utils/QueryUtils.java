package com.its.smart.common.utils;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.its.smart.api.dto.ListFilter;
import com.its.smart.api.dto.SearchFilter;
import com.its.smart.common.xss.SqlFilter;

import java.util.List;

/**
 * @author MQ
 */
public class QueryUtils {

    public static String fromListFilter(ListFilter listFilter) {
        List<SearchFilter> filterList = listFilter.getFilters();
        StringBuffer filterSql = new StringBuffer();
        for (SearchFilter searchFilter : filterList) {
            if (searchFilter.getOperator().equals(SearchFilter.Operator.EQ)) {
                if(filterSql.length() > 0) {
                    filterSql.append(" OR ");
                } else {
                    filterSql.append(" WHERE ");
                }
                String name = SqlFilter.sqlInject(searchFilter.getFieldName().toString());
                String value = SqlFilter.sqlInject(searchFilter.getValue().toString());
                filterSql.append(name).append(" = '").append(value).append("'");
            }
        }

        List<SearchFilter> andFilterList = listFilter.getAndFilters();
        for (SearchFilter searchFilter : andFilterList) {
            if(filterSql.length() > 0) {
                filterSql.append(" AND ");
            } else {
                filterSql.append(" WHERE ");
            }
            String name = SqlFilter.sqlInject(searchFilter.getFieldName().toString());
            String value = SqlFilter.sqlInject(searchFilter.getValue().toString());
            filterSql.append(name).append(" = '").append(value).append("'");
        }
        return filterSql.toString();
    }

    public static <E> Wrapper<E> getWrapper(ListFilter listFilter) {
        Wrapper<E> wrapper = new Wrapper<E>() {
            @Override
            public String getSqlSegment() {
                return fromListFilter(listFilter);
            }
        };
        return wrapper;
    }
}
