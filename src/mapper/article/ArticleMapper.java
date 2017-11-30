package mapper.article;

import java.util.List;

import models.Article;

public interface ArticleMapper {

	// 添加一篇日记的信息
	public void insertArticle(Article article) throws Exception;

	// 删除日记
	public void delectArticleById(int id) throws Exception;

	// 查询日记
	public List<Article> findArticleById(Integer id) throws Exception;
	
	// 获取更多日记
	public List<Article> getMoreArticle(int id,int num) throws Exception;
	
}