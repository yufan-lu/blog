package com.lyf.blog.controller;

import com.lyf.blog.service.TagService;
import com.lyf.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tags")
public class TagController {

    private static final int HOT_LIMIT = 6;

    @Autowired
    private TagService tagService;

    @GetMapping("hot")
    public Result hot() {
        return tagService.hot(HOT_LIMIT);
    }

    @GetMapping
    public Result findAll() {
        return tagService.findAll();
    }

    @GetMapping("detail")
    public Result findAllDetail() {
        return tagService.findAllDetail();
    }

    @GetMapping("detail/{id}")
    public Result tagDetailById(@PathVariable("id") Long id) {
        return tagService.tagDetailById(id);
    }
}
