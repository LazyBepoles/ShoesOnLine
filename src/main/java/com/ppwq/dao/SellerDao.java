package com.ppwq.dao;

import com.ppwq.pojo.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SellerDao {

    int insertSeller (Seller seller);

    int delete (int sellerid);

    int insertpicname(@Param("sellerid") int sellerid,@Param("filename") String filename);

    List<Seller> getAll();
}
