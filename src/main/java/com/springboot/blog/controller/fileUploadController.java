package com.springboot.blog.controller;

import com.springboot.blog.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class fileUploadController {
  @PostMapping("/upload")
  public Result<String> upload(MultipartFile file) throws IOException {
    // 获取文件内容的输入流，写入到本地磁盘中
    String originFilename = file.getOriginalFilename();
    String filename = UUID.randomUUID() + originFilename.substring(originFilename.lastIndexOf("."));
    file.transferTo(new File("C:\\Users\\Administrator\\Desktop\\file\\" + filename));
    return Result.success("访问url地址....");
  }
}
