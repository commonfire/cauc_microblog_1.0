/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.permission
 * PermissionController.java
 * 创建人:wangjie
 * 时间：2016年03月10日 12:14:09
 * 中国民航大学-版权所有
 */
package cn.cauc.service.permission.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cauc.bean.Permission;
import cn.cauc.bean.TzParams;
import cn.cauc.dao.permission.IPermissionMapper;
import cn.cauc.service.permission.IPermissionService;

/**
 * 权限管理serviceImpl
 * IPermissionService
 * 创建人:wangjie 
 * 时间：2016年03月10日 12:14:09
 * @version 1.0.0
 * 
 */
@Service
public class PermissionServiceImpl implements IPermissionService{

	@Autowired
	private IPermissionMapper permissionMapper;
	
	
	
	/**
	 * 
				//我们要学习json---前后台数据交互的---基础简单的文本---文本和流的输出
				//java----json--js/ajax---dom页面中 responseText
				//就是因为js无法调用java中类型和集合，所有说我们要通过一些工具json把java中的对象和数据类型转换成json字符串或者xml字符
				//JSON.parse();json-js中的对象
				//fastjson.jackjson.jsonutil.net.sf.jsonArray
				
//				 [ ===list<map/bean>
//					{name : "内容管理",url : "",opid : 1,pid : "root1"}, map/bean
//					{name : "日记管理",url : "",opid : 2,pid : "root2"}, map/bean
//					{name : "主题框架3",url : "",opid : 3,pid : "root3"}, map/bean
//					{name : "主题框架4",url : "",opid : 4,pid : "root4"}, map/bean
//					{name : "主题框架5",url : "",opid : 5,pid : "root5"}, map/bean
//					{name : "主题框架6",url : "",opid : 6,pid : "root6"} map/bean
//				]
	 * (这里用一句话描述这个方法的作用)
	 * com.tz.service.permission.impl 
	 * 方法名：findPermissions
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2015年12月14日-下午11:30:39 
	 * @param params
	 * @return 
	 * 返回类型：List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */

	
//	map<root,List<Map>
	//子类
	TreeMap<String,List<HashMap<String, Object>>> childrenMap = null;
	@Override
	public HashMap<String,Object> findPermissions(TzParams params){
		//返回类型
		HashMap<String, Object> datas = new HashMap<>();
		//装载所有的子元素
		childrenMap = new TreeMap<>();
		//所有的根目标
		List<Permission> permissions = permissionMapper.findPermissionRoot(params);
		if(permissions!=null && permissions.size()>0){
			List<HashMap<String, Object>> maps = new ArrayList<>();//泛型的菱形写法 jdk1.7
			for (Permission permission : permissions) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("name", permission.getName());
				map.put("url", "javascript:void(0);");
				map.put("opid", permission.getId());
				map.put("pid", permission.getId());
				maps.add(map);
				getChildrenData(permission.getId());
			}
			datas.put("root", maps);
			datas.put("children", childrenMap);
			return datas;
		}else{
			return null;
		}
	}
	
	
	/**
	 * com.tz.service.permission.impl 
	 * 方法名：getChildrenData
	 * 创建人：wangjie
	 * 时间：2015年12月15日-上午12:23:53 
	 * @param pid 
	 * 返回类型：void
	 * @exception 
	 * @since  1.0.0
	 */
	private void getChildrenData(Integer pid){
		//查询所有的子类
		List<Permission> childrenPermissions = permissionMapper.findPermissionChildren(pid);
		//判断是否还有子类对象
		if(childrenPermissions!=null && childrenPermissions.size()>0){
			//数据类型接受
			List<HashMap<String, Object>> maps = new ArrayList<>();//泛型的菱形写法 jdk1.7
			//开始循环所有子类
			for (Permission permission : childrenPermissions) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("name", permission.getName());
				map.put("url", "javascript:void(0);");
				map.put("opid", permission.getId());
				map.put("pid", permission.getId());
				//添加到返回值中
				maps.add(map);
				getChildrenData(permission.getId());
			}
			childrenMap.put(pid+"", maps);
		}
	}
	
	
	
	@Override
	public int count(TzParams params){
		return permissionMapper.count(params);
	}

	@Override
	public Permission get(Integer id) {
		return permissionMapper.get(id);
	}

	@Override
	public int save(Permission permission) {
		return permissionMapper.save(permission);
	}

	@Override
	public int update(Permission permission) {
		return permissionMapper.update(permission);
	}

	@Override
	public int delete(TzParams params) {
		return permissionMapper.delete(params);
	}


	@Override
	public List<HashMap<String, Object>> findUserPersmission(Integer userId) {
		return permissionMapper.findUserPersmission(userId);
	}
}
