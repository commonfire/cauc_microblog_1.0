/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.adminstat
 * AdminStatController.java
 * 创建人:wangjie
 * 时间：2016年03月15日 16:30:52
 * 中国民航大学-版权所有
 */
package cn.cauc.web.adminstat;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.cauc.bean.AdminStat;
import cn.cauc.bean.TzParams;
import cn.cauc.service.adminstat.IAdminStatService;

/**
 * 平台日志统计web
 * AdminStatController
 * 创建人:wangjie
 * 时间：2016年03月15日 16:30:52
 * @version 1.0.0
 */
@Controller
@RequestMapping("/admin/adminstat")
public class AdminStatController {
	@Autowired
	private IAdminStatService adminstatService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "adminstat/list";
	}
	
	/*用户统计列表查询*/
	@RequestMapping(value="/userlist")
	public String userlist(){
		return "adminstat/userlist";
	}
	

	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/groupusers")
	public List<HashMap<String, Object>> groupUsers(TzParams params){
		List<HashMap<String, Object>> datas = adminstatService.groupUsers(params);
		return datas;
	}
}
