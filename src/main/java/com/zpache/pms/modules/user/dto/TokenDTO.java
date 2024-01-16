package com.zpache.pms.modules.user.dto;

import lombok.Data;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2024/1/15 17:54
 */
@Data
public class TokenDTO {
    private String token;

    public TokenDTO() {
    }

    public TokenDTO(String token) {
        this.token = token;
    }
}
