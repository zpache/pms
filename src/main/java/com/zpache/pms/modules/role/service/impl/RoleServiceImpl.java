package com.zpache.pms.modules.role.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zpache.pms.common.exception.ServiceException;
import com.zpache.pms.entity.SysRole;
import com.zpache.pms.mapper.SysRoleMapper;
import com.zpache.pms.modules.role.form.RoleForm;
import com.zpache.pms.modules.role.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 17:05
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final SysRoleMapper sysRoleMapper;

    @Override
    public Page<SysRole> list(RoleForm roleForm) {
        Page page = new Page(roleForm.getPageNum(), roleForm.getPageSize());
        return sysRoleMapper.selectPage(page, Wrappers.lambdaQuery(SysRole.class)
                .eq(StringUtils.isNotBlank(roleForm.getRoleName()),SysRole::getRoleName, roleForm.getRoleName()));
    }

    @Override
    public SysRole getById(Long id) {
        return sysRoleMapper.selectById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SysRole save(RoleForm roleForm) {
        if (roleForm.getId() == null) {
            SysRole sysRole = new SysRole();
            sysRole.setRoleName(roleForm.getRoleName());
            return add(sysRole);
        } else {
            SysRole sysRole = getById(roleForm.getId());
            if (sysRole != null) {
                sysRole.setRoleName(roleForm.getRoleName());
                return update(sysRole);
            } else {
                throw new ServiceException("角色不存在");
            }
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SysRole add(SysRole sysRole) {
        int num = sysRoleMapper.insert(sysRole);
        if (num == 0) {
            throw new ServiceException("新增角色失败");
        }
        return getById(sysRole.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SysRole update(SysRole sysRole) {
        int num = sysRoleMapper.updateById(sysRole);
        if (num == 0) {
            throw new ServiceException("更新角色失败");
        }
        return getById(sysRole.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        sysRoleMapper.deleteById(id);
    }
}
