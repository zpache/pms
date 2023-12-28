package com.zpache.pms.modules.organization.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zpache.pms.common.exception.ServiceException;
import com.zpache.pms.entity.Organization;
import com.zpache.pms.mapper.OrganizationMapper;
import com.zpache.pms.modules.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 17:07
 */
@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationMapper organizationMapper;

    @Override
    public List<Organization> findAll() {
        return organizationMapper.selectList(Wrappers.emptyWrapper());
    }

    @Override
    public Organization findById(Long id) {
        return organizationMapper.selectById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Organization add(Organization organization) {
        int num = organizationMapper.insert(organization);
        if (num == 0) {
            throw new ServiceException("新增机构失败");
        }
        return findById(organization.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Organization update(Organization organization) {
        int num = organizationMapper.updateById(organization);
        if (num == 0) {
            throw new ServiceException("更新机构失败");
        }
        return findById(organization.getId());
    }

    @Override
    public boolean deleteById(Long id) {
        int num = organizationMapper.deleteById(id);
        if (num == 0) {
            throw new ServiceException("删除机构失败");
        }
        return true;
    }
}
