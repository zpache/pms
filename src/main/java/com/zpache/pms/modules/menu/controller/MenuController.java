package com.zpache.pms.modules.menu.controller;

import com.zpache.pms.common.base.PmsResult;
import com.zpache.pms.common.utils.ResultUtils;
import com.zpache.pms.modules.menu.form.MenuForm;
import com.zpache.pms.modules.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 17:06
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/menu")
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/list")
    public PmsResult list(@RequestBody MenuForm menuForm) {
        return ResultUtils.success(menuService.list(menuForm));
    }

    @PostMapping("/save")
    public PmsResult save(@RequestBody MenuForm menuForm) {
        return ResultUtils.success(menuService.save(menuForm));
    }

    @PostMapping("/delete")
    public PmsResult delete(@RequestBody MenuForm menuForm) {
        menuService.delete(menuForm.getId());
        return ResultUtils.success();
    }
}
