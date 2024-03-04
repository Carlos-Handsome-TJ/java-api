package com.springboot.blog.controller;

import com.springboot.blog.pojo.Result;
import com.springboot.blog.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class fileUpLoadController {
  @PostMapping("/upload")
  public Result<String> upload(MultipartFile file) throws Exception {
    // 获取文件内容的输入流，写入到本地磁盘中
    String originFilename = file.getOriginalFilename();
    String filename = UUID.randomUUID() + originFilename.substring(originFilename.lastIndexOf("."));
    String picUrl = AliOssUtil.uploadFile(filename, file.getInputStream());
    return Result.success(picUrl);
  }
}
