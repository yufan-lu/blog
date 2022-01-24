package com.lyf.blog.service;

import com.lyf.blog.vo.Result;
import com.lyf.blog.vo.TagVo;

import java.util.List;

public interface TagService {

    List<TagVo> findTagsByArticleId(Long articleId);

    Result hot(int hotLimit);

    Result findAll();

    Result findAllDetail();

    Result tagDetailById(Long id);
}
