package com.zpache.pms.modules.role.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zpache.pms.entity.SysRole;
import com.zpache.pms.modules.role.form.RoleForm;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 17:05
 */
public interface RoleService {

    Page<SysRole> list(RoleForm roleForm);

    SysRole getById(Long id);

    SysRole save(RoleForm roleForm);

    SysRole add(SysRole sysRole);

    SysRole update(SysRole sysRole);

    void delete(Long id);
}
