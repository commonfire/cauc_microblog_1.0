/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.microbloguser
 * MicroblogUserController.java
 * 创建人:wangjie
 * 时间：2016年03月10日 11:57:43
 * 中国民航大学-版权所有
 */
package cn.cauc.web.microbloguser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.cauc.bean.MicroblogUser;
import cn.cauc.bean.Provinces;
import cn.cauc.bean.TzParams;
import cn.cauc.service.microbloguser.IMicroblogUserService;
import cn.cauc.service.provinces.IProvincesService;

/**
 * 微博用户web
 * MicroblogUserController
 * 创建人:wangjie
 * 时间：2016年03月10日 11:57:43
 * @version 1.0.0
 */
@Controller
@RequestMapping("/admin/microbloguser")
public class MicroblogUserController {
	
	@Autowired
	private IMicroblogUserService microblogUserService;
	@Autowired
	private IProvincesService provincesService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public ModelAndView list(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<Provinces> provinces = provincesService.findProvincess();
		modelAndView.setViewName("microbloguser/list");
		modelAndView.addObject("provinces",provinces);		
		return modelAndView;
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<MicroblogUser> microblogusers = microblogUserService.findMicroblogUsers(params);
		int count = microblogUserService.count(params);
		modelAndView.setViewName("microbloguser/template");
		modelAndView.addObject("datas",microblogusers);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/update")
	@ResponseBody
	public String update(MicroblogUser microbloguser){
		try {
			microblogUserService.update(microbloguser);
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
			microblogUserService.delete(params);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
