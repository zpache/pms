package com.zpache.pms.modules.tenant.service.Impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zpache.pms.common.exception.ServiceException;
import com.zpache.pms.entity.SysTenant;
import com.zpache.pms.mapper.SysTenantMapper;
import com.zpache.pms.modules.tenant.form.TenantForm;
import com.zpache.pms.modules.tenant.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 17:30
 */
@RequiredArgsConstructor
@Service
public class TenantServiceImpl implements TenantService {
    private final SysTenantMapper sysTenantMapper;

    @Override
    public Page<SysTenant> list(TenantForm tenantForm) {
        Page<SysTenant> page = new Page<>(tenantForm.getPageNum(), tenantForm.getPageSize());
        return sysTenantMapper.selectPage(page, Wrappers.lambdaQuery(SysTenant.class)
                .like(SysTenant::getTenantName, tenantForm.getTenantName()));
    }

    @Override
    public SysTenant getById(Long id) {
        return sysTenantMapper.selectById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SysTenant save(TenantForm tenantForm) {
        if (tenantForm.getId() == null) {
            SysTenant sysTenant = new SysTenant();
            BeanUtils.copyProperties(tenantForm, sysTenant);
            return add(sysTenant);
        }
        SysTenant sysTenant = getById(tenantForm.getId());
        sysTenant.setTenantName(tenantForm.getTenantName());
        sysTenant.setTenantDesc(tenantForm.getTenantDesc());
        return update(sysTenant);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SysTenant add(SysTenant sysTenant) {
        int num = sysTenantMapper.insert(sysTenant);
        if (num == 0) {
            throw new ServiceException("新增租户系统失败");
        }
        return getById(sysTenant.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SysTenant update(SysTenant sysTenant) {
        int num = sysTenantMapper.updateById(sysTenant);
        if (num == 0) {
            throw new ServiceException("更新租户系统失败");
        }
        return getById(sysTenant.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        sysTenantMapper.deleteById(id);
    }
}
