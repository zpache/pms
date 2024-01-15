package com.zpache.pms.common.config;

import com.zpache.pms.common.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @author: wangbing
 * @createTime: 2024/1/15 16:35
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    private static final List<String> INCLUDE_PATHS = new ArrayList<>();
    private static final List<String> EXCLUDE_PATHS = new ArrayList<>();

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor())
                .addPathPatterns(INCLUDE_PATHS)
                .excludePathPatterns(EXCLUDE_PATHS);
    }

    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    static {
        INCLUDE_PATHS.add("/api/**");

        EXCLUDE_PATHS.add("/api/platform/**");
    }
}
