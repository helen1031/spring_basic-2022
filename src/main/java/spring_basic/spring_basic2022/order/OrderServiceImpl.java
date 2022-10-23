package spring_basic.spring_basic2022.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring_basic.spring_basic2022.annotation.MainDiscountPolicy;
import spring_basic.spring_basic2022.discount.DiscountPolicy;
import spring_basic.spring_basic2022.member.Member;
import spring_basic.spring_basic2022.member.MemberRepository;

//@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;


    // 생략사유: @RequiredArgsConstructor -> final이 포함된 항목 자동으로 생성자 만들어준다
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // Singleton 테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
