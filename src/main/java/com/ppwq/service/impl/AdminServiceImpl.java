package com.ppwq.service.impl;

import com.ppwq.dao.AdminDao;
import com.ppwq.pojo.User;
import com.ppwq.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    public int updateRole(int uid,int role){return this.adminDao.updateRole(uid,role);}

    public int updatePurview(int uid,int purview){return this.adminDao.updatePurview(uid, purview);}

    public int insertAdmin(User admin, Date time){
        admin.setCreateTime(time);
        return this.adminDao.insertAdmin(admin);}

    public User queryAdmin(int uid) {
        User users = this.adminDao.queryAdmin(uid);
        System.out.println(users);
        return users;
    }

    public List<User> getAllAdmin() {
        List<User> users = this.adminDao.getAllAdmin();
        System.out.println(users);
        return users;
    }
}
