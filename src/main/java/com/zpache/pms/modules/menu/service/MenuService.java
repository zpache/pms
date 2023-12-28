package com.zpache.pms.modules.menu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zpache.pms.entity.SysMenu;
import com.zpache.pms.modules.menu.form.MenuForm;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 17:06
 */
public interface MenuService {

    Page<SysMenu> list(MenuForm menuForm);

    SysMenu getById(Long id);

    SysMenu save(MenuForm menuForm);

    SysMenu add(SysMenu sysMenu);

    SysMenu update(SysMenu sysMenu);

    void delete(Long id);
}
