package spring_basic.spring_basic2022.discount;

import spring_basic.spring_basic2022.member.Grade;
import spring_basic.spring_basic2022.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
