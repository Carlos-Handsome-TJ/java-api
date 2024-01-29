package com.springboot.springbootquickstart.pojo;

import lombok.Data;

import java.time.LocalDateTime;

// Article实体类
@Data
public class Article {
  private Integer id;
  private String title;
  private String content;
  private String coverImg;
  private String state;
  private Integer categoryId;
  private Integer createUser;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
}
