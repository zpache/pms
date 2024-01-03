package com.zpache.pms.modules.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zpache.pms.entity.SysUser;
import com.zpache.pms.modules.user.form.LoginForm;
import com.zpache.pms.modules.user.form.UserForm;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/26 17:03
 */
public interface UserService {

    Page<SysUser> list(UserForm userForm);

    SysUser getById(Long id);

    SysUser getByUsername(String username);

    SysUser save(UserForm userForm);

    SysUser add(SysUser user);

    SysUser update(SysUser sysUser);

    void delete(Long id);

    Object login(LoginForm loginForm);
}
