package com.zpache.pms.modules.role.service.impl;

import com.zpache.pms.common.exception.ServiceException;
import com.zpache.pms.entity.SysUserRole;
import com.zpache.pms.mapper.SysUserRoleMapper;
import com.zpache.pms.modules.role.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2024/1/3 09:46
 */
@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final SysUserRoleMapper sysUserRoleMapper;
    
    @Override
    public List<SysUserRole> findList() {
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(SysUserRole userRole) {
        int num = sysUserRoleMapper.insert(userRole);
        if (num == 0) {
            throw new ServiceException("添加用户角色失败");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(SysUserRole userRole) {
        int num = sysUserRoleMapper.updateById(userRole);
        if (num == 0) {
            throw new ServiceException("更新用户角色失败");
        }
    }
}
