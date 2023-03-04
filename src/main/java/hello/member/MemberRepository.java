package hello.member;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    public final JdbcTemplate template;

    public MemberRepository(JdbcTemplate template) {
        this.template = template;
    }

    public void initTable() {
        template.execute("CREATE TABLE member(id varchar primary key, name varchar)");
    }

    public void save(Member member) {
        template.update(
                "INSERT INTO member(id, name) VALUES (?,?)",
                member.getId(),
                member.getName()
        );
    }

    public Member find(String memberId) {
        return template.queryForObject(
                "SELECT id, name FROM member WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Member.class),
                memberId
        );
    }

    public List<Member> findAll() {
        return template.query(
                "SELECT id, name FROM member",
                BeanPropertyRowMapper.newInstance(Member.class)
        );
    }
}
