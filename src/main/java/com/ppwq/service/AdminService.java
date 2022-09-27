package com.ppwq.service;

import com.ppwq.pojo.User;

import java.util.Date;
import java.util.List;

public interface AdminService {

    int updateRole(int uid,int role);

    int updatePurview(int uid,int purview);

    int insertAdmin(User admin, Date time);

    User queryAdmin(int uid);

    List<User> getAllAdmin();

}
