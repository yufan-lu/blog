package com.lyf.blog.service;

import com.lyf.blog.dao.pojo.SysUser;
import com.lyf.blog.vo.Result;
import com.lyf.blog.vo.params.LoginParams;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LoginService {
    Result login(LoginParams loginParams);

    SysUser checkToken(String token);

    Result logout(String token);

    Result register(LoginParams loginParams);
}
