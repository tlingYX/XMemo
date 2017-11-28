package mapper.user;

import models.User;

public interface UserMapper {

	// 查询用户
	public User findUserByEmail(String email) throws Throwable;
	
	// 添加
	public void insertUser(User user) throws Throwable;
}
