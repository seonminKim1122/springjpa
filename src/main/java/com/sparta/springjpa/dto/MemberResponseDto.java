package com.sparta.springjpa.dto;

import com.sparta.springjpa.entity.Member;
import com.sparta.springjpa.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MemberResponseDto {
    private Long id;
    private String memberName;
    private List<Order> orders;

    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.memberName = member.getMemberName();
        this.orders = member.getOrders();
    }
}
