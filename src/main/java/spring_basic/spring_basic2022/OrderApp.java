package spring_basic.spring_basic2022;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_basic.spring_basic2022.member.Grade;
import spring_basic.spring_basic2022.member.Member;
import spring_basic.spring_basic2022.member.MemberService;
import spring_basic.spring_basic2022.member.MemberServiceImpl;
import spring_basic.spring_basic2022.order.Order;
import spring_basic.spring_basic2022.order.OrderService;
import spring_basic.spring_basic2022.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //OrderService orderService = appConfig.orderService();
        //MemberService memberService = new MemberServiceImpl();
        //OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);

        //Spring
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order.toString());
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
