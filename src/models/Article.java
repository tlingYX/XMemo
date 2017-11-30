package models;

import java.sql.Date;

/**
 * 文章日志
 * 
 * @author T_ling
 * @date 2017年4月4日 上午12:56:51
 * @version 1.0
 */
public class Article {

	private int Id; // 主键
	private int user_id; // 作者
	private String text; // 
	private Date issued; // 发布时间
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getIssued() {
		return issued;
	}
	public void setIssued(Date issued) {
		this.issued = issued;
	}

}
