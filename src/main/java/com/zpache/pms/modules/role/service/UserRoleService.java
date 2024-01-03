package com.zpache.pms.modules.role.service;

import com.zpache.pms.entity.SysUserRole;

import java.util.List;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2024/1/3 09:46
 */
public interface UserRoleService {

    List<SysUserRole> findList();

    void add(SysUserRole userRole);

    void update(SysUserRole userRole);
    
}
