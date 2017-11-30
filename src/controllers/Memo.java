package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mapper.article.ArticleInformation;
import models.Article;
import models.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Memo {
	
	@RequestMapping(value = "/edit", method=RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("app");
		modelAndView.addObject("content", "memo/edit");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/text", method=RequestMethod.POST)
	public void text(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Article article = new Article();
		
		User user = (User)request.getSession().getAttribute("user");
		
		
		article.setUser_id(user.getId()); 
		article.setText(request.getParameter("sumcode"));;
		article.setIssued(new java.sql.Date(new java.util.Date().getTime()));

		
		// 成功后跳转到主页
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("app");
		modelAndView.addObject("content", "index");
		
		ArticleInformation articleInformation = new ArticleInformation();
		articleInformation.insertArticle(article);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/delectArticle")
	public String delectArticle(int id) throws Exception {
		ArticleInformation articleInformation = new ArticleInformation();
		articleInformation.delectArticleById(id);
		return "成功删除";
	}
}
