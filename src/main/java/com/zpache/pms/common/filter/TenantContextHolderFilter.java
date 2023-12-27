package com.zpache.pms.common.filter;

import com.zpache.pms.common.exception.AuthException;
import com.zpache.pms.common.handler.TenantContextHolder;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/27 09:57
 */
@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
public class TenantContextHolderFilter extends GenericFilterBean {
    private final RedisTemplate redisTemplate;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = request.getHeader("token");
        if (token != null) {
            Object object = redisTemplate.opsForValue().get(token);
            if (object == null) {
                throw new AuthException("登录超时");
            }
            // 获取用户信息
            // 设置租户信息
            TenantContextHolder.setTenantId("");
        }
        filterChain.doFilter(request, response);
        TenantContextHolder.clear();
    }
}
