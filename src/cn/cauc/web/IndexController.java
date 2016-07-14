/**
 * 民航安全信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web
 * IndexController.java
 * 创建人:wangjie
 * 时间：2016年02月24日 20:31:58
 * 中国民航大学-版权所有
 */
package cn.cauc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * IndexController
 * 创建人:wangjie 
 * 时间：2016年3月10日-下午2:20:56 
 * @version 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class IndexController {

	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
}

