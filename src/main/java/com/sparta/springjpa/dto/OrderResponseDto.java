package com.sparta.springjpa.dto;

import com.sparta.springjpa.entity.Food;
import com.sparta.springjpa.entity.Member;
import com.sparta.springjpa.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderResponseDto {
    private Long id;
    private Food food;
    private Member member;

    public OrderResponseDto(Order order) {
        this.id = order.getId();
        this.food = order.getFood();
        this.member = order.getMember();
    }
}
