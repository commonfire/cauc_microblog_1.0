/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.warnningman
 * WarnningManController.java
 * 创建人:wangjie
 * 时间：2016年03月15日 12:49:17
 * 中国民航大学-版权所有
 */
package cn.cauc.web.warnningman;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.cauc.bean.Provinces;
import cn.cauc.bean.WarnningMan;
import cn.cauc.bean.TzParams;
import cn.cauc.service.provinces.IProvincesService;
import cn.cauc.service.warnningman.IWarnningManService;
import cn.cauc.util.TmStringUtils;

/**
 * 预警人员管理web
 * WarnningManController
 * 创建人:wangjie
 * 时间：2016年03月15日 12:49:17
 * @version 1.0.0
 */
@Controller
@RequestMapping("/admin/warnningman")
public class WarnningManController {
	
	@Autowired
	private IWarnningManService warnningmanService;
	@Autowired
	private IProvincesService provincesService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public ModelAndView list(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<Provinces> provinces = provincesService.findProvincess();
		modelAndView.setViewName("warnningman/list");
		modelAndView.addObject("provinces",provinces);		
		return modelAndView;
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<WarnningMan> warnningmans = warnningmanService.findWarnningMans(params);
		int count = warnningmanService.count(params);
		modelAndView.setViewName("warnningman/template");
		modelAndView.addObject("datas",warnningmans);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/update")
	@ResponseBody
	public String update(WarnningMan warnningman){
		try {
			warnningmanService.update(warnningman);
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
			warnningmanService.delete(params);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/save")
	@ResponseBody
	public String save(WarnningMan warnningman){
		try {	
/*			warnningman.setPassword(TmStringUtils.md5Base64(warnningman.getPassword()));
			warnningman.setUpdateTime(new Date());
			warnningman.setIsDelete(0);
			warnningman.setForbiden(0);
*/			warnningmanService.save(warnningman);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}
