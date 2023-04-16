package com.sparta.springjpa.dto;

import com.sparta.springjpa.entity.Food;
import com.sparta.springjpa.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderRequestDto {
    private Food food;
    private Member member;
}
