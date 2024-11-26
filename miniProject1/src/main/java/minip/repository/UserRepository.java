package minip.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import minip.domain.MemberDTO;

@Repository
public class UserRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "userRepositorySql";
	String statement;
	
	
	public int userInsert(MemberDTO dto) {
		statement = namespace + ".userInsert";
		return sqlSession.insert(statement, dto);
	};

}
