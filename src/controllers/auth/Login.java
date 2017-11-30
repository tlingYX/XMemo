package controllers.auth;

import javax.servlet.http.HttpServletRequest;

import mapper.user.UserInformation;
import models.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Login {

	@RequestMapping(value = "/login", method=RequestMethod.GET) // 登陆页面
	public ModelAndView index() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("app");
		modelAndView.addObject("content", "auth/login");
		return modelAndView;
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST) // 登陆请求
	public ModelAndView store(HttpServletRequest request) throws Throwable {

		ModelAndView modelAndView = new ModelAndView();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");	
		
		// 验证
		modelAndView.setViewName("app");
		modelAndView.addObject("content", "auth/login");
		if(email == "" || email.length()<1) {
			modelAndView.addObject("message", "邮箱不得为空");
			return modelAndView;
		}
		if(password == "" || password.length()<1) {
			modelAndView.addObject("message", "密码不得为空");
			return modelAndView;
		}
		
		// 查询用户
		User user = new User();
		UserInformation userInformation = new UserInformation();
		user = userInformation.findUserByEmail(email);
		// User问题
		if(null==user) {
			modelAndView.addObject("message", "该邮箱未注册");
			return modelAndView;
		}
		if(!user.getPassword().equals(password)) {
			modelAndView.addObject("message", "密码错误");
			return modelAndView;
		}
		
		// 登录成功
		modelAndView.addObject("message", "登录成功");
		modelAndView.addObject("content", "index");
		
		request.getSession().setAttribute("user", user);
		modelAndView.setViewName("forward:index");

		return modelAndView;
	}
	
	@RequestMapping(value = "/logout", method=RequestMethod.POST) // 退出请求
	public ModelAndView logout(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		request.getSession().removeAttribute("user");
		
		modelAndView.setViewName("redirect:login");
		return modelAndView;
	}
}
