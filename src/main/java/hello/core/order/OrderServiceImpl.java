package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

 //   private final MemberRepository memberRepository = new MemoryMemberRepository();
   // private final DiscountPolicy discountPolicy= new FixDiscountPolicy(); // 정액(고정) 할인 정책 적용
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 정률할인 정책 적용
    // 문제점 : OrderServiceImpl 이 DiscountPolicy 인터페이스 뿐만아니라 FixDiscountPolicy 구현 클래스도 함께
    // 의존하고 있다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) { // 주문서 생성
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }


}
