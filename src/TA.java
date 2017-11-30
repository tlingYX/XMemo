import mapper.article.ArticleInformation;

import models.Article;


public class TA {
	public static void main(String[] args) throws Throwable {
		Article article = new Article();
		ArticleInformation articleInformation = new ArticleInformation();
		
//		article.setText("ssd");;
//		article.setIssued(new java.sql.Date(new java.util.Date().getTime()));
//		article.setUser_id(5456);
//		
//		articleInformation.insertArticle(article);
		
		System.out.println(articleInformation.findArticleById(1));
	}
}
