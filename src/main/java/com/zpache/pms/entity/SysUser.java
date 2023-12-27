package com.zpache.pms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zpache.pms.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 16:45
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
public class SysUser extends BaseEntity {
    private String tenantId;
    private String loginName;
    private String password;
    private String salt;
    private String name;
    private String email;
    private String mobile;
    private String status;
    private String avatar;
    private String deptId;
    private String deptName;
}
