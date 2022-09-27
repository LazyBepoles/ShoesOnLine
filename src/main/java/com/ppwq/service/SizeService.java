package com.ppwq.service;

import com.github.pagehelper.Page;
import com.ppwq.pojo.Size;

public interface SizeService {

    int addNewSize(Size size);

    int deleteSize(int id);

    Page<Size> getAllSize();
}
