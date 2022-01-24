package com.lyf.blog.service;

import com.lyf.blog.vo.Result;
import com.lyf.blog.vo.params.CommentParam;

public interface CommentService {
    Result commentsByArticleId(Long id);

    Result comment(CommentParam commentParam);
}
