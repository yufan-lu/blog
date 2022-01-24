package com.lyf.blog.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyf.blog.admin.pojo.Admin;
import com.lyf.blog.admin.pojo.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminMapper extends BaseMapper<Admin> {
    @Select("select * from lyf_permission where id in (select permission_id from lyf_admin_permission where admin_id = #{adminId})")
    List<Permission> findPermissionById(Long adminId);
}
