package com.sparta.springjpa;

import com.sparta.springjpa.entity.Food;
import com.sparta.springjpa.entity.Member;
import com.sparta.springjpa.entity.Order;
import com.sparta.springjpa.repository.FoodRepository;
import com.sparta.springjpa.repository.MemberRepository;
import com.sparta.springjpa.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Restaurant implements ApplicationRunner {

    private final FoodRepository foodRepository;
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Food> foods = new ArrayList<>();
        Food food1 = new Food("후라이드", 10000);
        foods.add(food1);
        Food food2 = new Food("양념치킨", 12000);
        foods.add(food2);
        Food food3 = new Food("반반치킨", 13000);
        foods.add(food3);
        Food food4 = new Food("고구마피자", 9000);
        foods.add(food4);
        Food food5 = new Food("아보카도피자", 110000);
        foods.add(food5);
        foodRepository.saveAll(foods);

        List<Member> members = new ArrayList<>();
        Member member1 = new Member("삼식이");
        members.add(member1);
        Member member2 = new Member("먹깨비");
        members.add(member2);
        memberRepository.saveAll(members);

        System.out.println("=================================================================");

        System.out.println("Member 데이터");
        List<Member> findMembers = memberRepository.findAll(); // sql syntax error : 여기서 member 테이블 뿐만 아니라 order 테이블 join food 에서도 가져옴(근데 왜 member는 조인이 안됏지?)
        for (Member findMember : findMembers) {
            System.out.println("findMember = " + findMember.getMemberName());
        }

        System.out.println("=================================================================");

        System.out.println("Food 데이터");
        List<Food> findFoods = foodRepository.findAll();
        for (Food findFood : findFoods) {
            System.out.println("findFood = " + findFood.getName());
        }

        List<Order> orders = new ArrayList<>();
        Order order1 = new Order(findFoods.get(0), findMembers.get(0));
        orders.add(order1);
        Order order2 = new Order(findFoods.get(3), findMembers.get(1));
        orders.add(order2);
        Order order3 = new Order(findFoods.get(4), findMembers.get(1));
        orders.add(order3);
        Order order4 = new Order(findFoods.get(2), findMembers.get(0));
        orders.add(order4);
        Order order5 = new Order(findFoods.get(2), findMembers.get(0));
        orders.add(order5);
        Order order6 = new Order(findFoods.get(1), findMembers.get(1));
        orders.add(order6);
        Order order7 = new Order(findFoods.get(1), findMembers.get(0));
        orders.add(order7);
        Order order8 = new Order(findFoods.get(3), findMembers.get(1));
        orders.add(order8);
        orderRepository.saveAll(orders);

        System.out.println("=================================================================");
        int num = 1;

        System.out.println("Order 데이터");
        List<Order> orderList = orderRepository.findAll();
        for (Order order : orderList) {
            System.out.println(num);
            System.out.println("주문한 사람 = " + order.getMember().getMemberName());
            System.out.println("주문한 음식 = " + order.getFood().getName());
        }

        System.out.println("=================================================================");
        System.out.println("삼식이 주문한 음식");
        Member samsik = memberRepository.findByMemberName("삼식이").orElseThrow(
                () -> new NullPointerException("요청하신 정보가 없습니다.")
        );

        num = 1;
        for (Order order : samsik.getOrders()) {
            System.out.println(num++);
            System.out.println("주문한 음식 = " + order.getFood().getName());
            System.out.println("주문한 음식 가격 = " + order.getFood().getPrice());
        }

        System.out.println("=================================================================");
        System.out.println("아보카도피자 주문한 사람");
        Food abocado = foodRepository.findByName("아보카도피자").orElseThrow(
                () -> new NullPointerException("저희 매장에는 아보카도 피자가 없습니다.")
        );

        for (Order order : abocado.getOrders()) {
            System.out.println("주문한 사람 = " + order.getMember().getMemberName());
        }
    }
}
