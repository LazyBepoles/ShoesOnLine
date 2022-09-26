package com.ppwq.service;

import com.github.pagehelper.Page;
import com.ppwq.pojo.User;

import java.util.Map;

public interface UserService {

  Page<User> searchUser(Map<String, Object> params);

  User searchUserById(int id);

  int updateUser(User user);

  int register(User user);

  User login(String account, String password);

  Page<User> searchUserByPage();

  int updateUserPurview(int purview,int uid);

  int updatePassword(Map<String, Object> params);
}
