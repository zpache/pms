package com.zpache.pms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zpache.pms.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/27 13:37
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("district")
public class District extends BaseEntity {
    private Long parentId;
    private String idPath;
    private String namePath;
    private Long districtId;
    private String districtName;
    private Integer districtLevel;
    private String shortName;
    private String pinYin;
    private String englishName;
    private String twoCode;
    private String threeCode;
    private String googleLongitude;
    private String googleLatitude;
    private String baiduLongitude;
    private String baiduLatitude;
}
