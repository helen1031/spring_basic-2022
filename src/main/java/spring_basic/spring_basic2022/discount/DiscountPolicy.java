package spring_basic.spring_basic2022.discount;

import spring_basic.spring_basic2022.member.Member;

public interface DiscountPolicy {
    /*
    * @return 할인대상 금액
    * */
    int discount(Member member, int price);
}
