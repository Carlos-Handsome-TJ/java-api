package com.springboot.springbootquickstart.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

// Article实体类
@Data
public class Article {
  // 自定义参数校验
  @NotNull(message = "文章id不能为空", groups = {Update.class})
  private Integer id;
  @NotEmpty(message = "文章标题不能为空")
  @Pattern(regexp = "^\\S(1,10)$", message = "标题长度为1-10个字符长度")
  private String title;
  @NotEmpty(message = "文章内容不能为空")
  private String content;
  @NotEmpty(message = "文章封面不能为空")
  @URL
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
