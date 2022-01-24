package com.lyf.blog.controller;

import com.lyf.blog.utils.QiniuUtils;
import com.lyf.blog.vo.ErrorCode;
import com.lyf.blog.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private QiniuUtils qiniuUtils;

    @PostMapping
    public Result upload(@RequestParam("image") MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + "." + StringUtils.substringAfterLast(originalFilename, ".");

        boolean upload = qiniuUtils.upload(file, fileName);
        if(upload) {
            return Result.success(QiniuUtils.url + fileName);
        }
        return Result.fail(ErrorCode.UPLOAD_FAIL.getCode(), ErrorCode.UPLOAD_FAIL.getMsg());
    }
}
