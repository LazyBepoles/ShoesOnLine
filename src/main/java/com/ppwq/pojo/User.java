package com.ppwq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private Integer uid;
  private String username;
  private String password;
  private String name;
  private Integer sex;
  private String phone;
  private String email;
  private Integer purview;
  private Integer role;
  private Date createTime;
}
