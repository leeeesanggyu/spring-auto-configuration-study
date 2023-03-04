package hello.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Transactional
    @Test
    void memberTest() {
        memberRepository.initTable();

        Member memberA = new Member("test-id", "memberA");
        memberRepository.save(memberA);
        Member findMember = memberRepository.find(memberA.getId());

        Assertions.assertThat(findMember.getId()).isEqualTo(memberA.getId());
    }
}