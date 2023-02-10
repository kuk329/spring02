package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

  //  MemberService memberService = new MemberServiceImpl(); // interface에 구현체 할당

    MemberService memberService;

    @BeforeEach // 테스트 실행전에 수행
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService =  appConfig.memberService();
    }


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
