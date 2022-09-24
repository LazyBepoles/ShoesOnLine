package com.ppwq.service.impl;

import com.github.pagehelper.Page;
import com.ppwq.dao.TypeDao;
import com.ppwq.pojo.Type;
import com.ppwq.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

  @Autowired private TypeDao typeDao;

  @Override
  public int addNewType(Type type) {
    return this.typeDao.addNewType(type);
  }

  @Override
  public int updateType(Type type) {
    return this.typeDao.updateType(type);
  }

  @Override
  public Type searchTypeByName(String name) {
    return this.typeDao.searchTypeByName(name);
  }

  @Override
  public Type searchTypeById(int id) {
    return this.typeDao.searchTypeById(id);
  }

  @Override
  public Page<Type> searchTypeByPage() {
    return this.typeDao.searchTypeByPage();
  }

  @Override
  public int updateTypeStatus(int status,int tid) {
    return this.typeDao.updateTypeStatus(status,tid);
  }

  @Override
  public List<Type> searchAllType() {
    return this.typeDao.searchAllType();
  }
}
