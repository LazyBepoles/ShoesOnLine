package com.ppwq.dao;

import com.github.pagehelper.Page;
import com.ppwq.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {

  int register(User user);

  int updateUser(User user);

  Page<User> searchUser(
      @Param("username") String username, @Param("name") String name, @Param("email") String email);

  List<User> searchUserExist(User user);

  User searchUserById(int id);

  User login(@Param("account") String account, @Param("password") String password);

  Page<User> searchUserByPage();

  int updateUserPurview(int purview);
}
