package controllers.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mapper.user.UserInformation;
import models.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Login {
	
	ModelAndView modelAndView = new ModelAndView();
	
	public Login() {

		modelAndView.setViewName("app");	
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.GET) // 登陆页面
	public ModelAndView index() {
	
		modelAndView.addObject("content", "auth/login");
		return modelAndView;
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST) // 登陆请求
	public ModelAndView store(HttpServletRequest request) throws Throwable {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// 查询用户
		User user = new User();
		UserInformation userInformation = new UserInformation();
		user = userInformation.findUserByEmail(email);
		
		
		// 验证
		modelAndView.addObject("content", "auth/login");
		if(null==user) {
			modelAndView.addObject("message", "该邮箱未注册");
			return modelAndView;
		}
		if(!user.getPassword().equals(password)) {
			modelAndView.addObject("message", "密码错误");
			return modelAndView;
		}
		
		modelAndView.addObject("message", "登陆成功");
		modelAndView.addObject("content", "index");
		
		return modelAndView;
	}
}
