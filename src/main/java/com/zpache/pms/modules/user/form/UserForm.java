package com.zpache.pms.modules.user.form;

import com.zpache.pms.common.base.QueryForm;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/29 17:25
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class UserForm extends QueryForm {
    private String name;
    private String mobile;
    private String email;
    private Long orgId;
    private Integer status;
}
