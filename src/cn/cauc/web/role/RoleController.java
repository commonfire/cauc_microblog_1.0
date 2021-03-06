/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.role
 * RoleController.java
 * 创建人:wangjie
 * 时间：2016年03月10日 12:16:11
 * 中国民航大学-版权所有
 */
package cn.cauc.web.role;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.cauc.bean.Role;
import cn.cauc.bean.TzParams;
import cn.cauc.service.role.IRoleService;
import cn.cauc.util.TmStringUtils;

/**
 * 角色管理web
 * RoleController
 * 创建人:wangjie
 * 时间：2016年03月10日 12:16:11
 * @version 1.0.0
 */
@Controller
@RequestMapping("/admin/role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "role/list";
	}
	
	@RequestMapping("/user/{rid}")
	public ModelAndView user(@PathVariable("rid")Integer roleId,TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		params.setIsDelete(0);
		params.setRoleId(roleId);
		params.setPageSize(30);
		List<HashMap<String, Object>> adminUsers = roleService.findFilterUsers(params);
		int totalCount = roleService.countFilterUsers(params);
		modelAndView.addObject("datas", adminUsers);
		modelAndView.addObject("count", totalCount);
		modelAndView.setViewName("role/user");
		return modelAndView;
	}
	
	@RequestMapping("/permission/{rid}")
	public ModelAndView permission(@PathVariable("rid")Integer roleId,TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("role/permission");
		return modelAndView;
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		params.setOrder("id asc");
		List<Role> roles = roleService.findRoles(params);
		int count = roleService.count(params);
		modelAndView.setViewName("role/template");
		modelAndView.addObject("datas",roles);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="/saveUserRole",method=RequestMethod.POST)
	public String saveUserRole(HttpServletRequest request){
		//获取所有的分配的用户
		String userstring = request.getParameter("users");
		//角色id
		String rid = request.getParameter("rid");
		if(TmStringUtils.isNotEmpty(userstring) && TmStringUtils.isNotEmpty(rid)){
			//分配角色给用户
			String[] users = userstring.split(",");
			for (String string : users) {
				roleService.saveRoleUser(Integer.parseInt(string), Integer.parseInt(rid));
			}
			return "success";
		}else{
			return "fail";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/saveRolePermission",method=RequestMethod.POST)
	public String saveRolePermission(HttpServletRequest request){
		//获取所有的权限
		String userstring = request.getParameter("permissions");
		//获取分配的角色
		String roleId = request.getParameter("rid");
		//如果权限有，角色不为空
		if(TmStringUtils.isNotEmpty(userstring) && TmStringUtils.isNotEmpty(roleId)){
			Integer rid = Integer.parseInt(roleId);
			//删除角色对应的权限
			roleService.deleteRolePermission(rid);
			//重新分配
			String[] users = userstring.split(",");
			for (String string : users) {
				roleService.saveRolePermission(rid,Integer.parseInt(string));
			}
			return "success";
		}else{
			return "fail";
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/update")
	@ResponseBody
	public String update(Role role){
		try {
			roleService.update(role);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}