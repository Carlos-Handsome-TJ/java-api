package com.springboot.springbootquickstart.pojo;

import lombok.Data;

import java.time.LocalDateTime;

// Category实体类
@Data
public class Category {
  private Integer id;
  private String categoryName;
  private String categoryAlia;
  private Integer createUser;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
}
