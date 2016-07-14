/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.adminstat
 * AdminStatController.java
 * 创建人:wangjie
 * 时间：2016年03月15日 16:30:52
 * 中国民航大学-版权所有
 */
package cn.cauc.service.adminstat;

import java.util.HashMap;
import java.util.List;

import cn.cauc.bean.AdminStat;
import cn.cauc.bean.TzParams;

/**
 * IAdminStatService
 * 创建人:wangjie 
 * 时间：2016年03月15日 16:30:52
 * @version 1.0.0
 */
public interface IAdminStatService {


	/**
	 * cn.cauc.service.adminstat 
	 * 方法名：findAdminStats
	 * 创建人：wangjie 
	 * 时间：2016年03月15日 16:30:52
	 * @param params
	 * @return 
	 * 返回类型：List<AdminStat>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<AdminStat> findAdminStats(TzParams params);
	
	/**
	 * 求总数
	 * cn.cauc.dao.adminstat 
	 * 方法名：count
	 * 创建人：wangjie 
	 * 时间：2016年03月15日 16:30:52
	 * @param id
	 * @return 
	 * 返回类型：List<AdminStat>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * cn.cauc.service.adminstat 
	 * 方法名：findAdminStats
	 * 创建人：wangjie 
	 * 时间：2016年03月15日 16:30:52
	 * @param params
	 * @return 
	 * 返回类型：List<AdminStat>
	 * @exception 
	 * @since  1.0.0
	 */
	public AdminStat get(Integer id);
	
	/**
	 * 保存平台日志统计
	 * cn.cauc.service.adminstat 
	 * 方法名：save
	 * 创建人：wangjie 
	 * 时间：2016年03月15日 16:30:52 
	 * @param adminstat
	 * @return 
	 * 返回类型：AdminStat
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(AdminStat adminstat);
	
	/**
	 * 更新平台日志统计
	 * cn.cauc.service.adminstat 
	 * 方法名：update
	 * 创建人：wangjie 
	 * 时间：2016年03月15日 16:30:52
	 * @param adminstat
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(AdminStat adminstat);
	
	/**
	 * 删除平台日志统计
	 * cn.cauc.service.adminstat 
	 * 方法名：delete
	 * 创建人：wangjie 
	 * 时间：2016年03月15日 16:30:52
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
	
	/**
	 * 统计出某一天中某一时刻的注册用户
	 * com.tz.service.adminstat 
	 * 方法名：groupUsers
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2015年12月9日-下午10:23:50 
	 * @param params
	 * @return 
	 * 返回类型：List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String,Object>> groupUsers(TzParams params);
}
