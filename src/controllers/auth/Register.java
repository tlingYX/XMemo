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
public class Register {

	ModelAndView modelAndView = new ModelAndView();
	
	public Register() {
		
		modelAndView.setViewName("app");
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.GET) // 注册页面
	public ModelAndView index() {

		modelAndView.addObject("content", "auth/register");
		return modelAndView;
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.POST)	// 注册操作
	public ModelAndView store(HttpServletRequest request) throws Throwable {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String confirmPass = request.getParameter("confirmPass");
		
		// 验证
		modelAndView.addObject("content", "auth/register");
		if(null==name||null==email||null==pass||null==confirmPass) {
			modelAndView.addObject("message", "不得为空");
			return modelAndView;
		}
		if(!pass.equals(confirmPass)) {
			modelAndView.addObject("message", "密码必须相同");
			return modelAndView;
		}
		if(email.equals("3237488047@qq.com")) {
			modelAndView.addObject("message", "邮箱已经被注册");
			return modelAndView;
		}
		
		// 注册成功
		UserInformation userInformation = new UserInformation();
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setPassword(pass);
		
		userInformation.insertUser(user);
		
		modelAndView.addObject("message", "注册成功,请登陆");
		modelAndView.addObject("content", "auth/login");
		return modelAndView;
	}
}
