/**
 * 民航安全信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.user
 * UserController.java
 * 创建人:wangjie
 * 时间：2016年02月26日 09:56:28
 * 中国民航大学-版权所有
 */
package cn.cauc.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cauc.bean.TzParams;
import cn.cauc.bean.User;
import cn.cauc.dao.user.IUserMapper;
import cn.cauc.service.user.IUserService;
import cn.cauc.util.TmStringUtils;

/**
 * 用户管理serviceImpl
 * IUserService
 * 创建人:wangjie 
 * 时间：2016年02月26日 09:56:28
 * @version 1.0.0
 * 
 */
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserMapper userMapper;
	
	@Override
	public List<User> findUsers(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return userMapper.findUsers(params);
	}
	
	@Override
	public int count(TzParams params){
		return userMapper.count(params);
	}

	@Override
	public User get(Integer id) {
		return userMapper.get(id);
	}

	@Override
	public int save(User user) {
		return userMapper.save(user);
	}

	@Override
	public int update(User user) {
		return userMapper.update(user);
	}
	@Override
	public int updatePW(User user) {
		return userMapper.updatePW(user);
	}
	@Override
	public int delete(TzParams params) {
		return userMapper.delete(params);
	}

	@Override
	public User getLogin(TzParams params) {
		return userMapper.getLogin(params);
	}
}
