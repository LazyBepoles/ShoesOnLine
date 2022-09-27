package com.ppwq.dao;

import com.ppwq.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
@Mapper
public interface AdminDao {

    int updateRole(@PathVariable("uid") int uid, @PathVariable("role") int role);

    int updatePurview(@PathVariable("uid") int uid,@PathVariable("purview") int purview);

    int insertAdmin(User admin);

    User queryAdmin(int uid);

    List<User> getAllAdmin();

}
