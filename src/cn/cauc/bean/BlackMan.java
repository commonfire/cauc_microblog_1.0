/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.blackman
 * BlackManController.java
 * 创建人:wangjie
 * 时间：2016年03月15日 14:45:38
 * 中国民航大学-版权所有
 */
package cn.cauc.bean;

import java.util.Date;

/**
 * 重点人员管理
 * BlackMan 
 * 创建人:wangjie
 * 时间：2016年03月15日 14:45:38
 * @version 1.0.0
 */
 

public class BlackMan implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// 主键
	private String userId;// 微博用户ID
	private String userAlias;// 微博用户昵称
	private String location;// 微博用户所在地
	private String sex;// 微博用户性别
	private String blog;// 博客
	private String domain;// 个人主页
	private String brief;// 简介
	private String birthday;// 出生日期
	private String registerTime;// 注册时间
	private String image;// 头像
	private float degree;// 舆情等级
	private String thumbnail;// 小头像
	private Integer property;// 属性

 	public BlackMan(){
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getDegree() {
		return degree;
	}

	public void setDegree(float degree) {
		this.degree = degree;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Integer getProperty() {
		return property;
	}

	public void setProperty(Integer property) {
		this.property = property;
	}

}
