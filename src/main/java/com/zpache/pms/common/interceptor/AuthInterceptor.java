package com.zpache.pms.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.zpache.pms.common.constant.PmsHeader;
import com.zpache.pms.common.constant.RedisKey;
import com.zpache.pms.common.exception.AuthException;
import com.zpache.pms.common.utils.TenantContextHolder;
import com.zpache.pms.entity.SysUser;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2024/1/15 16:25
 */
@Slf4j
public class AuthInterceptor implements AsyncHandlerInterceptor {

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 验证登录状态
        String token = request.getHeader(PmsHeader.TOKEN);
        if (StringUtils.isBlank(token) || Boolean.FALSE.equals(redisTemplate.hasKey(String.format(RedisKey.USER_TOKEN, token)))) {
            throw new AuthException("登录失效，请重新登录");
        }
        return true;
    }
}
