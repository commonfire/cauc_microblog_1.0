/**
 * 民航安全信息信息分析预警平台
 * cauc_microblog
 * cn.cauc.web.user
 * UserController.java
 * 创建人:wangjie
 * 时间：2016年02月26日 09:56:28
 * 中国民航大学-版权所有
 */
package cn.cauc.service.user;

import java.util.List;

import cn.cauc.bean.TzParams;
import cn.cauc.bean.User;

/**
 * IUserService
 * 创建人:wangjie 
 * 时间：2016年02月26日 09:56:28
 * @version 1.0.0
 */
public interface IUserService {


	/**
	 * cn.cauc.service.user 
	 * 方法名：findUsers
	 * 创建人：wangjie 
	 * 时间：2016年02月26日 09:56:28
	 * @param params
	 * @return 
	 * 返回类型：List<User>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<User> findUsers(TzParams params);
	
	/**
	 * 求总数
	 * cn.cauc.dao.user 
	 * 方法名：count
	 * 创建人：wangjie 
	 * 时间：2016年02月26日 09:56:28
	 * @param id
	 * @return 
	 * 返回类型：List<User>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * cn.cauc.service.user 
	 * 方法名：findUsers
	 * 创建人：wangjie 
	 * 时间：2016年02月26日 09:56:28
	 * @param params
	 * @return 
	 * 返回类型：List<User>
	 * @exception 
	 * @since  1.0.0
	 */
	public User get(Integer id);
	
	/**
	 * 保存用户信息
	 * cn.cauc.service.user 
	 * 方法名：save
	 * 创建人：wangjie 
	 * 时间：2016年02月26日 09:56:28 
	 * @param user
	 * @return 
	 * 返回类型：User
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(User user);
	
	/**
	 * 更新用户信息
	 * cn.cauc.service.user 
	 * 方法名：update
	 * 创建人：wangjie 
	 * 时间：2016年02月26日 09:56:28
	 * @param user
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(User user);
	public int updatePW(User user);
	/**
	 * 删除用户信息
	 * cn.cauc.service.user 
	 * 方法名：delete
	 * 创建人：wangjie 
	 * 时间：2016年02月26日 09:56:28
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
	/**
	 * 
	 * 根据账号和密码实现登陆
	 * cn.cauc.service.user 
	 * 方法名：getLogin
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午1:02:17 
	 * @param params
	 * @return 
	 * 返回值：User
	 * @exception 
	 * @since  1.0.0
	 */
	public User getLogin(TzParams params);
}
