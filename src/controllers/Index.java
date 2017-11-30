package controllers;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mapper.article.ArticleInformation;
import models.Article;
import models.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Index {
	
	@RequestMapping(value = "/index")
	public ModelAndView index(HttpServletRequest request) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("app");
		modelAndView.addObject("content", "index");

		ArticleInformation articleInformation = new ArticleInformation();
		
		User user = (User)request.getSession().getAttribute("user");
		int user_id = user.getId();
		List<Article> article =  articleInformation.findArticleById(user_id);
		
		modelAndView.addObject("article", article);
		return modelAndView;
	}
}
