package com.ppwq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private Integer carid;
    private Integer uid;
    private Integer cid;
    private Integer sid;
    private String color;
    private Integer num;
    private Integer checkable;
    private Date createTime;

    private String image;
    private String cname;
    private Double size;
    private BigDecimal price;

}
