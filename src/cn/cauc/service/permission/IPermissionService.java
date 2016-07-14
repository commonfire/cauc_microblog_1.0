/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.permission
 * PermissionController.java
 * 创建人:wangjie
 * 时间：2016年03月10日 12:14:09
 * 中国民航大学-版权所有
 */
package cn.cauc.service.permission;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cauc.bean.Permission;
import cn.cauc.bean.TzParams;

/**
 * IPermissionService
 * 创建人:wangjie 
 * 时间：2016年03月10日 12:14:09
 * @version 1.0.0
 */
public interface IPermissionService {


	/**
	 * 
	 * cn.cauc.service.permission 
	 * 方法名：findPermissions
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午2:03:32 
	 * @param params
	 * @return 
	 * 返回值：HashMap<String,Object>
	 * @exception 
	 * @since  1.0.0
	 */

	//我们要学习json---前后台数据交互的---基础简单的文本---文本和流的输出
	//java----json--js/ajax---dom页面中 responseText
	//就是因为js无法调用java中类型和集合，所有说我们要通过一些工具json把java中的对象和数据类型转换成json字符串或者xml字符
	//JSON.parse();json-js中的对象
	//fastjson.jackjson.jsonutil.net.sf.jsonArray
	
//	 [ ===list<map/bean>
//		{name : "内容管理",url : "",opid : 1,pid : "root1"}, map/bean
//		{name : "日记管理",url : "",opid : 2,pid : "root2"}, map/bean
//		{name : "主题框架3",url : "",opid : 3,pid : "root3"}, map/bean
//		{name : "主题框架4",url : "",opid : 4,pid : "root4"}, map/bean
//		{name : "主题框架5",url : "",opid : 5,pid : "root5"}, map/bean
//		{name : "主题框架6",url : "",opid : 6,pid : "root6"} map/bean
//	]
	public HashMap<String,Object> findPermissions(TzParams params);
	
	/**
	 * 
	 * cn.cauc.service.permission 
	 * 方法名：count
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午2:03:41 
	 * @param params
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * cn.cauc.service.permission 
	 * 方法名：get
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午2:03:50 
	 * @param id
	 * @return 
	 * 返回值：Permission
	 * @exception 
	 * @since  1.0.0
	 */
	public Permission get(Integer id);
	
	/**
	 * 
	 * cn.cauc.service.permission 
	 * 方法名：save
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午2:04:05 
	 * @param permission
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Permission permission);
	
	/**
	 * 
	 * cn.cauc.service.permission 
	 * 方法名：update
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午2:03:59 
	 * @param permission
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Permission permission);
	
	/**
	 * 
	 * cn.cauc.service.permission 
	 * 方法名：delete
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午2:04:17 
	 * @param params
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
	
	/**
	 * 根据用户ID查询权限信息
	 * cn.cauc.service.permission 
	 * 方法名：findUserPersmission
	 * 创建人：wangjie 
	 * 时间：2016年3月10日-下午2:04:30 
	 * @param userId
	 * @return 
	 * 返回值：List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String, Object>> findUserPersmission(@Param("userId")Integer userId);
		
}
