package spring_basic.spring_basic2022;

import spring_basic.spring_basic2022.discount.FixDiscountPolicy;
import spring_basic.spring_basic2022.discount.RateDiscountPolicy;
import spring_basic.spring_basic2022.member.MemberService;
import spring_basic.spring_basic2022.member.MemberServiceImpl;
import spring_basic.spring_basic2022.member.MemoryMemberRepository;
import spring_basic.spring_basic2022.order.OrderService;
import spring_basic.spring_basic2022.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
