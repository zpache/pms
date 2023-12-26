package com.zpache.pms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 16:45
 */
@TableName("sys_user")
@Data
public class SysUser {
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
