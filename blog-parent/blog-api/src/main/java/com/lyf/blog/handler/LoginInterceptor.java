package com.lyf.blog.handler;

import com.alibaba.fastjson.JSON;
import com.lyf.blog.dao.pojo.SysUser;
import com.lyf.blog.service.LoginService;
import com.lyf.blog.utils.UserThreadLocal;
import com.lyf.blog.vo.ErrorCode;
import com.lyf.blog.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)) return true;
        String token = request.getHeader("Authorization");
        SysUser sysUser = loginService.checkToken(token);
        if(StringUtils.isBlank((token)) || sysUser == null) {
            Result fail = Result.fail(ErrorCode.NO_LOGIN.getCode(), ErrorCode.NO_LOGIN.getMsg());
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().println(JSON.toJSONString(fail));
            return false;
        }
        UserThreadLocal.put(sysUser);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserThreadLocal.remove();
    }
}
