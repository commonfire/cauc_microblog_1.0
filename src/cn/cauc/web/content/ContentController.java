/**
 * 民航安全信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.content
 * ContentController.java
 * 创建人:wangjie
 * 时间：2016年02月24日 20:31:58
 * 中国民航大学-版权所有
 */
package cn.cauc.web.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.cauc.bean.Content;
import cn.cauc.bean.TzParams;
import cn.cauc.service.content.IContentService;

/**
 * 内容管理web
 * ContentController
 * 创建人:wangjie
 * 时间：2016年02月24日 20:31:58
 * @version 1.0.0
 */
@Controller
@RequestMapping("/admin/content")
public class ContentController {
	
	@Autowired
	private IContentService contentService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "content/list";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<Content> contents = contentService.findContents(params);
		int count = contentService.count(params);
		modelAndView.setViewName("content/template");
		modelAndView.addObject("datas",contents);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
}
