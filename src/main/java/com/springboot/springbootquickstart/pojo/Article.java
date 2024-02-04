package com.springboot.springbootquickstart.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

// Article实体类
@Data
public class Article {
  private Integer id;
  @NotEmpty(message = "文章标题不能为空")
  private String title;
  @NotEmpty(message = "文章内容不能为空")
  private String content;
  @NotEmpty(message = "文章封面不能为空")
  private String coverImg;
  @NotEmpty(message = "发布状态不能为空")
  private String state;
  @NotEmpty(message = "文章分类不能为空")
  private Integer categoryId;
  private Integer createUser;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
}
