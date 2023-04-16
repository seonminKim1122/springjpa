package com.sparta.springjpa.entity;

import com.sparta.springjpa.dto.OrderRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Order extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Order(Food food, Member member) {
        this.food = food;
        this.member = member;
    }

    public Order(OrderRequestDto requestDto) {
        this.food = requestDto.getFood();
        this.member = requestDto.getMember();
    }
}
