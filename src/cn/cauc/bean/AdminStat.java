/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.adminstat
 * AdminStatController.java
 * 创建人:wangjie
 * 时间：2016年03月15日 16:30:52
 * 中国民航大学-版权所有
 */
package cn.cauc.bean;

import java.util.Date;

/**
 * 平台日志统计 AdminStat 创建人:wangjie 时间：2016年03月15日 16:30:52
 * 
 * @version 1.0.0
 */

public class AdminStat implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// 主键
	private String classname;// 名称
	private Date createTime;// 创建时间
	private Integer userId;// 用户ID
	private String method;
	private Long time;
	private String ip;
	private String ipAddress;
	private String username;
	private String model;
	private String description;

	public AdminStat(Integer id, String classname, Date createTime,
			Integer userId, String method, Long time, String ip,
			String ipAddress, String username, String model, String description) {
		super();
		this.id = id;
		this.classname = classname;
		this.createTime = createTime;
		this.userId = userId;
		this.method = method;
		this.time = time;
		this.ip = ip;
		this.ipAddress = ipAddress;
		this.username = username;
		this.model = model;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
