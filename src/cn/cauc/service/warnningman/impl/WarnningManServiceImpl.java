/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.warnningman
 * WarnningManController.java
 * 创建人:wangjie
 * 时间：2016年03月15日 12:49:17
 * 中国民航大学-版权所有
 */
package cn.cauc.service.warnningman.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cauc.bean.WarnningMan;
import cn.cauc.bean.TzParams;
import cn.cauc.dao.warnningman.IWarnningManMapper;
import cn.cauc.service.warnningman.IWarnningManService;
import cn.cauc.util.TmStringUtils;

/**
 * 预警人员管理serviceImpl
 * IWarnningManService
 * 创建人:wangjie 
 * 时间：2016年03月15日 12:49:17
 * @version 1.0.0
 * 
 */
@Service
public class WarnningManServiceImpl implements IWarnningManService{

	@Autowired
	private IWarnningManMapper warnningmanMapper;
	
	@Override
	public List<WarnningMan> findWarnningMans(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("degree asc");
		return warnningmanMapper.findWarnningMans(params);
	}
	
	@Override
	public int count(TzParams params){
		return warnningmanMapper.count(params);
	}

	@Override
	public WarnningMan get(Integer id) {
		return warnningmanMapper.get(id);
	}

	@Override
	public int save(WarnningMan warnningman) {
		return warnningmanMapper.save(warnningman);
	}

	@Override
	public int update(WarnningMan warnningman) {
		return warnningmanMapper.update(warnningman);
	}

	@Override
	public int delete(TzParams params) {
		return warnningmanMapper.delete(params);
	}
}
