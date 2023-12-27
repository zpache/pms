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
@EqualsAndHashCode(callSuper = true)
@TableName("dict_value")
public class DictValue extends BaseEntity {
    private String type;
    private String dictValue;
    private String dictLabel;
    private Integer sort;
}
