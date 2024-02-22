package com.springboot.springbootquickstart.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

// Category实体类
@Data
public class Category {
  @NotNull(message = "id不能为空", groups = {Update.class})
  private Integer id;
  @NotNull(message = "分类名不能为空", groups = {Add.class, Update.class})
  private String categoryName;
  @NotNull(message = "分类别名不能为空", groups = {Add.class, Update.class})
  private String categoryAlias;
  private Integer createUser;
  @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
  private LocalDateTime createTime;
  @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
  private LocalDateTime updateTime;

  public interface Add {

  }

  public interface Update {

  }
}
