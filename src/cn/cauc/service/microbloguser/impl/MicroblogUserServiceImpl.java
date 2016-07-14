/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.microbloguser
 * MicroblogUserController.java
 * 创建人:wangjie
 * 时间：2016年03月10日 11:57:43
 * 中国民航大学-版权所有
 */
package cn.cauc.service.microbloguser.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cauc.bean.MicroblogUser;
import cn.cauc.bean.TzParams;
import cn.cauc.dao.microbloguser.IMicroblogUserMapper;
import cn.cauc.service.microbloguser.IMicroblogUserService;
import cn.cauc.util.TmStringUtils;

/**
 * 微博用户serviceImpl
 * IMicroblogUserService
 * 创建人:wangjie 
 * 时间：2016年03月10日 11:57:43
 * @version 1.0.0
 * 
 */
@Service
public class MicroblogUserServiceImpl implements IMicroblogUserService{

	@Autowired
	private IMicroblogUserMapper microbloguserMapper;
	
	@Override
	public List<MicroblogUser> findMicroblogUsers(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("register_time desc");
		return microbloguserMapper.findMicroblogUsers(params);
	}
	
	@Override
	public int count(TzParams params){
		return microbloguserMapper.count(params);
	}

	@Override
	public MicroblogUser get(Integer id) {
		return microbloguserMapper.get(id);
	}

	@Override
	public int save(MicroblogUser microbloguser) {
		return microbloguserMapper.save(microbloguser);
	}

	@Override
	public int update(MicroblogUser microbloguser) {
		return microbloguserMapper.update(microbloguser);
	}

	@Override
	public int delete(TzParams params) {
		return microbloguserMapper.delete(params);
	}
}
