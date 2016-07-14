/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.warnningman
 * WarnningManController.java
 * 创建人:wangjie
 * 时间：2016年03月15日 12:49:17
 * 中国民航大学-版权所有
 */
package cn.cauc.service.warnningman;

import java.util.List;

import cn.cauc.bean.WarnningMan;
import cn.cauc.bean.TzParams;

/**
 * IWarnningManService
 * 创建人:wangjie 
 * 时间：2016年03月15日 12:49:17
 * @version 1.0.0
 */
public interface IWarnningManService {


	/**
	 * cn.cauc.service.warnningman 
	 * 方法名：findWarnningMans
	 * 创建人：wangjie 
	 * 时间：2016年03月15日 12:49:17
	 * @param params
	 * @return 
	 * 返回类型：List<WarnningMan>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<WarnningMan> findWarnningMans(TzParams params);
	
	/**
	 * 求总数
	 * cn.cauc.dao.warnningman 
	 * 方法名：count
	 * 创建人：wangjie 
	 * 时间：2016年03月15日 12:49:17
	 * @param id
	 * @return 
	 * 返回类型：List<WarnningMan>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * cn.cauc.service.warnningman 
	 * 方法名：findWarnningMans
	 * 创建人：wangjie 
	 * 时间：2016年03月15日 12:49:17
	 * @param params
	 * @return 
	 * 返回类型：List<WarnningMan>
	 * @exception 
	 * @since  1.0.0
	 */
	public WarnningMan get(Integer id);
	
	/**
	 * 保存预警人员管理
	 * cn.cauc.service.warnningman 
	 * 方法名：save
	 * 创建人：wangjie 
	 * 时间：2016年03月15日 12:49:17 
	 * @param warnningman
	 * @return 
	 * 返回类型：WarnningMan
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(WarnningMan warnningman);
	
	/**
	 * 更新预警人员管理
	 * cn.cauc.service.warnningman 
	 * 方法名：update
	 * 创建人：wangjie 
	 * 时间：2016年03月15日 12:49:17
	 * @param warnningman
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(WarnningMan warnningman);
	
	/**
	 * 删除预警人员管理
	 * cn.cauc.service.warnningman 
	 * 方法名：delete
	 * 创建人：wangjie 
	 * 时间：2016年03月15日 12:49:17
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
}
