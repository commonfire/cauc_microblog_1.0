/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.role
 * RoleController.java
 * 创建人:wangjie
 * 时间：2016年03月10日 12:16:11
 * 中国民航大学-版权所有
 */
package cn.cauc.dao.role;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cauc.bean.Role;
import cn.cauc.bean.TzParams;

/**
 * 角色管理Mapper
 * IRoleMapper
 * 创建人:wangjie 
 * 时间：2016年03月10日 12:16:11
 * @version 1.0.0
 */
public interface IRoleMapper {

	/**
	 * 角色查询
	 * cn.cauc.dao.role 
	 * 方法名：findRoles
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午1:38:14 
	 * @param params
	 * @return 
	 * 返回值：List<Role>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Role> findRoles(TzParams params);
	
	/**
	 * 求总数
	 * cn.cauc.dao.role 
	 * 方法名：count
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午1:38:46 
	 * @param params
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 通过id获取角色数据
	 * cn.cauc.dao.role 
	 * 方法名：get
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午1:39:19 
	 * @param id
	 * @return 
	 * 返回值：Role
	 * @exception 
	 * @since  1.0.0
	 */
	public Role get(Integer id);
	
	/**
	 * 保存角色数据
	 * cn.cauc.dao.role 
	 * 方法名：save
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午1:39:53 
	 * @param role
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Role role);
	
	/**
	 * 更新角色数据
	 * cn.cauc.dao.role 
	 * 方法名：update
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午1:40:13 
	 * @param role
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Role role);
		
	/**
	 * 删除角色数据
	 * cn.cauc.dao.role 
	 * 方法名：delete
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午1:40:31 
	 * @param params
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
	
	/**
	 * 为用户分配角色
	 * cn.cauc.dao.role 
	 * 方法名：saveRoleUser
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午1:40:54 
	 * @param userId
	 * @param roleId
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int saveRoleUser(@Param("userId")Integer userId,@Param("roleId")Integer roleId);
	public int saveRolePermission(@Param("roleId")Integer roleId,@Param("permissionId")Integer permissionId);
	public int deleteRolePermission(@Param("roleId")Integer roleId);
	
	/**
	 * 过滤查询用户
	 * cn.cauc.dao.role 
	 * 方法名：findFilterUsers
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午1:41:19 
	 * @param params
	 * @return 
	 * 返回值：List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String,Object>> findFilterUsers(TzParams params);
	public int countFilterUsers(TzParams params);
	
	
	/**
	 * 根据用户查询对应的角色
	 * cn.cauc.dao.role 
	 * 方法名：findRolesByUserId
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午1:41:47 
	 * @param userId
	 * @return 
	 * 返回值：HashMap<String,Object>
	 * @exception 
	 * @since  1.0.0
	 */
	public HashMap<String, Object> findRolesByUserId(Integer userId);
	/**
	 * 
	 * cn.cauc.dao.role 
	 * 方法名：update
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午9:22:19 
	 * @param role
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */

}
