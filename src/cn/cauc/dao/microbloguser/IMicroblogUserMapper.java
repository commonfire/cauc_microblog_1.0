/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.microbloguser
 * MicroblogUserController.java
 * 创建人:wangjie
 * 时间：2016年03月10日 11:57:43
 * 中国民航大学-版权所有
 */
package cn.cauc.dao.microbloguser;

import java.util.List;

import cn.cauc.bean.MicroblogUser;
import cn.cauc.bean.TzParams;

/**
 * 微博用户Mapper
 * IMicroblogUserMapper
 * 创建人:wangjie 
 * 时间：2016年03月10日 11:57:43
 * @version 1.0.0
 */
public interface IMicroblogUserMapper {

	/**
	 * cn.cauc.dao.microbloguser 
	 * 方法名：findMicroblogUsers
	 * 创建人：wangjie                          
	 * 时间：2016年03月10日 11:57:43
	 * @param params
	 * @return 
	 * 返回类型：List<MicroblogUser>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<MicroblogUser> findMicroblogUsers(TzParams params);
	
	/**
	 * 求总数
	 * cn.cauc.dao.microbloguser 
	 * 方法名：count
	 * 创建人：wangjie 
	 * 时间：2016年03月10日 11:57:43
	 * @param id
	 * @return 
	 * 返回类型：List<MicroblogUser>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * cn.cauc.dao.microbloguser 
	 * 方法名：getMicroblogUser
	 * 创建人：wangjie 
	 * 时间：2016年03月10日 11:57:43
	 * @param id
	 * @return 
	 * 返回类型：List<MicroblogUser>
	 * @exception 
	 * @since  1.0.0
	 */
	public MicroblogUser get(Integer id);
	
	/**
	 * 保存微博用户
	 * cn.cauc.dao.microbloguser 
	 * 方法名：save
	 * 时间：2016年03月10日 11:57:43
	 * @param microbloguser
	 * @return 
	 * 返回类型：MicroblogUser
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(MicroblogUser microbloguser);
	
	/**
	 * 更新微博用户
	 * cn.cauc.dao.microbloguser 
	 * 方法名：update
	 * 创建人：wangjie 
	 * 时间：2016年03月10日 11:57:43
	 * @param microbloguser
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(MicroblogUser microbloguser);
	
	/**
	 * 删除微博用户
	 * cn.cauc.dao.microbloguser 
	 * 方法名：delete
	 * 创建人：wangjie 
	 * 时间：2016年03月10日 11:57:43 
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
	
}
