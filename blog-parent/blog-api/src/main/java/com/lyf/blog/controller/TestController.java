package com.lyf.blog.controller;

import com.lyf.blog.dao.pojo.SysUser;
import com.lyf.blog.utils.UserThreadLocal;
import com.lyf.blog.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping
    public Result test() {
        SysUser sysUser = UserThreadLocal.get();
        System.out.println(sysUser);
        return Result.success(null);
    }
}
