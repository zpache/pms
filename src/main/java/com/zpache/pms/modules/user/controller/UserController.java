package com.zpache.pms.modules.user.controller;

import com.zpache.pms.common.base.PmsResult;
import com.zpache.pms.common.utils.ResultUtils;
import com.zpache.pms.modules.user.form.UserForm;
import com.zpache.pms.modules.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 17:03
 */
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/list")
    public PmsResult list(@RequestBody UserForm userForm) {
        return ResultUtils.success(userService.list(userForm));
    }

    @PostMapping("/detail")
    public PmsResult detail(@RequestBody UserForm userForm) {
        return ResultUtils.success(userService.getById(userForm.getId()));
    }

    @PostMapping("/save")
    public PmsResult save(@RequestBody UserForm userForm) {
        return ResultUtils.success(userService.save(userForm));
    }

    @PostMapping("/delete")
    public PmsResult delete(@RequestBody UserForm userForm) {
        userService.delete(userForm.getId());
        return ResultUtils.success();
    }
}
