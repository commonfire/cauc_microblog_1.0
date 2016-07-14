/**
 * 民航安全信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.test
 * ContentController.java
 * 创建人:王杰
 * 时间：2016年02月24日 20:17:23
 * 中国民航大学-版权所有
 */
package cn.cauc.test;

import java.util.List;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.cauc.bean.Provinces;
import cn.cauc.bean.Role;
import cn.cauc.bean.TzParams;
import cn.cauc.service.provinces.IProvincesService;
import cn.cauc.service.role.IRoleService;


/**
 * 
 * TestApplicationContext
 * 创建人:wangjie
 * 时间：2015年11月18日-上午11:35:24 
 * @version 1.0.0
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class TestRole {
	
	@Autowired
	IRoleService roleService;
	@Autowired
	IProvincesService provincesService;

	@Test
	public void handler() throws JSONException{
		TzParams params = new TzParams(); 
		params.setOrder("create_time desc");
		List<Role> roles = roleService.findRoles(params);
		int count = roleService.count(params);
		System.out.println(JSONUtil.serialize(roles)+"========="+count);
	}
	@Test
	public void handler2() throws JSONException{
		List<Provinces> provinces = provincesService.findProvincess();
		System.out.println(JSONUtil.serialize(provinces)+"============================");
	}

	
	
}
