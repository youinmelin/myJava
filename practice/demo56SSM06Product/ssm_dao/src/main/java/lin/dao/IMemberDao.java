package lin.dao;

import lin.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMemberDao {

    @Select("select * from member where mid = #{mid}")
    public Member findMemberById(Integer mid);

    @Select("select * from member")
    List<Member> findAllMembers();
}
