package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl(); // interface에 구현체 할당

    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberA",Grade.VIP); // 객체 생성

        // when
        memberService.join(member); // 가입
        Member findMember = memberService.findMember(1L); // 조회

        // then
        Assertions.assertThat(member).isEqualTo(findMember); // 비교
    }
}
