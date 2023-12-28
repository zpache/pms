package com.zpache.pms.modules.organization.service;

import com.zpache.pms.entity.Organization;

import java.util.List;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 17:07
 */
public interface OrganizationService {

    List<Organization> findAll();

    Organization findById(Long id);

    Organization add(Organization organization);

    Organization update(Organization organization);

    boolean deleteById(Long id);

}
