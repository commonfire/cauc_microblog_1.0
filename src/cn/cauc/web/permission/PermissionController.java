/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.permission
 * PermissionController.java
 * 创建人:wangjie
 * 时间：2016年03月10日 12:14:09
 * 中国民航大学-版权所有
 */
package cn.cauc.web.permission;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cauc.bean.TzParams;
import cn.cauc.service.permission.IPermissionService;

/**
 * 权限管理web
 * PermissionController
 * 创建人:wangjie
 * 时间：2016年03月10日 12:14:09
 * @version 1.0.0
 */
@Controller
@RequestMapping("/admin/permission")
public class PermissionController {
	
	@Autowired
	private IPermissionService permissionService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "permission/list";
	}
	
	
	/*列表查询*/
	@ResponseBody
	@RequestMapping("/root")
	public HashMap<String, Object> root(TzParams params){
		return permissionService.findPermissions(params);
	}
}
