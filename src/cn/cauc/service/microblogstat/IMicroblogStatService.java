/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.service.microblogstat
 * IMicroblogStatService.java
 * 创建人:wangjie
 * 时间：2016年03月16日 10:34:24
 * 中国民航大学-版权所有
 */
package cn.cauc.service.microblogstat;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cauc.bean.MicroblogStat;
import cn.cauc.bean.TzParams;

/**
 * IMicroblogStatService
 * 创建人:wangjie 
 * 时间：2016年03月16日 10:34:24
 * @version 1.0.0
 */
public interface IMicroblogStatService {


	/**
	 * cn.cauc.service.microblogstat 
	 * 方法名：findMicroblogStats
	 * 创建人：wangjie 
	 * 时间：2016年03月16日 10:34:24
	 * @param params
	 * @return 
	 * 返回类型：List<MicroblogStat>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<MicroblogStat> findMicroblogStats(TzParams params);
	
	/**
	 * 求总数
	 * cn.cauc.dao.microblogstat 
	 * 方法名：count
	 * 创建人：wangjie 
	 * 时间：2016年03月16日 10:34:24
	 * @param id
	 * @return 
	 * 返回类型：List<MicroblogStat>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * cn.cauc.service.microblogstat 
	 * 方法名：findMicroblogStats
	 * 创建人：wangjie 
	 * 时间：2016年03月16日 10:34:24
	 * @param params
	 * @return 
	 * 返回类型：List<MicroblogStat>
	 * @exception 
	 * @since  1.0.0
	 */
	public MicroblogStat get(Integer id);
	
	/**
	 * 保存微博数据统计
	 * cn.cauc.service.microblogstat 
	 * 方法名：save
	 * 创建人：wangjie 
	 * 时间：2016年03月16日 10:34:24 
	 * @param microblogstat
	 * @return 
	 * 返回类型：MicroblogStat
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(MicroblogStat microblogstat);
	
	/**
	 * 更新微博数据统计
	 * cn.cauc.service.microblogstat 
	 * 方法名：update
	 * 创建人：wangjie 
	 * 时间：2016年03月16日 10:34:24
	 * @param microblogstat
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(MicroblogStat microblogstat);
	
	/**
	 * 删除微博数据统计
	 * cn.cauc.service.microblogstat 
	 * 方法名：delete
	 * 创建人：wangjie 
	 * 时间：2016年03月16日 10:34:24
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
	/**
	 * 
	 * cn.cauc.service.adminstat 
	 * 方法名：groupContent
	 * 创建人：wangjie 
	 * 时间：2016年3月15日-下午5:06:10 
	 * @param params
	 * @return 
	 * 返回值：List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String, Object>> groupContent(TzParams params);
	/**
	 * 根据月份查询具体内容信息
	 * com.tz.service.adminstat 
	 * 方法名：groupContents
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2015年12月9日-下午9:25:41 
	 * @param params
	 * @return 
	 * 返回类型：List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String,Object>> groupContents(TzParams params);
	
	/**
	 *  统计微博用户的男女比例
	 * cn.cauc.service.microblogstat 
	 * 方法名：groupSex
	 * 创建人：wangjie 
	 * 时间：2015年12月11日-下午4:09:06 
	 * @param params
	 * @return 
	 * 返回值：List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String,Object>> groupSex(TzParams params);
	
	/**
	 * 统计微博用户的年龄比例
	 * cn.cauc.service.microblogstat 
	 * 方法名：groupAge
	 * 创建人：wangjie 
	 * 时间：2015年12月11日-下午4:10:20 
	 * @param params
	 * @return 
	 * 返回值：List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String,Object>> groupAge(TzParams params);
	/**
	 * 
	 * 统计微博用户的所在省份人数
	 * cn.cauc.service.microblogstat 
	 * 方法名：groupLocation
	 * 创建人：wangjie 
	 * 时间：2015年12月12日-上午10:13:26 
	 * @param params
	 * @return 
	 * 返回值：List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String,Object>> groupLocation(TzParams params);

	/**
	 * 搜索舆情分数
	 * cn.cauc.service.microblogstat 
	 * 方法名：findDegreeScore
	 * 创建人：wangjie 
	 * 时间：2015年12月23日-下午2:41:02 
	 * @param params
	 * @return 
	 * 返回值：float
	 * @exception 
	 * @since  1.0.0
	 */
	public String findDegreeScore(TzParams params);
	/**
	 * 
	 * 查找朋友圈主节点
	 * com.tz.dao.friendcircle 
	 * 方法名：findMainNode
	 * 创建人：wangjie 
	 * 时间：2015年12月23日-下午9:40:26 
	 * @param params
	 * @return 
	 * 返回值：List<FriendCircle>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String,Object>> findNodes(@Param("userId")String userId);
	/**
	 * 
	 * 找到朋友圈所有的@的关系
	 * com.tz.dao.friendcircle 
	 * 方法名：findLinks
	 * 创建人：wangjie 
	 * 时间：2015年12月25日-下午7:26:34 
	 * @param params
	 * @return 
	 * 返回值：List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String,Object>> findLinks();
	/**
	 * 
	 * 找到两个节点之间的@关系
	 * com.tz.dao.friendcircle 
	 * 方法名：findNodesLinks
	 * 创建人：wangjie 
	 * 时间：2015年12月26日-下午3:47:55 
	 * @param userId
	 * @param atuserId
	 * @return 
	 * 返回值：List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String,Object>> findNodesLinks(@Param("userId")String userId);
	/**
	 * 
	 * 通过用户ID获取用户节点@总数值
	 * com.tz.dao.friendcircle 
	 * 方法名：countNodeValue
	 * 创建人：wangjie 
	 * 时间：2015年12月25日-下午1:19:06 
	 * @param userId
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */	
	public String countNodeValue(@Param("userId")String userId);
	/**
	 * 
	 * 计算两个用户之间@总数
	 * com.tz.dao.friendcircle 
	 * 方法名：countLinkWeight
	 * 创建人：wangjie 
	 * 时间：2015年12月25日-下午7:30:09 
	 * @param userId
	 * @param atuserId
	 * @return 
	 * 返回值：int
	 * @exception 
	 * @since  1.0.0
	 */
	public String countLinkWeight(@Param("userId")String userId,@Param("atuserId")String atuserId);
}
