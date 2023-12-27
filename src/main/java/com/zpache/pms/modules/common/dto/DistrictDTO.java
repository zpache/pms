package com.zpache.pms.modules.common.dto;

import lombok.Data;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/27 14:01
 */
@Data
public class DistrictDTO {
    private Long districtId;
    private String districtName;
    private String shortName;
    private String pinYin;
}
