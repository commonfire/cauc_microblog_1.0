/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.rules
 * RulesController.java
 * 创建人:wangjie
 * 时间：2016年03月15日 15:16:27
 * 中国民航大学-版权所有
 */
package cn.cauc.web.rules;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cauc.bean.TzParams;

/**
 * 爬虫/预警规则web
 * RulesController
 * 创建人:wangjie
 * 时间：2016年03月15日 15:16:27
 * @version 1.0.0
 */
@Controller
@RequestMapping("/admin/rules")
public class RulesController {
	
//	@Autowired
//	private IRulesService rulesService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "rules/list";
	}
	
//	/*模板页面*/
//	@RequestMapping("/template")
//	public ModelAndView template(TzParams params){
//		ModelAndView modelAndView = new ModelAndView();
//		List<Rules> ruless = rulesService.findRuless(params);
//		int count = rulesService.count(params);
//		modelAndView.setViewName("rules/template");
//		modelAndView.addObject("datas",ruless);
//		modelAndView.addObject("itemCount",count);
//		return modelAndView;
//	}
//	
//	@RequestMapping(method=RequestMethod.POST,value="/update")
//	@ResponseBody
//	public String update(Rules rules){
//		try {
//			rulesService.update(rules);
//			return "success";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "error";
//		}
//	}
//	
//	@RequestMapping(method=RequestMethod.POST,value="/delete")
//	@ResponseBody
//	public String delete(TzParams params){
//		try {
//			rulesService.delete(params);
//			return "success";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "error";
//		}
//	}
//	
//	@RequestMapping(method=RequestMethod.POST,value="/save")
//	@ResponseBody
//	public String save(Rules rules){
//		try {	
//			rules.setPassword(TmStringUtils.md5Base64(rules.getPassword()));
//			rules.setUpdateTime(new Date());
//			rules.setIsDelete(0);
//			rules.setForbiden(0);
//			rulesService.save(rules);
//			return "success";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "error";
//		}
//	}

}
