package com.its.smart.api.dto;

import lombok.Data;

/**
 * 分页查询
 *
 * @author mq
 */
@Data
public class PageSearch extends ListFilter {

    private int pageSize = 20;

    private int pageNumber = 1;
}

