/**
 * 民航安全信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.content
 * ContentController.java
 * 创建人:wangjie
 * 时间：2016年02月24日 20:31:58
 * 中国民航大学-版权所有
 */
package cn.cauc.service.content;

import java.util.List;

import cn.cauc.bean.Content;
import cn.cauc.bean.TzParams;

/**
 * IContentService
 * 创建人:wangjie 
 * 时间：2016年02月24日 20:31:58
 * @version 1.0.0
 */
public interface IContentService {


	/**
	 * cn.cauc.service.content 
	 * 方法名：findContents
	 * 创建人：wangjie 
	 * 时间：2016年02月24日 20:31:58
	 * @param params
	 * @return 
	 * 返回类型：List<Content>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Content> findContents(TzParams params);
	
	/**
	 * 求总数
	 * cn.cauc.dao.content 
	 * 方法名：count
	 * 创建人：wangjie 
	 * 时间：2016年02月24日 20:31:58
	 * @param id
	 * @return 
	 * 返回类型：List<Content>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * cn.cauc.service.content 
	 * 方法名：findContents
	 * 创建人：wangjie 
	 * 时间：2016年02月24日 20:31:58
	 * @param params
	 * @return 
	 * 返回类型：List<Content>
	 * @exception 
	 * @since  1.0.0
	 */
	public Content get(Integer id);
	
	/**
	 * 保存内容管理
	 * cn.cauc.service.content 
	 * 方法名：save
	 * 创建人：wangjie 
	 * 时间：2016年02月24日 20:31:58 
	 * @param content
	 * @return 
	 * 返回类型：Content
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Content content);
	
	/**
	 * 更新内容管理
	 * cn.cauc.service.content 
	 * 方法名：update
	 * 创建人：wangjie 
	 * 时间：2016年02月24日 20:31:58
	 * @param content
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Content content);
	
	/**
	 * 删除内容管理
	 * cn.cauc.service.content 
	 * 方法名：delete
	 * 创建人：wangjie 
	 * 时间：2016年02月24日 20:31:58
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
}
