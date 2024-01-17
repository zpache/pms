package com.zpache.pms.modules.user.dto;

import lombok.Data;

import java.util.List;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2024/1/16 18:27
 */
@Data
public class UserInfoDTO {
    private List<String> roles;
    private String name;
    private String avatar;
    private String introduction;
}
