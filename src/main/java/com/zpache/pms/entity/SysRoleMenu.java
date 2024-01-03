package com.zpache.pms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zpache.pms.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/28 09:27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role_menu")
public class SysRoleMenu extends BaseEntity {
    private String tenantId;
    private Long roleId;
    private Long menuId;
}
