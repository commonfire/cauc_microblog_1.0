/**
 * 民航安全信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.user
 * UserController.java
 * 创建人:wangjie
 * 时间：2016年02月26日 09:56:28
 * 中国民航大学-版权所有
 */
package cn.cauc.web.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.cauc.bean.TzParams;
import cn.cauc.bean.User;
import cn.cauc.service.user.IUserService;
import cn.cauc.util.TmStringUtils;

/**
 * 用户管理web
 * UserController
 * 创建人:wangjie
 * 时间：2016年02月26日 09:56:28
 * @version 1.0.0
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/list")
	public String list(TzParams params){
		return "user/list";
	}
	
	@RequestMapping("/add")
	public String add(TzParams params){
		return "user/add";
	}
	
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		params.setOrder("create_time desc");
		List<User> users = userService.findUsers(params);
		int count = userService.count(params);
		modelAndView.setViewName("user/template");
		modelAndView.addObject("datas",users);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}

	
	@RequestMapping(method=RequestMethod.POST,value="/update")
	@ResponseBody
	public String update(User user){
		try {
			user.setUpdateTime(new Date());
			userService.update(user);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping(method=RequestMethod.POST,value="/save")
	@ResponseBody
	public String save(User user){
		try {	
			user.setPassword(TmStringUtils.md5Base64(user.getPassword()));
			user.setUpdateTime(new Date());
			user.setIsDelete(0);
			user.setForbiden(0);
			userService.save(user);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/delete")
	@ResponseBody
	public String delete(TzParams params){
		try {
			userService.delete(params);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
