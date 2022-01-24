package com.lyf.blog.admin.service;

import com.lyf.blog.admin.pojo.Admin;
import com.lyf.blog.admin.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    private AdminService adminService;

    public boolean auth(HttpServletRequest request, Authentication authentication) {
        String requestURI = request.getRequestURI();
        requestURI = requestURI.split("\\?")[0];
        Object principal = authentication.getPrincipal();
        if(principal == null || "anonymousUser".equals(principal)) return false;
        UserDetails userDetails = (UserDetails) principal;
        Admin admin = adminService.findAdminByUsername((userDetails.getUsername()));
        if(admin == null) return false;
        if(1 == admin.getId()) return true;
        List<Permission> permissionList = adminService.findPermissionById(admin.getId());
        for (Permission permission : permissionList) {
            if(requestURI.equals(permission.getPath())) return true;
        }
        return false;
    }
}
