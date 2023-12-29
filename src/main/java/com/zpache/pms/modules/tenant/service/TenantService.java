package com.zpache.pms.modules.tenant.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zpache.pms.entity.SysMenu;
import com.zpache.pms.entity.SysTenant;
import com.zpache.pms.modules.tenant.form.TenantForm;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 17:30
 */
public interface TenantService {

    Page<SysTenant> list(TenantForm tenantForm);

    SysTenant getById(Long id);

    SysTenant save(TenantForm tenantForm);

    SysTenant add(SysTenant sysTenant);

    SysTenant update(SysTenant sysTenant);
}
