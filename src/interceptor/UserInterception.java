package interceptor;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserInterception implements HandlerInterceptor{

	// 
	private final static String[] isloginList = { "/XMemo/login", "/XMemo/register" };
	private final static List<String> list = Arrays.asList(isloginList);
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}
	// 拦截index
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		
		// 获取url
		String url = request.getRequestURI();
		
		// 判断是否已经登录
		if(null == request.getSession().getAttribute("user")) {
			// 未登录 
			if(list.contains(url)) {
				return true;
			} else {
				response.sendRedirect("login");
			}
		} else {
			// 已登录, 跳转到主页
			if(list.contains(url)) {
				response.sendRedirect("index");
			} else {
				return true;
			}
		}
		return false;
	}

}
