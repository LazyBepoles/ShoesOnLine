package com.ppwq.service;

import com.ppwq.pojo.Seller;

import java.util.List;

public interface SellerService {

    int insert (Seller seller, String filename);

    int delete (int sellerid);

    List<Seller> getAll();
}
