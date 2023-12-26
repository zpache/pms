package com.zpache.pms.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 16:10
 */
@Configuration
@MapperScan("com.zpache.pms.mapper")
public class MyBatisPlusConfig {
}
