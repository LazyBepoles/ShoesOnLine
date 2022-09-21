package com.ppwq.service;

import com.ppwq.pojo.Address;

import java.util.List;

public interface AddressService {

    int addNewAddress(Address address);

    int updateAddress(Address address);

    int deleteAddress(int aid);

    List<Address> getAllAddress(int uid);
}
