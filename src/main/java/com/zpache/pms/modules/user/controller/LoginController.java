package com.zpache.pms.modules.user.controller;

import com.zpache.pms.common.base.PmsResult;
import com.zpache.pms.common.utils.ResultUtils;
import com.zpache.pms.modules.user.form.LoginForm;
import com.zpache.pms.modules.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2024/1/3 10:01
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class LoginController {
    private UserService userService;

    @PostMapping
    public PmsResult login(@RequestBody LoginForm loginForm) {
        return ResultUtils.success(userService.login(loginForm));
    }
}
