package com.springboot.springbootquickstart.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;

import java.time.LocalDateTime;

// Article实体类
@Data
public class Article {
  @NotNull(message = "文章id不能为空", groups = {Update.class})
  private Integer id;
  @NotNull(message = "文章标题不能为空")
  private String title;
  @NotNull(message = "文章内容不能为空")
  private String content;
  @NotNull(message = "文章封面不能为空")
  private String coverImg;
  @NotNull(message = "发布状态不能为空")
  private String state;
  @NotNull(message = "文章分类不能为空")
  private Integer categoryId;
  @NotNull(message = "创建用户不能为空")
  private Integer createUser;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

  public interface Add extends Default {
  }

  public interface Update extends Default {
  }
}
