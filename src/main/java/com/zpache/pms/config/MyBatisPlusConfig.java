package com.zpache.pms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @desc:
 * @author: wangbing
 * @createTime: 2023/12/26 16:10
 */
@Configuration
@MapperScan("com.zpache.pms.mapper")
public class MyBatisPlusConfig {
}
