/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.permission
 * PermissionController.java
 * 创建人:wangjie
 * 时间：2016年03月10日 12:14:09
 * 中国民航大学-版权所有
 */
package cn.cauc.dao.permission;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cauc.bean.Permission;
import cn.cauc.bean.TzParams;

/**
 * 权限管理Mapper
 * IPermissionMapper
 * 创建人:wangjie 
 * 时间：2016年03月10日 12:14:09
 * @version 1.0.0
 */
public interface IPermissionMapper {

	/**
	 *
	 * cn.cauc.dao.permission 
	 * 方法名：findPermissionRoot
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午1:57:55 
	 * @param params
	 * @return 
	 * 返回值：List<Permission>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Permission> findPermissionRoot(TzParams params);
	public List<Permission> findPermissionChildren(@Param("id")Integer parentId);
	
	/**
	 * 求总数
	 * cn.cauc.dao.permission 
	 * 方法名：count
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午1:58:13 
	 * @param params
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * cn.cauc.dao.permission 
	 * 方法名：get
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午1:58:32 
	 * @param id
	 * @return 
	 * 返回值：Permission
	 * @exception 
	 * @since  1.0.0
	 */
	public Permission get(Integer id);
	
	/**
	 * 
	 * cn.cauc.dao.permission 
	 * 方法名：save
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午1:58:40 
	 * @param permission
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Permission permission);
	
	/**
	 * 
	 * cn.cauc.dao.permission 
	 * 方法名：update
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午1:58:49 
	 * @param permission
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Permission permission);
	
	/**
	 * 
	 * cn.cauc.dao.permission 
	 * 方法名：delete
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午1:58:57 
	 * @param params
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
	
	
	/**
	 * 根据用户ID查询权限
	 * cn.cauc.dao.permission 
	 * 方法名：findUserPersmission
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午1:59:12 
	 * @param userId
	 * @return 
	 * 返回值：List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String, Object>> findUserPersmission(@Param("userId")Integer userId);
	
}
