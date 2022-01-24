package com.lyf.blog.service;

import com.lyf.blog.dao.pojo.SysUser;
import com.lyf.blog.vo.Result;
import com.lyf.blog.vo.UserVo;

public interface SysUserService {

    UserVo findUserVoById(long id);

    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

    Result findUserByToken(String token);

    SysUser findUserByAccount(String account);

    void save(SysUser sysUser);
}
