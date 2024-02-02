package com.springboot.springbootquickstart.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

// User实体类
@Data
public class User {
  @NotNull
  private Integer id;
  @NotBlank(message = "用户名不能为空")
  private String username;
  @JsonIgnore
  private String password;
  @Pattern(regexp = "^\\S{5,16}$")
  private String nickname;
  @NotBlank(message = "email不能为空")
  @Email
  private String email;
  private String userPic;
  @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
  private LocalDateTime createTime;
  @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
  private LocalDateTime updateTime;

}