/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.microblogcontent
 * MicroblogContentController.java
 * 创建人:wangjie
 * 时间：2016年03月09日 21:28:17
 * 中国民航大学-版权所有
 */
package cn.cauc.dao.microblogcontent;

import java.util.List;

import cn.cauc.bean.MicroblogContent;
import cn.cauc.bean.TzParams;

/**
 * 微博内容Mapper
 * IMicroblogContentMapper
 * 创建人:wangjie 
 * 时间：2016年03月09日 21:28:17
 * @version 1.0.0
 */
public interface IMicroblogContentMapper {

	/**
	 * cn.cauc.dao.microblogcontent 
	 * 方法名：findMicroblogContents
	 * 创建人：wangjie                          
	 * 时间：2016年03月09日 21:28:17
	 * @param params
	 * @return 
	 * 返回类型：List<MicroblogContent>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<MicroblogContent> findMicroblogContents(TzParams params);
	
	/**
	 * 求总数
	 * cn.cauc.dao.microblogcontent 
	 * 方法名：count
	 * 创建人：wangjie 
	 * 时间：2016年03月09日 21:28:17
	 * @param id
	 * @return 
	 * 返回类型：List<MicroblogContent>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * cn.cauc.dao.microblogcontent 
	 * 方法名：getMicroblogContent
	 * 创建人：wangjie 
	 * 时间：2016年03月09日 21:28:17
	 * @param id
	 * @return 
	 * 返回类型：List<MicroblogContent>
	 * @exception 
	 * @since  1.0.0
	 */
	public MicroblogContent get(Integer id);
	
	/**
	 * 保存微博内容
	 * cn.cauc.dao.microblogcontent 
	 * 方法名：save
	 * 时间：2016年03月09日 21:28:17
	 * @param microblogcontent
	 * @return 
	 * 返回类型：MicroblogContent
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(MicroblogContent microblogcontent);
	
	/**
	 * 更新微博内容
	 * cn.cauc.dao.microblogcontent 
	 * 方法名：update
	 * 创建人：wangjie 
	 * 时间：2016年03月09日 21:28:17
	 * @param microblogcontent
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(MicroblogContent microblogcontent);
	
	/**
	 * 删除微博内容
	 * cn.cauc.dao.microblogcontent 
	 * 方法名：delete
	 * 创建人：wangjie 
	 * 时间：2016年03月09日 21:28:17 
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
	
}
