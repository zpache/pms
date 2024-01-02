package com.zpache.pms.modules.menu.form;

import com.zpache.pms.common.base.QueryForm;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/28 16:09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MenuForm extends QueryForm {
    private String name;
    private String permission;
    private String path;
    private String icon;
    private Integer type;
    private String remark;
    private Integer sort;
}
