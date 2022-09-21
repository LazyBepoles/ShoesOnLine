package com.ppwq.dao;

import com.ppwq.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AddressDao {

    int addNewAddress(Address address);

    int updateAddress(Address address);

    int deleteAddress(int aid);

    List<Address> getAllAddress(int uid);
}
