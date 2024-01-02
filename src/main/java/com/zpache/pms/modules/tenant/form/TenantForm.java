package com.zpache.pms.modules.tenant.form;

import com.zpache.pms.common.base.QueryForm;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/29 17:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TenantForm extends QueryForm {
    private String tenantName;
    private String tenantDesc;
}
