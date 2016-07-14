/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.bean.microblogstat
 * MicroblogStat.java
 * 创建人:wangjie
 * 时间：2016年03月16日 10:34:24
 * 中国民航大学-版权所有
 */
package cn.cauc.bean;

import java.util.Date;

/**
 * 微博数据统计
 * MicroblogStat 
 * 创建人:wangjie
 * 时间：2016年03月16日 10:34:24
 * @version 1.0.0
 */
 

public class MicroblogStat implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// 主键
	private String realName;// 真实姓名
	private String password;// 密码
	private Date createTime;// 创建时间
	private Date updateTime;// 创建时间
	private Integer isDelete;// 0删除1未删除
	private Integer male;// 性别
	private String cardId;// 身份证号
	private String email;// 邮箱
	private String telephone;// 联系电话
	private String company;// 工作单位
	private Integer forbiden;// 0禁止登陆1不禁止

 	public MicroblogStat(){
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getMale() {
		return male;
	}

	public void setMale(Integer male) {
		this.male = male;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getForbiden() {
		return forbiden;
	}

	public void setForbiden(Integer forbiden) {
		this.forbiden = forbiden;
	}

}
