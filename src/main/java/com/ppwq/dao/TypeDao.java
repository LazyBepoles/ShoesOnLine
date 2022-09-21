package com.ppwq.dao;

import com.github.pagehelper.Page;
import com.ppwq.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TypeDao {

  int addNewType(Type type);

  int updateType(Type type);

  Type searchTypeByName(String name);

  Page<Type> searchTypeByPage();

  Type searchTypeById(int id);

  int updateTypeStatus(int status);

  List<Type> searchAllType();
}
