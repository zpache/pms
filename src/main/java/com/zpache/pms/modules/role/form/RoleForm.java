package com.zpache.pms.modules.role.form;

import com.zpache.pms.common.base.QueryForm;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @desc:
 * @author: wangbing
 * @createTime: 2024/1/2 09:18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleForm extends QueryForm {
    private String roleName;
}
