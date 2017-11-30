package controllers.auth;

import javax.servlet.http.HttpServletRequest;

import mapper.user.UserInformation;
import models.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Register {
	
	@RequestMapping(value = "/register", method=RequestMethod.GET) // 注册页面
	public ModelAndView index() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("app");
		modelAndView.addObject("content", "auth/register");
		return modelAndView;
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.POST)	// 注册操作
	public ModelAndView store(HttpServletRequest request) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		ModelAndView modelAndView = new ModelAndView();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPass = request.getParameter("confirmPass");
		
		System.out.println(name);
		
		// 验证
		modelAndView.setViewName("app");
		modelAndView.addObject("content", "auth/register");
		if(name == "" || name.length()<1) {
			modelAndView.addObject("message", "名字不得为空");
			return modelAndView;
		}
		if(email == "" || email.length()<1) {
			modelAndView.addObject("message", "邮箱不得为空");
			return modelAndView;
		}
		if(password == "" || password.length()<1) {
			modelAndView.addObject("message", "密码不得为空");
			return modelAndView;
		}
		if(!password.equals(confirmPass)) {
			modelAndView.addObject("message", "密码必须相同");
			return modelAndView;
		}
		
		// 是否被注册
		UserInformation userInformation = new UserInformation();
		User user = new User();
		user = userInformation.findUserByEmail(email);
		if (null != user) {
			modelAndView.addObject("message", "邮箱已经被注册");
			return modelAndView;
		}

		
		// 注册成功

		user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		
		userInformation.insertUser(user);
		
		modelAndView.addObject("message", "注册成功,请登陆");
		modelAndView.addObject("content", "auth/login");
		
		request.getSession().setAttribute("user", user);
		modelAndView.setViewName("forward:index");
		
		return modelAndView;
	}
}
