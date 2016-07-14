/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.blackman
 * BlackManController.java
 * 创建人:wangjie
 * 时间：2016年03月15日 14:45:38
 * 中国民航大学-版权所有
 */
package cn.cauc.web.blackman;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.cauc.bean.BlackMan;
import cn.cauc.bean.Provinces;
import cn.cauc.bean.TzParams;
import cn.cauc.service.blackman.IBlackManService;
import cn.cauc.service.provinces.IProvincesService;
import cn.cauc.util.TmStringUtils;

/**
 * 重点人员管理web
 * BlackManController
 * 创建人:wangjie
 * 时间：2016年03月15日 14:45:38
 * @version 1.0.0
 */
@Controller
@RequestMapping("/admin/blackman")
public class BlackManController {
	
	@Autowired
	private IBlackManService blackmanService;
	@Autowired
	private IProvincesService provincesService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public ModelAndView list(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<Provinces> provinces = provincesService.findProvincess();
		modelAndView.setViewName("blackman/list");
		modelAndView.addObject("provinces",provinces);		
		return modelAndView;
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<BlackMan> blackmans = blackmanService.findBlackMans(params);
		int count = blackmanService.count(params);
		modelAndView.setViewName("blackman/template");
		modelAndView.addObject("datas",blackmans);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/update")
	@ResponseBody
	public String update(BlackMan blackman){
		try {
			blackmanService.update(blackman);
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
			blackmanService.delete(params);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/save")
	@ResponseBody
	public String save(BlackMan blackman){
		try {	
/*			blackman.setPassword(TmStringUtils.md5Base64(blackman.getPassword()));
			blackman.setUpdateTime(new Date());
			blackman.setIsDelete(0);
			blackman.setForbiden(0);*/
			blackmanService.save(blackman);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}
