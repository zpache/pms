package com.zpache.pms.modules.user.controller;

import com.zpache.pms.common.base.PmsResult;
import com.zpache.pms.common.utils.ResultUtils;
import com.zpache.pms.modules.user.form.LoginForm;
import com.zpache.pms.modules.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2024/1/3 10:01
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/platform")
public class LoginController {
    private UserService userService;

    /**
     * 登录
     * @param loginForm 登录表单
     * @return 返回结果
     */
    @PostMapping(value = "/login")
    public PmsResult login(@RequestBody LoginForm loginForm) {
        return ResultUtils.success(userService.login(loginForm));
    }

    /**
     * 获取用户信息
     * @param token 令牌
     * @return 返回结果
     */
    @PostMapping(value = "/userInfo")
    public PmsResult userInfo(@RequestParam("token") String token) {
        return ResultUtils.success();
    }

    /**
     * 登出
     * @return 返回结果
     */
    @PostMapping(value = "/logout")
    public PmsResult logout() {
        return ResultUtils.success();
    }
}
