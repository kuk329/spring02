package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{// 정액 할인 정책

    private int discountFixAmount = 1000; // 1000원 할인


    @Override
    public int discount(Member member, int price) { // 할인을 해줄 가격 return
        if(member.getGrade()== Grade.VIP){  // VIP 고객만 할인
            return discountFixAmount;
        }else{
            return 0;
        }

    }
}
