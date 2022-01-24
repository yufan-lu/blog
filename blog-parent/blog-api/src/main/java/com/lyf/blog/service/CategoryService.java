package com.lyf.blog.service;

import com.lyf.blog.dao.pojo.Category;
import com.lyf.blog.vo.CategoryVo;
import com.lyf.blog.vo.Result;

public interface CategoryService {
    CategoryVo findCategoryById(Long categoryId);

    Result findAll();

    Result findAllDetail();

    Result categoryDetailById(Long id);
}
