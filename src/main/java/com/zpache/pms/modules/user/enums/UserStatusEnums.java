package com.zpache.pms.modules.user.enums;

import java.util.Objects;

/**
 * @desc:
 * @author: wangbing
 * @createTime: 2024/1/16 16:34
 */
public enum UserStatusEnums {
    NORMAL(1, "在职（正常）"),
    LEAVED(2, "离职（无效）"),
    LOCKED(3, "锁定（暂停使用）"),;

    public final Integer status;
    public final String desc;

    UserStatusEnums(Integer status, String desc) {
        this.desc = desc;
        this.status = status;
    }

    public static UserStatusEnums getEnumByStatus(Integer status) {
        for (UserStatusEnums userStatusEnum : UserStatusEnums.values()) {
            if (Objects.equals(userStatusEnum.status, status)) {
                return userStatusEnum;
            }
        }
        return null;
    }
}
