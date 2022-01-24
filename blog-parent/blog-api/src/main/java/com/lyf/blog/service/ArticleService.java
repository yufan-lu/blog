package com.lyf.blog.service;

import com.lyf.blog.vo.Result;
import com.lyf.blog.vo.params.ArticleParam;
import com.lyf.blog.vo.params.PageParams;

public interface ArticleService {
    /**
     * find articles list by pages
     * @param pageParams
     * @return
     */
    Result listArticle(PageParams pageParams);

    Result hotArticle(int limit);

    Result newArticle(int limit);

    Result listArchives();

    Result findArticleById(Long articleId);

    Result publish(ArticleParam articleParam);
}
