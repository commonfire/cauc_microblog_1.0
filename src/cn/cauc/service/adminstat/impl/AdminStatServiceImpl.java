/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.adminstat
 * AdminStatController.java
 * 创建人:wangjie
 * 时间：2016年03月15日 16:30:52
 * 中国民航大学-版权所有
 */
package cn.cauc.service.adminstat.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cauc.bean.AdminStat;
import cn.cauc.bean.TzParams;
import cn.cauc.dao.adminstat.IAdminStatMapper;
import cn.cauc.service.adminstat.IAdminStatService;
import cn.cauc.util.TmStringUtils;

/**
 * 平台日志统计serviceImpl
 * IAdminStatService
 * 创建人:wangjie 
 * 时间：2016年03月15日 16:30:52
 * @version 1.0.0
 * 
 */
@Service
public class AdminStatServiceImpl implements IAdminStatService{

	@Autowired
	private IAdminStatMapper adminstatMapper;
	
	@Override
	public List<AdminStat> findAdminStats(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return adminstatMapper.findAdminStats(params);
	}
	
	@Override
	public int count(TzParams params){
		return adminstatMapper.count(params);
	}

	@Override
	public AdminStat get(Integer id) {
		return adminstatMapper.get(id);
	}

	@Override
	public int save(AdminStat adminstat) {
		return adminstatMapper.save(adminstat);
	}

	@Override
	public int update(AdminStat adminstat) {
		return adminstatMapper.update(adminstat);
	}

	@Override
	public int delete(TzParams params) {
		return adminstatMapper.delete(params);
	}
	

	@Override
	public List<HashMap<String, Object>> groupUsers(TzParams params) {
		return adminstatMapper.groupUsers(params);
	}
}
