package com.sparta.springjpa.dto;

import com.sparta.springjpa.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FoodRequestDto {
    private String name;
    private int price;
    private List<Orders> orders;
}
