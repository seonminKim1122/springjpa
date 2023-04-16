package com.sparta.springjpa.entity;

import com.sparta.springjpa.dto.MemberRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Member extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String memberName;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();

    public Member(String memberName) {
        this.memberName = memberName;
    }

    public Member(MemberRequestDto requestDto) {
        this.memberName = requestDto.getMemberName();
        this.orders = requestDto.getOrders();
    }
}
