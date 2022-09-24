package com.ppwq.service;

import com.github.pagehelper.Page;
import com.ppwq.pojo.User;

public interface UserService {

  Page<User> searchUser(String username, String name, String email);

  User searchUserById(int id);

  int updateUser(User user);

  int register(User user);

  User login(String account, String password);

  Page<User> searchUserByPage();

  int updateUserPurview(int purview,int uid);
}
