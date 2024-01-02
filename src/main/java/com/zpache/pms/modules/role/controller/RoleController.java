package com.zpache.pms.modules.role.controller;

import com.zpache.pms.common.base.PmsResult;
import com.zpache.pms.common.utils.ResultUtils;
import com.zpache.pms.modules.role.form.RoleForm;
import com.zpache.pms.modules.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 17:05
 */
@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping("/list")
    public PmsResult list(@RequestBody RoleForm roleForm) {
        return ResultUtils.success(roleService.list(roleForm));
    }


    @PostMapping("/save")
    public PmsResult save(@RequestBody RoleForm roleForm) {
        return ResultUtils.success(roleService.save(roleForm));
    }

    @PostMapping("/delete")
    public PmsResult delete(@RequestBody RoleForm roleForm) {
        roleService.delete(roleForm.getId());
        return ResultUtils.success();
    }

}
