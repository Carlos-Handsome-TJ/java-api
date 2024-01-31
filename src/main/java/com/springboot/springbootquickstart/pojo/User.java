package com.springboot.springbootquickstart.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

// User实体类
@Data
public class User {
  @NotNull
  private Integer id;
  @NotEmpty
  private String username;
  @JsonIgnore
  private String password;
  @Pattern(regexp = "^\\S{5,16}$")
  private String nickname;
  @NotEmpty
  @Email
  private String email;
  private String userPic;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

}