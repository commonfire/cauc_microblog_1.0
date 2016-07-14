/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.role
 * RoleController.java
 * 创建人:wangjie
 * 时间：2016年03月10日 12:16:11
 * 中国民航大学-版权所有
 */
package cn.cauc.service.role.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cauc.bean.Role;
import cn.cauc.bean.TzParams;
import cn.cauc.dao.role.IRoleMapper;
import cn.cauc.service.role.IRoleService;
import cn.cauc.util.TmStringUtils;

/**
 * 角色管理serviceImpl
 * IRoleService
 * 创建人:wangjie 
 * 时间：2016年03月10日 12:16:11
 * @version 1.0.0
 * 
 */
@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	private IRoleMapper roleMapper;
	
	@Override
	public List<Role> findRoles(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return roleMapper.findRoles(params);
	}
	
	@Override
	public int count(TzParams params){
		return roleMapper.count(params);
	}

	@Override
	public Role get(Integer id) {
		return roleMapper.get(id);
	}

	@Override
	public int save(Role role) {
		return roleMapper.save(role);
	}

	@Override
	public int update(Role role) {
		return roleMapper.update(role);
	}

	@Override
	public int delete(TzParams params) {
		return roleMapper.delete(params);
	}

	@Override
	public int saveRoleUser(Integer userId, Integer roleId) {
		return roleMapper.saveRoleUser(userId, roleId);
	}

	@Override
	public List<HashMap<String, Object>> findFilterUsers(TzParams params) {
		return roleMapper.findFilterUsers(params);
	}

	
	@Override
	public int countFilterUsers(TzParams params) {
		return roleMapper.countFilterUsers(params);
	}

	@Override
	public int saveRolePermission(Integer roleId, Integer permissionId) {
		return roleMapper.saveRolePermission(roleId, permissionId);
	}
	
	@Override
	public int deleteRolePermission(Integer roleId) {
		return roleMapper.deleteRolePermission(roleId);
	}

	@Override
	public HashMap<String, Object> findRolesByUserId(Integer userId) {
		return roleMapper.findRolesByUserId(userId);
	}
}
