import mapper.user.UserInformation;
import models.User;


public class Xm {

//	public static void main(String[] args) throws Throwable {
//		User user;
//		UserInformation userInformation = new UserInformation();
//		String email = "3237488047@qq.com";
//		user = userInformation.findUserByEmail(email);
//		System.out.println(user.getName());
//	}

	public static void main(String[] args) throws Throwable {
		User user = new User();
		UserInformation userInformation = new UserInformation();
		
		user.setEmail("323DSDss5S@qq.com");
		user.setPassword("666");
		user.setName("哦哦");
		
		userInformation.insertUser(user);
	}
}
