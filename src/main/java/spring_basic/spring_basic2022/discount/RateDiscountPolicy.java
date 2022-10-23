package spring_basic.spring_basic2022.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import spring_basic.spring_basic2022.annotation.MainDiscountPolicy;
import spring_basic.spring_basic2022.member.Grade;
import spring_basic.spring_basic2022.member.Member;

@Component
//@Qualifier("mainDiscountPolicy")
//@Primary
//@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        else {
            return 0;
        }
    }
}
