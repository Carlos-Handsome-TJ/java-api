package com.springboot.springbootquickstart.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

// Category实体类
@Data
public class Category {
  @NotEmpty(message = "id不能为空")
  private Integer id;
  @NotEmpty(message = "分类名不能为空")
  private String categoryName;
  @NotEmpty(message = "分类别名不能为空")
  private String categoryAlias;
  private Integer createUser;
  @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
  private LocalDateTime createTime;
  @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
  private LocalDateTime updateTime;
}
