package mapper.article;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mapper.SqlResource;
import models.Article;

public class ArticleInformation extends SqlResource {

	// 插入一篇文章
	public void insertArticle(Article article) throws Exception {
		super.setUp();

		// 创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建articleMapper对象
		ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);

		// 添加article集合
		articleMapper.insertArticle(article);

		sqlSession.commit();
		sqlSession.close();
	};

	// 删除文章
	public void delectArticleById(int id) throws Exception {
		super.setUp();

		// 创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建articleMapper对象
		ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);

		// 根据文章Id更改删除状态
		articleMapper.delectArticleById(id);

		sqlSession.commit();
		sqlSession.close();
	}

	// 查询
	public List<Article> findArticleById(int user_id) throws Exception {
		super.setUp();

		// 创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建articleMapper对象
		ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);

		// articleList获取数据库结果
		List<Article> articleList = articleMapper.findArticleById(user_id);

		sqlSession.commit();
		sqlSession.close();

		return articleList;
	}

	// 获取更多文章
	public List<Article> getMoreArticle(int user_id,int Id) throws Exception {
		super.setUp();
		
		// 创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建articleMapper对象
		ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);
		
		// articleList获取数据库结果
		List<Article> articleList = articleMapper.getMoreArticle(user_id, Id);
		
		sqlSession.commit();
		sqlSession.close();
		
		return articleList;
	}
}
