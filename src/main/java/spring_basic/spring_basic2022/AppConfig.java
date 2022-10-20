package spring_basic.spring_basic2022;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_basic.spring_basic2022.discount.DiscountPolicy;
import spring_basic.spring_basic2022.discount.FixDiscountPolicy;
import spring_basic.spring_basic2022.discount.RateDiscountPolicy;
import spring_basic.spring_basic2022.member.MemberService;
import spring_basic.spring_basic2022.member.MemberServiceImpl;
import spring_basic.spring_basic2022.member.MemoryMemberRepository;
import spring_basic.spring_basic2022.order.OrderService;
import spring_basic.spring_basic2022.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
