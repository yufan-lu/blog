package com.lyf.blog.controller;

import com.lyf.blog.common.aop.LogAnnotation;
import com.lyf.blog.common.cache.Cache;
import com.lyf.blog.service.ArticleService;
import com.lyf.blog.vo.Result;
import com.lyf.blog.vo.params.ArticleParam;
import com.lyf.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("articles")
public class ArticleController {

    private final int LIMIT = 5;

    @Autowired
    private ArticleService articleService;

    /**
     * headpag/articles/list
     * @param pageParams
     * @return
     */
    @PostMapping
    @LogAnnotation(module = "article", operator = "listArticle")
    @Cache(expire = 5 * 60 * 1000, name = "list_article")
    public Result listArticle(@RequestBody PageParams pageParams) {
        return articleService.listArticle(pageParams);
    }

    @PostMapping("hot")
    @Cache(expire = 5 * 60 * 1000, name = "hot_article")
    public Result hotArticle() {
        return articleService.hotArticle(LIMIT);
    }

    @PostMapping("new")
    @Cache(expire = 5 * 60 * 1000, name = "new_article")
    public Result newArticle() {
        return articleService.newArticle(LIMIT);
    }

    @PostMapping("listArchives")
    public Result listArchives() {
        return articleService.listArchives();
    }

    @PostMapping("view/{id}")
    public Result findArticleById(@PathVariable("id") Long articleId) {
        return articleService.findArticleById(articleId);
    }

    @PostMapping("publish")
    public Result publish(@RequestBody ArticleParam articleParam) {
        return articleService.publish(articleParam);
    }

}
