package com.springboot.springbootquickstart.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

// User实体类
@Data
public class User {
  private Integer id;
  private String username;
  @JsonIgnore
  private String password;
  private String nickname;
  private String email;
  private String userPic;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;

}