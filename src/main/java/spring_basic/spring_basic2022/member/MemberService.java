package spring_basic.spring_basic2022.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
