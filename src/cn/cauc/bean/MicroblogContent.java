/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.microblogcontent
 * MicroblogContentController.java
 * 创建人:wangjie
 * 时间：2016年03月09日 21:28:17
 * 中国民航大学-版权所有
 */
package cn.cauc.bean;


/**
 * 微博内容
 * MicroblogContent 
 * 创建人:wangjie
 * 时间：2016年03月09日 21:28:17
 * @version 1.0.0
 */
public class MicroblogContent implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// 主键
	private String userId;// 用户ID
	private String content;// 微博内容
	private String publishTime;// 发布时间
	private String repostUser;// 回复用户
	private String repostUserId;// 回复用户ID
	private String publishTimestamp;// 发布时间戳

	private String userAlias;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getRepostUser() {
		return repostUser;
	}

	public void setRepostUser(String repostUser) {
		this.repostUser = repostUser;
	}

	public String getRepostUserId() {
		return repostUserId;
	}

	public void setRepostUserId(String repostUserId) {
		this.repostUserId = repostUserId;
	}

	public String getPublishTimestamp() {
		return publishTimestamp;
	}

	public void setPublishTimestamp(String publishTimestamp) {
		this.publishTimestamp = publishTimestamp;
	}

	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}

}
