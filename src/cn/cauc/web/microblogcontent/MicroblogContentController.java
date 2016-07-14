/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.microblogcontent
 * MicroblogContentController.java
 * 创建人:wangjie
 * 时间：2016年03月09日 21:28:17
 * 中国民航大学-版权所有
 */
package cn.cauc.web.microblogcontent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.cauc.bean.MicroblogContent;
import cn.cauc.bean.TzParams;
import cn.cauc.service.microblogcontent.IMicroblogContentService;

/**
 * 微博内容web
 * MicroblogContentController
 * 创建人:wangjie
 * 时间：2016年03月09日 21:28:17
 * @version 1.0.0
 */
@Controller
@RequestMapping("/admin/microblogcontent")
public class MicroblogContentController {
	
	@Autowired
	private IMicroblogContentService microblogcontentService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "microblogcontent/list";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<MicroblogContent> microblogcontents = microblogcontentService.findMicroblogContents(params);
		int count = microblogcontentService.count(params);
		modelAndView.setViewName("microblogcontent/template");
		modelAndView.addObject("datas",microblogcontents);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/update")
	@ResponseBody
	public String update(MicroblogContent microblogcontent){
		try {
			microblogcontentService.update(microblogcontent);
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
			microblogcontentService.delete(params);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
