package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>(); // 동시성 이슈

    @Override
    public void save(Member member) {

        store.put(member.getId(),member); // Map 객체에 회원 id : 회원 객체 저장.

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
