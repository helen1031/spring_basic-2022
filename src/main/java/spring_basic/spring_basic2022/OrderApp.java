package spring_basic.spring_basic2022;

import spring_basic.spring_basic2022.member.Grade;
import spring_basic.spring_basic2022.member.Member;
import spring_basic.spring_basic2022.member.MemberService;
import spring_basic.spring_basic2022.member.MemberServiceImpl;
import spring_basic.spring_basic2022.order.Order;
import spring_basic.spring_basic2022.order.OrderService;
import spring_basic.spring_basic2022.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        //MemberService memberService = new MemberServiceImpl();
        //OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order.toString());
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
