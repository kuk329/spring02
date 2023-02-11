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

    // 의존관계 주입을 사용하면 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존관계를 쉽게 변경할 수 있다.

    // IoC 컨테이너, DI 컨테이너
    /*
     AppConfig 처럼 객체를 생성하고 관리하면서 의존관계를 연결해 주는 것을 IoC 컨테이너 또는 DI 컨테이너 라고 한다.
     의존관계 주입에 초점을 맞춰서 최근에는 주로 DI 컨테이너라 한다.
     또는 어셈블러, 오브젝트 팩토리 등으로 불리기도 한다. 
     */


}
