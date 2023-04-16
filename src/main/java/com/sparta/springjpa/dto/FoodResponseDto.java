package com.sparta.springjpa.dto;

import com.sparta.springjpa.entity.Food;
import com.sparta.springjpa.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FoodResponseDto {
    private Long id;
    private String name;
    private int price;
    private List<Order> orders;

    public FoodResponseDto(Food food) {
        this.id = food.getId();
        this.name = food.getName();
        this.price = food.getPrice();
        this.orders = food.getOrders();
    }
}
