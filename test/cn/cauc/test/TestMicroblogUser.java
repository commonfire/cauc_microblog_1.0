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

import cn.cauc.bean.MicroblogUser;
import cn.cauc.bean.TzParams;
import cn.cauc.service.microbloguser.IMicroblogUserService;


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
public class TestMicroblogUser {
	
	@Autowired
	IMicroblogUserService microblogUserService;

	@Test
	public void handler() throws JSONException{
		TzParams params = new TzParams(); 
		params.setOrder("register_time desc");
		params.setSex("男");
		List<MicroblogUser> microblogusers = microblogUserService.findMicroblogUsers(params);
		int count = microblogUserService.count(params);
		System.out.println(JSONUtil.serialize(microblogusers)+"========="+count);
	}	
	
	
}
