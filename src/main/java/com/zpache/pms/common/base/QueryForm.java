package com.zpache.pms.common.base;

import lombok.Data;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/28 16:06
 */
@Data
public class QueryForm {
    private Long id;
    private Integer pageNum;
    private Integer pageSize;
}
