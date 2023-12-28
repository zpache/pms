package com.zpache.pms.modules.menu.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zpache.pms.common.exception.ServiceException;
import com.zpache.pms.entity.SysMenu;
import com.zpache.pms.mapper.SysMenuMapper;
import com.zpache.pms.modules.menu.form.MenuForm;
import com.zpache.pms.modules.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 17:06
 */
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final SysMenuMapper sysMenuMapper;

    @Override
    public Page<SysMenu> list(MenuForm menuForm) {
        Page page = new Page(menuForm.getPageNum(), menuForm.getPageSize());
        return sysMenuMapper.selectPage(page, Wrappers.lambdaQuery(SysMenu.class)
                .eq(StringUtils.isNotBlank(menuForm.getName()), SysMenu::getName, menuForm.getName())
                .like(StringUtils.isNotBlank(menuForm.getPermission()), SysMenu::getPermission, menuForm.getPermission()));
    }

    @Override
    public SysMenu getById(Long id) {
        return sysMenuMapper.selectById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SysMenu save(MenuForm menuForm) {
        if (menuForm.getId() == null) {
            SysMenu sysMenu = new SysMenu();
            return add(sysMenu);
        } else {
            SysMenu sysMenu = getById(menuForm.getId());
            sysMenu.setName(menuForm.getName());
            sysMenu.setPermission(menuForm.getPermission());
            sysMenu.setSort(menuForm.getSort());
            sysMenu.setPath(menuForm.getPath());
            sysMenu.setIcon(menuForm.getIcon());
            return update(sysMenu);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SysMenu add(SysMenu sysMenu) {
        int num = sysMenuMapper.insert(sysMenu);
        if (num == 0) {
            throw new ServiceException("新增菜单失败");
        }
        return getById(sysMenu.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SysMenu update(SysMenu sysMenu) {
        int num = sysMenuMapper.updateById(sysMenu);
        if (num == 0) {
            throw new ServiceException("更新菜单失败");
        }
        return getById(sysMenu.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        int num = sysMenuMapper.deleteById(id);
        if (num == 0) {
            throw new ServiceException("删除菜单失败");
        }
    }
}
