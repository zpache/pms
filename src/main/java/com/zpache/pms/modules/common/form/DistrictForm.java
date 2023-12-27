package com.zpache.pms.modules.common.form;

import lombok.Data;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/27 14:02
 */
@Data
public class DistrictForm {
    /**行政区划等级：*/
    private Integer districtLevel;
    /**父节点*/
    private Long parentId;
}
