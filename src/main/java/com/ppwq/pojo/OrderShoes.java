package com.ppwq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderShoes {

    private Integer osid;
    private Integer oid;
    private Integer cid;
    private String cname;
    private String color;
    private BigDecimal price;
    private Integer sid;
    private String size;
    private Integer number;

    private String image;
}
