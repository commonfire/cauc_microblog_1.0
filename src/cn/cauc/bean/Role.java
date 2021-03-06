/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.role
 * RoleController.java
 * 创建人:wangjie
 * 时间：2016年03月10日 12:16:11
 * 中国民航大学-版权所有
 */
package cn.cauc.bean;

import java.util.Date;

/**
 * 角色管理 Role 创建人:wangjie 时间：2016年03月10日 12:16:11
 * 
 * @version 1.0.0
 */
public class Role implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// 主键 
	private String name;// 名称
	private Date createTime;// 创建时间
	private Date updateTime;// 创建时间
	private Integer userId;// 用户ID
	private Integer isDelete;// 0删除1未删除
	private String description;// 角色描述

	public Role() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
