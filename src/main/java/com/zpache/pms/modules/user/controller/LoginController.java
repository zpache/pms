package com.zpache.pms.modules.user.controller;

import com.zpache.pms.common.base.PmsResult;
import com.zpache.pms.common.constant.PmsHeader;
import com.zpache.pms.common.utils.ResultUtils;
import com.zpache.pms.common.utils.TenantContextHolder;
import com.zpache.pms.modules.user.dto.UserInfoDTO;
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
@RequestMapping("/api/admin")
public class LoginController {
    private final UserService userService;

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
     * @return 返回结果
     */
    @PostMapping(value = "/userInfo")
    public PmsResult userInfo() {
        UserInfoDTO userInfoDTO = userService.getUserInfo(TenantContextHolder.getUser().getId());
        return ResultUtils.success(userInfoDTO);
    }

    /**
     * 登出
     *
     * @return 返回结果
     */
    @PostMapping(value = "/logout")
    public PmsResult logout(@RequestHeader(PmsHeader.TOKEN) String token) {
        userService.logout(token);
        return ResultUtils.success();
    }
}
