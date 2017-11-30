package mapper.user;

import org.apache.ibatis.session.SqlSession;

import mapper.SqlResource;
import models.User;

public class UserInformation extends SqlResource{

	// 查询用户
	public User findUserByEmail(String email) throws Throwable {
		
		super.setUp();
		SqlSession session = sqlSessionFactory.openSession();	
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		User user = mapper.findUserByEmail(email);
		
		session.commit();
		session.close();
		
		return user;
	}
	
	// 添加用户
	public void insertUser(User user) throws Throwable {
		
		super.setUp();
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		mapper.insertUser(user);
		
		session.commit();
		session.close();	
	}
}
