package com.ppwq.service.impl;

import com.ppwq.dao.SellerDao;
import com.ppwq.pojo.Seller;
import com.ppwq.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerDao sellerDao;

    public int insert(Seller seller, String filename) {
        this.sellerDao.insertSeller(seller);
        this.sellerDao.insertpicname(seller.getSellerid(),filename);
        return 1;
    }

    public int delete(int sellerid) {
        return this.sellerDao.delete(sellerid);
    }



    public List<Seller> getAll() {
        return this.sellerDao.getAll();
    }


}
