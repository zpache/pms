package com.zpache.pms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zpache.pms.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/27 13:36
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("dict")
public class Dict extends BaseEntity {

    private String type;
    private String description;
}
