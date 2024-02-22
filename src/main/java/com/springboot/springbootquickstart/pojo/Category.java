package com.springboot.springbootquickstart.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

// Category实体类
@Data
public class Category {
  private Integer id;
  @NotEmpty
  private String categoryName;
  @NotEmpty
  private String categoryAlia;
  private Integer createUser;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
}
