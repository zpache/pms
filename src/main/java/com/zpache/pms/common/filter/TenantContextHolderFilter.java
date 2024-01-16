package com.zpache.pms.common.filter;

import com.alibaba.fastjson.JSON;
import com.zpache.pms.common.constant.PmsHeader;
import com.zpache.pms.common.constant.RedisKey;
import com.zpache.pms.common.utils.TenantContextHolder;
import com.zpache.pms.entity.SysUser;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
public class TenantContextHolderFilter extends GenericFilterBean {
    private final RedisTemplate redisTemplate;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = request.getHeader(PmsHeader.TOKEN);
        if (StringUtils.isNotBlank(token)) {
            String object = (String) redisTemplate.opsForValue().get(String.format(RedisKey.USER_TOKEN, token));
            if (StringUtils.isNotBlank(object)) {
                // 获取用户信息
                SysUser sysUser = JSON.parseObject(object, SysUser.class);
                // 设置租户信息
                TenantContextHolder.setUser(sysUser);
            }

        }
        filterChain.doFilter(request, response);
        TenantContextHolder.clear();
    }

    public TenantContextHolderFilter(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
