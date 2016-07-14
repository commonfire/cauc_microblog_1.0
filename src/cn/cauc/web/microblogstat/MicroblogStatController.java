/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.microblogstat
 * MicroblogStatController.java
 * 创建人:wangjie
 * 时间：2016年03月16日 10:34:24
 * 中国民航大学-版权所有
 */
package cn.cauc.web.microblogstat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.cauc.bean.MicroblogStat;
import cn.cauc.bean.TzParams;
import cn.cauc.service.microblogstat.IMicroblogStatService;
import cn.cauc.util.TmStringUtils;

/**
 * 微博数据统计web
 * MicroblogStatController
 * 创建人:wangjie
 * 时间：2016年03月16日 10:34:24
 * @version 1.0.0
 */
@Controller
@RequestMapping("/admin/microblogstat")
public class MicroblogStatController {
	
	@Autowired
	private IMicroblogStatService microblogstatService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "microblogstat/list";
	}


	/*内容统计列表查询*/
	@RequestMapping(value="/contentlist")
	public String contentlist(){
		return "microblogstat/contentlist";
	}
	
	/*年龄统计列表查询*/
	@RequestMapping(value="/age")
	public String agelist(){
		return "microblogstat/age";
	}
	
	/*性别统计列表查询*/
	@RequestMapping(value="/male")
	public String sexlist(){
		return "microblogstat/male";
	}
	
	/*地域统计列表查询*/
	@RequestMapping(value="/location")
	public String location(){
		return "microblogstat/location";
	}
	/*朋友圈统计列表查询*/
	@RequestMapping(value="/friend")
	public String friend(){
		return "microblogstat/friend";
	}
	
	/*民航威胁度查询*/
	@RequestMapping(value="/degree")
	public String degree(){
		return "microblogstat/degree";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/groupcotent")
	@ResponseBody
	public List<HashMap<String, Object>> groupCotent(TzParams params){	
		List<HashMap<String, Object>> datas = microblogstatService.groupContent(params); 
		return datas;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/groupcontents")
	public List<HashMap<String, Object>> groupContents(TzParams params){
		List<HashMap<String, Object>> datas = microblogstatService.groupContents(params);
		return datas;
	}
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/groupsex")
	public List<HashMap<String, Object>> groupSex(TzParams params){
		List<HashMap<String, Object>> datas = microblogstatService.groupSex(params);
		return datas;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/groupage")
	public List<HashMap<String, Object>> groupAge(TzParams params){
		List<HashMap<String, Object>> datas = microblogstatService.groupAge(params);
		return datas;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/grouplocation")
	public List<HashMap<String, Object>> groupLocation(TzParams params){
		List<HashMap<String, Object>> datas = microblogstatService.groupLocation(params);
		return datas;
	}	

	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/degreescore")
	public String degreescore(TzParams params){
		System.out.println("进来了吗？");
		if(TmStringUtils.isEmpty(params.getUserId()) && TmStringUtils.isEmpty(params.getUserAlias())){
			return "0";
		}else {
			String score = microblogstatService.findDegreeScore(params);
			if (TmStringUtils.isEmpty(score)){
				return "null";
			}
			return score;						
		}		
	}
	
	@ResponseBody
	@RequestMapping(value="/friendlist",method=RequestMethod.POST)
	public List<List<HashMap<String, Object>>> friendlist(String userId){
		List<List<HashMap<String, Object>>> datas = new ArrayList<>(); 
		List<HashMap<String,Object>> nodes = microblogstatService.findNodes(userId);
		List<HashMap<String,Object>> links = microblogstatService.findNodesLinks(userId);				
		datas.add(nodes);
		datas.add(links);				
		return datas;		
	}	
	
	
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<MicroblogStat> microblogstats = microblogstatService.findMicroblogStats(params);
		int count = microblogstatService.count(params);
		modelAndView.setViewName("microblogstat/template");
		modelAndView.addObject("datas",microblogstats);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/update")
	@ResponseBody
	public String update(MicroblogStat microblogstat){
		try {
			microblogstatService.update(microblogstat);
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
			microblogstatService.delete(params);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/save")
	@ResponseBody
	public String save(MicroblogStat microblogstat){
		try {	
			microblogstat.setPassword(TmStringUtils.md5Base64(microblogstat.getPassword()));
			microblogstat.setUpdateTime(new Date());
			microblogstat.setIsDelete(0);
			microblogstat.setForbiden(0);
			microblogstatService.save(microblogstat);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}
