package com.example.Board.v2.vo;

import lombok.Data;

@Data
public class Order {
    private int no;
    private int coffee_no;
    private String coffee;
    private int price;
    private String cust_id;
    private String name;
    private String reg_day;
}
