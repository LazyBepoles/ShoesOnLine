package com.ppwq.service.impl;

import com.github.pagehelper.Page;
import com.ppwq.dao.UserDao;
import com.ppwq.pojo.User;
import com.ppwq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

  @Autowired private UserDao userDao;

  @Override
  public Page<User> searchUser(Map<String, Object> params) {
    return this.userDao.searchUser(params);
  }

  @Override
  public User searchUserById(int id) {
    return this.userDao.searchUserById(id);
  }

  @Override
  public int updateUser(User user) {
    return this.userDao.updateUser(user);
  }

  @Override
  public int register(User user) {
    if (this.userDao.searchUserExist(user).size() != 0) {
      return 0;
    }
    user.setCreateTime(new Date());
    return this.userDao.register(user);
  }

  @Override
  public User login(String account, String password) {
    return this.userDao.login(account, password);
  }

  @Override
  public Page<User> searchUserByPage() {
    return this.userDao.searchUserByPage();
  }

  @Override
  public int updateUserPurview(int purview,int uid) {
    return this.userDao.updateUserPurview(purview,uid);
  }

  @Override
  public int updatePassword(Map<String, Object> params) {
    User user = this.userDao.searchUserById((Integer) params.get("uid"));
    if (params.get("oldpassword").equals(user.getPassword())){
      return this.userDao.updatePassword(params);
    }else return 0;
  }
}
