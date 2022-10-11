package spring_basic.spring_basic2022.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
