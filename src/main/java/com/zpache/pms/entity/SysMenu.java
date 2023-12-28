package com.zpache.pms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zpache.pms.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @desc:
 * @author: wangbing
 * @createTime: 2023/12/28 09:27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_menu")
public class SysMenu extends BaseEntity {
}
