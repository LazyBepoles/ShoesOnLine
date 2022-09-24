package com.ppwq.service.impl;

import com.ppwq.dao.SizeDao;
import com.ppwq.pojo.Size;
import com.ppwq.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeDao sizeDao;

    @Override
    public int addNewSize(Size size) {
        return this.sizeDao.addNewSize(size);
    }

    @Override
    public int deleteSize(int id) {
        return this.sizeDao.deleteSize(id);
    }
}
