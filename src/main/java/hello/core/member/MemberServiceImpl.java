package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();


    @Override
    public void join(Member member) {

        memberRepository.save(member); // db에 회원 저장

    }

    @Override
    public Member findMember(Long memberId) {

        return memberRepository.findById(memberId); // db에서 해당 회원 조회
    }
}
