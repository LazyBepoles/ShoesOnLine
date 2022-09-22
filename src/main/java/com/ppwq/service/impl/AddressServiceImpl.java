package com.ppwq.service.impl;

import com.ppwq.dao.AddressDao;
import com.ppwq.pojo.Address;
import com.ppwq.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public int addNewAddress(Address address) {
        return this.addressDao.addNewAddress(address);
    }

    @Override
    public int updateAddress(Address address) {
        return this.addressDao.updateAddress(address);
    }

    @Override
    public int deleteAddress(int aid) {
        return this.addressDao.deleteAddress(aid);
    }

    @Override
    public List<Address> getAllAddress(int uid) {
        return this.addressDao.getAllAddress(uid);
    }

    @Override
    public Address getDetailAddress(int aid) {
        return this.addressDao.getDetailAddress(aid);
    }
}
