package com.springboot.springbootquickstart.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

// Category实体类
@Data
public class Category {
  private Integer id;
  @NotEmpty(message = "分类名不能为空")
  private String categoryName;
  @NotEmpty(message = "分类别名不能为空")
  private String categoryAlias;
  private Integer createUser;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
}
