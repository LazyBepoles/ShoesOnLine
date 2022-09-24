package com.ppwq.service;

import com.github.pagehelper.Page;
import com.ppwq.pojo.Type;

import java.util.List;

public interface TypeService {

  int addNewType(Type type);

  int updateType(Type type);

  Type searchTypeByName(String name);

  Type searchTypeById(int id);

  Page<Type> searchTypeByPage();

  int updateTypeStatus(int status,int tid);

  List<Type> searchAllType();
}
