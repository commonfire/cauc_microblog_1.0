/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.dao.adminstat
 * IAdminStatMapper.java
 * 创建人:wangjie
 * 时间：2016年03月15日 14:45:38
 * 中国民航大学-版权所有
 */
package cn.cauc.dao.adminstat;

import java.util.HashMap;
import java.util.List;

import cn.cauc.bean.AdminStat;
import cn.cauc.bean.TzParams;

	/**
	 * 平台日志管理Mapper
	 * IAdminStatMapper
	 * 创建人:wangjie 
	 * 时间：2016年3月15日-下午4:58:26 
	 * @version 1.0.0
	 */
public interface IAdminStatMapper {

	/**
	 * 
	 * cn.cauc.dao.adminstat 
	 * 方法名：findAdminStats
	 * 创建人：wangjie 
	 * 时间：2016年3月15日-下午4:59:08 
	 * @param params
	 * @return 
	 * 返回值：List<AdminStat>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<AdminStat> findAdminStats(TzParams params);
	
	/**
	 * 
	 * cn.cauc.dao.adminstat 
	 * 方法名：count
	 * 创建人：wangjie 
	 * 时间：2016年3月15日-下午4:59:16 
	 * @param params
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * cn.cauc.dao.adminstat 
	 * 方法名：get
	 * 创建人：wangjie 
	 * 时间：2016年3月15日-下午4:59:23 
	 * @param id
	 * @return 
	 * 返回值：AdminStat
	 * @exception 
	 * @since  1.0.0
	 */
	public AdminStat get(Integer id);
	
	/**
	 * 
	 * cn.cauc.dao.adminstat 
	 * 方法名：save
	 * 创建人：wangjie 
	 * 时间：2016年3月15日-下午4:59:31 
	 * @param adminstat
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(AdminStat adminstat);
	
	/**
	 * 
	 * cn.cauc.dao.adminstat 
	 * 方法名：update
	 * 创建人：wangjie 
	 * 时间：2016年3月15日-下午4:59:39 
	 * @param adminstat
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(AdminStat adminstat);
	
	/**
	 * 
	 * cn.cauc.dao.adminstat 
	 * 方法名：delete
	 * 创建人：wangjie 
	 * 时间：2016年3月15日-下午4:59:47 
	 * @param params
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
		
	/**
	 * 统计出某一天中某一时刻的注册用户
	 * cn.cauc.dao.adminstat 
	 * 方法名：groupUsers
	 * 创建人：wangjie 
	 * 时间：2016年3月15日-下午5:00:08 
	 * @param params
	 * @return 
	 * 返回值：List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String,Object>> groupUsers(TzParams params);
	
}
