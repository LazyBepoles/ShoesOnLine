package com.ppwq.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SizeDao {

  int addNewSize(Double size);

  int deleteSize(int id);

  int addNewCommodity(
      @Param("sid") String sid, @Param("cid") int cid, @Param("stock") Object stock);

  int selectSize(@Param("sid") int sid, @Param("cid") int cid);

  int updateSizeNum(@Param("sid") int sid, @Param("cid") int cid, @Param("stock") int stock);
}
