package com.zpache.pms.modules.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zpache.pms.common.exception.ServiceException;
import com.zpache.pms.entity.SysUser;
import com.zpache.pms.mapper.SysUserMapper;
import com.zpache.pms.modules.user.form.LoginForm;
import com.zpache.pms.modules.user.form.UserForm;
import com.zpache.pms.modules.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 17:03
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final SysUserMapper sysUserMapper;

    @Override
    public Page<SysUser> list(UserForm userForm) {
        Page<SysUser> page = new Page<>(userForm.getPageNum(), userForm.getPageSize());
        return sysUserMapper.selectPage(page, Wrappers.lambdaQuery(SysUser.class)
                .eq(StringUtils.isNotBlank(userForm.getName()), SysUser::getName, userForm.getName())
                .eq(StringUtils.isNotBlank(userForm.getMobile()), SysUser::getMobile, userForm.getMobile())
                .eq(userForm.getStatus() != null, SysUser::getStatus, userForm.getStatus()));
    }

    @Override
    public SysUser getById(Long id) {
        return sysUserMapper.selectById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SysUser getByUsername(String loginAccount) {
        return sysUserMapper.selectOne(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getLoginAccount, loginAccount));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SysUser save(UserForm userForm) {
        if (userForm.getId() == null) {
            SysUser sysUser = new SysUser();
            BeanUtils.copyProperties(userForm, sysUser);
            // 设置userId
            sysUser.setUserId("");
            // 设置密码
            sysUser.setPassword(new Random().nextInt(10) + "");
            return add(sysUser);
        }
        SysUser sysUser = getById(userForm.getId());
        sysUser.setAvatar("");
        sysUser.setName("");
        sysUser.setMobile("");
        sysUser.setWorkNo("");
        return update(sysUser);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SysUser add(SysUser user) {
        int num = sysUserMapper.insert(user);
        if (num == 0) {
            throw new ServiceException("新增失败");
        }
        return getById(user.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SysUser update(SysUser sysUser) {
        int num = sysUserMapper.updateById(sysUser);
        if (num == 0) {
            throw new ServiceException("更新失败");
        }
        return getById(sysUser.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        sysUserMapper.deleteById(id);
    }

    @Override
    public Object login(LoginForm loginForm) {
        return null;
    }
}
