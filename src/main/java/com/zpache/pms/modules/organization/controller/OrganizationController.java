package com.zpache.pms.modules.organization.controller;

import com.zpache.pms.common.base.PmsResult;
import com.zpache.pms.common.utils.ResultUtils;
import com.zpache.pms.entity.Organization;
import com.zpache.pms.modules.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 17:07
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/organization")
public class OrganizationController {
    private final OrganizationService organizationService;

    @PostMapping("/list")
    public PmsResult list() {
        return ResultUtils.success(organizationService.findAll());
    }


    @PostMapping("/add")
    public PmsResult add(@RequestBody Organization organization) {
        return ResultUtils.success(organizationService.add(organization));
    }

    @PostMapping("/delete")
    public PmsResult delete(@RequestBody Organization organization) {
        organizationService.deleteById(organization.getId());
        return ResultUtils.success();
    }


}
