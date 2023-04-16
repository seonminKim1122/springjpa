package com.sparta.springjpa.dto;

import com.sparta.springjpa.entity.Food;
import com.sparta.springjpa.entity.Member;
import com.sparta.springjpa.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderResponseDto {
    private Long id;
    private Food food;
    private Member member;

    public OrderResponseDto(Orders orders) {
        this.id = orders.getId();
        this.food = orders.getFood();
        this.member = orders.getMember();
    }
}
