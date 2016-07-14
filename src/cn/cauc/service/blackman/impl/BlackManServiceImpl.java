/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.blackman
 * BlackManController.java
 * 创建人:wangjie
 * 时间：2016年03月15日 14:45:38
 * 中国民航大学-版权所有
 */
package cn.cauc.service.blackman.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cauc.bean.BlackMan;
import cn.cauc.bean.TzParams;
import cn.cauc.dao.blackman.IBlackManMapper;
import cn.cauc.service.blackman.IBlackManService;
import cn.cauc.util.TmStringUtils;

/**
 * 重点人员管理serviceImpl
 * IBlackManService
 * 创建人:wangjie 
 * 时间：2016年03月15日 14:45:38
 * @version 1.0.0
 * 
 */
@Service
public class BlackManServiceImpl implements IBlackManService{

	@Autowired
	private IBlackManMapper blackmanMapper;
	
	@Override
	public List<BlackMan> findBlackMans(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("degree asc");
		return blackmanMapper.findBlackMans(params);
	}
	
	@Override
	public int count(TzParams params){
		return blackmanMapper.count(params);
	}

	@Override
	public BlackMan get(Integer id) {
		return blackmanMapper.get(id);
	}

	@Override
	public int save(BlackMan blackman) {
		return blackmanMapper.save(blackman);
	}

	@Override
	public int update(BlackMan blackman) {
		return blackmanMapper.update(blackman);
	}

	@Override
	public int delete(TzParams params) {
		return blackmanMapper.delete(params);
	}
}
