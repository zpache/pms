package com.zpache.pms.modules.tenant.controller;

import com.zpache.pms.common.base.PmsResult;
import com.zpache.pms.common.utils.ResultUtils;
import com.zpache.pms.modules.tenant.form.TenantForm;
import com.zpache.pms.modules.tenant.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 17:13
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tenant")
public class TenantController {

    private final TenantService tenantService;

    @PostMapping("/list")
    public PmsResult list(@RequestBody TenantForm tenantForm) {
        return ResultUtils.success(tenantService.list(tenantForm));
    }

    @PostMapping("/detail")
    public PmsResult detail(@RequestBody TenantForm tenantForm) {
        return ResultUtils.success(tenantService.getById(tenantForm.getId()));
    }

    @PostMapping("/save")
    public PmsResult save(@RequestBody TenantForm tenantForm) {
        return ResultUtils.success(tenantService.save(tenantForm));
    }

    @PostMapping("/delete")
    public PmsResult delete(@RequestBody TenantForm tenantForm) {
        tenantService.delete(tenantForm.getId());
        return ResultUtils.success();
    }

}
