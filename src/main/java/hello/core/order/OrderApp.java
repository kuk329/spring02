package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP); // 회원 하나 생성
        memberService.join(memberA); // 회원 가입 시킴

        Order 청바지 = orderService.createOrder(memberA.getId(), "청바지", 70000); // 주문서 생성
        System.out.println("청바지 = " + 청바지);
        System.out.println("청바지.calculatePrice() = " + 청바지.calculatePrice());

    }
}
