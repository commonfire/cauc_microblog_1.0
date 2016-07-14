/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.blackman
 * BlackManController.java
 * 创建人:wangjie
 * 时间：2016年03月15日 14:45:38
 * 中国民航大学-版权所有
 */
package cn.cauc.service.blackman;

import java.util.List;

import cn.cauc.bean.BlackMan;
import cn.cauc.bean.TzParams;

/**
 * IBlackManService
 * 创建人:wangjie 
 * 时间：2016年03月15日 14:45:38
 * @version 1.0.0
 */
public interface IBlackManService {


	/**
	 * cn.cauc.service.blackman 
	 * 方法名：findBlackMans
	 * 创建人：wangjie 
	 * 时间：2016年03月15日 14:45:38
	 * @param params
	 * @return 
	 * 返回类型：List<BlackMan>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<BlackMan> findBlackMans(TzParams params);
	
	/**
	 * 求总数
	 * cn.cauc.dao.blackman 
	 * 方法名：count
	 * 创建人：wangjie 
	 * 时间：2016年03月15日 14:45:38
	 * @param id
	 * @return 
	 * 返回类型：List<BlackMan>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * cn.cauc.service.blackman 
	 * 方法名：findBlackMans
	 * 创建人：wangjie 
	 * 时间：2016年03月15日 14:45:38
	 * @param params
	 * @return 
	 * 返回类型：List<BlackMan>
	 * @exception 
	 * @since  1.0.0
	 */
	public BlackMan get(Integer id);
	
	/**
	 * 保存重点人员管理
	 * cn.cauc.service.blackman 
	 * 方法名：save
	 * 创建人：wangjie 
	 * 时间：2016年03月15日 14:45:38 
	 * @param blackman
	 * @return 
	 * 返回类型：BlackMan
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(BlackMan blackman);
	
	/**
	 * 更新重点人员管理
	 * cn.cauc.service.blackman 
	 * 方法名：update
	 * 创建人：wangjie 
	 * 时间：2016年03月15日 14:45:38
	 * @param blackman
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(BlackMan blackman);
	
	/**
	 * 删除重点人员管理
	 * cn.cauc.service.blackman 
	 * 方法名：delete
	 * 创建人：wangjie 
	 * 时间：2016年03月15日 14:45:38
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
}
