package com.zpache.pms.modules.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zpache.pms.common.constant.RedisKey;
import com.zpache.pms.common.exception.ServiceException;
import com.zpache.pms.common.utils.Md5Utils;
import com.zpache.pms.entity.SysUser;
import com.zpache.pms.mapper.SysUserMapper;
import com.zpache.pms.modules.user.dto.TokenDTO;
import com.zpache.pms.modules.user.enums.UserStatusEnums;
import com.zpache.pms.modules.user.form.LoginForm;
import com.zpache.pms.modules.user.form.UserForm;
import com.zpache.pms.modules.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 17:03
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final SysUserMapper sysUserMapper;
    private final RedisTemplate redisTemplate;

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
    public TokenDTO login(LoginForm loginForm) {
        SysUser sysUser = sysUserMapper.selectOne(Wrappers.lambdaQuery(SysUser.class)
                .eq(SysUser::getLoginAccount, loginForm.getUsername()));
        if (sysUser == null) {
            throw new ServiceException("用户名或密码错误");
        } else if (UserStatusEnums.NORMAL.status.equals(sysUser.getStatus())) {
            throw new ServiceException(String.format("当前账号已被%s", Objects.requireNonNull(UserStatusEnums.getEnumByStatus(sysUser.getStatus())).desc));
        }
        // 密码校验
        String password = String.format("%s%s%s", sysUser.getSalt(), loginForm.getPassword(), sysUser.getSalt());
        if (!sysUser.getPassword().equals(Md5Utils.md5(password))) {
            throw new ServiceException("用户名或密码错误");
        }
        // 生成token
        String token = UUID.randomUUID().toString().replace("-", "");
        redisTemplate.opsForValue().set(String.format(RedisKey.USER_TOKEN, token), sysUser, 7200L, TimeUnit.SECONDS);
        return new TokenDTO(token);
    }
}
