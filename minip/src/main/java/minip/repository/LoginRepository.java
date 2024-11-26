package minip.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "loginRepositorySql";
	String statement;
	
	public int idCheckSelectOne(String userId) {
		statement = namespace + ".idCheckSelectOne";
		return sqlSession.selectOne(statement, userId);
	}


}
