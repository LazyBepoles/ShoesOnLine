package com.ppwq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private Integer aid;
    private Integer uid;
    private String name;
    private String phone;
    private String address;

}
