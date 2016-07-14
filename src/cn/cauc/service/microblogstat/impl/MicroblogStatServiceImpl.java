/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.service.microblogstat
 * MicroblogStatServiceImpl.java
 * 创建人:wangjie
 * 时间：2016年03月16日 10:34:24
 * 中国民航大学-版权所有
 */
package cn.cauc.service.microblogstat.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cauc.bean.MicroblogStat;
import cn.cauc.bean.TzParams;
import cn.cauc.dao.microblogstat.IMicroblogStatMapper;
import cn.cauc.service.microblogstat.IMicroblogStatService;
import cn.cauc.util.TmStringUtils;

/**
 * 微博数据统计serviceImpl
 * IMicroblogStatService
 * 创建人:wangjie 
 * 时间：2016年03月16日 10:34:24
 * @version 1.0.0
 * 
 */
@Service
public class MicroblogStatServiceImpl implements IMicroblogStatService{

	@Autowired
	private IMicroblogStatMapper microblogstatMapper;
	
	@Override
	public List<MicroblogStat> findMicroblogStats(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return microblogstatMapper.findMicroblogStats(params);
	}
	
	@Override
	public int count(TzParams params){
		return microblogstatMapper.count(params);
	}

	@Override
	public MicroblogStat get(Integer id) {
		return microblogstatMapper.get(id);
	}

	@Override
	public int save(MicroblogStat microblogstat) {
		return microblogstatMapper.save(microblogstat);
	}

	@Override
	public int update(MicroblogStat microblogstat) {
		return microblogstatMapper.update(microblogstat);
	}

	@Override
	public int delete(TzParams params) {
		return microblogstatMapper.delete(params);
	}
	@Override
	public List<HashMap<String, Object>> groupContent(TzParams params) {
		return microblogstatMapper.groupContent(params);
	}
	@Override
	public List<HashMap<String, Object>> groupContents(TzParams params) {
		return microblogstatMapper.groupContents(params);
	}
	@Override
	public List<HashMap<String, Object>> groupSex(TzParams params) {
		return microblogstatMapper.groupSex(params);
	}

	@Override
	public List<HashMap<String, Object>> groupAge(TzParams params) {
		return microblogstatMapper.groupAge(params);
	}

	@Override
	public List<HashMap<String, Object>> groupLocation(TzParams params) {
		return microblogstatMapper.groupLocation(params);
	}
	
	@Override
	public String findDegreeScore(TzParams params) {		
		return microblogstatMapper.findDegreeScore(params);
	}
	@Override
	public List<HashMap<String,Object>> findNodes(String userId) {
		List<HashMap<String,Object>> datas = new ArrayList<>();
		List<HashMap<String,Object>> nodes = microblogstatMapper.findNodes(userId);
		HashMap<String, Object> data = null;
		int index = 0;
		String aid = "";
		String num = "";
		//添加主节点
		data = new HashMap<String, Object>();
		num = microblogstatMapper.countNodeValue(userId);
		data.put("category", index);
		data.put("value", Integer.parseInt(num));
		if(TmStringUtils.isEmpty((String)nodes.get(0).get("userAlias"))){
			data.put("name", userId);
			data.put("label", userId);
		}else{
			data.put("name", nodes.get(0).get("userAlias"));
			data.put("label", nodes.get(0).get("userAlias"));
		}
		datas.add(data);
		//循环添加@节点
		for(HashMap<String,Object> node:nodes){						
			data = new HashMap<String, Object>();
			aid = (String)node.get("atuserId");
			if(TmStringUtils.isNotEmpty(aid) && !aid.equals(userId)){
				index = 1;			
				num = microblogstatMapper.countNodeValue(aid);
				data.put("category", index);
				if(TmStringUtils.isNotEmpty(num)){
					data.put("value", Integer.parseInt(num));
				}else{
					data.put("value", 0);
				}
				if(TmStringUtils.isEmpty((String)node.get("atuser"))){
					data.put("name", aid);
					data.put("label", aid);
				}else{
					data.put("name", node.get("atuser"));
					data.put("label", node.get("atuser"));
				}				
				datas.add(data);
			}
		}
		return datas;
	}

	@Override
	public String countNodeValue(@Param("userId")String userId) {
		return microblogstatMapper.countNodeValue(userId);
	}

	@Override
	public List<HashMap<String, Object>> findLinks() {
		List<HashMap<String, Object>> datas = new ArrayList<>(); 
		HashMap<String, Object> data = null;
		HashMap<String, Object> itemstyle = null;
		HashMap<String, Object> width = null;
		List<HashMap<String,Object>> links = microblogstatMapper.findLinks();		
		String num = "";	
		String uid = "";
		String aid = "";
		for (HashMap<String, Object> link : links) {
			uid = (String)link.get("userId");
			aid = (String)link.get("atuserId");
			if(TmStringUtils.isNotEmpty(uid) && TmStringUtils.isNotEmpty(aid)){
				data = new HashMap<>();
				num = microblogstatMapper.countLinkWeight(uid, aid);
				data.put("source", link.get("userAlias"));
				data.put("target", link.get("atuser"));
				data.put("weight", num);
				data.put("name", "@"+num+"次");
					itemstyle = new HashMap<>();
						width = new HashMap<>();
						width.put("width", num);
					itemstyle.put("normal", width);
				data.put("itemStyle", itemstyle);
				datas.add(data);
			}
			
		}
		return datas;
	}

	@Override
	public String countLinkWeight(String userId, String atuserId) {
		return microblogstatMapper.countLinkWeight(userId, atuserId);
	}
	//第一个版本
/*	@Override
	public List<HashMap<String, Object>> findnodesLinks(String userId) {
		List<HashMap<String, Object>> datas = new ArrayList<>(); 
		List<HashMap<String,Object>> nodes = findNodes(userId);
		List<HashMap<String,Object>> links = findLinks();
		String name = "";
		String source = "";
		String target = "";
		for (HashMap<String, Object> node : nodes) {
			name = (String)node.get("name");
			for (HashMap<String, Object> link : links) {
				source = (String)link.get("source");
				target = (String)link.get("target");
				if(name.equals(source) || name.equals(target)){
					datas.add(link);
				}
			}
		}
		return datas;
	}
}*/
	//第二个版本	
/*	public List<HashMap<String, Object>> findnodesLinks(String userId) {
		List<HashMap<String, Object>> datas = new ArrayList<>(); 
		List<HashMap<String,Object>> nodes = findNodes("3655612552");
		List<HashMap<String,Object>> links = findLinks();
		String name = "";
		String source = "";
		String target = "";
		List<String> names = new ArrayList<>();
		for (HashMap<String, Object> node : nodes) {
			name = (String)node.get("name");						
			names.add(name);
		}
		for (HashMap<String, Object> link : links) {
			source = (String)link.get("source");
			target = (String)link.get("target");
			for (int i = 0; i < names.size(); i++) {
				if(target.equals(names.get(i))){
					for (int j = 0; j < names.size(); j++) {
						if(source.equals(names.get(j))){
							datas.add(link);
						}
					    
					}
				}
			}			
		}		
		return datas;
	}
*/
	//第三个版本
	@Override
	public List<HashMap<String, Object>> findNodesLinks(String userId) {
		List<HashMap<String, Object>> datas = new ArrayList<>(); 
		List<HashMap<String,Object>> nodes = microblogstatMapper.findNodes(userId);
		HashMap<String, Object> data = null;
		HashMap<String, Object> itemstyle = null;
		HashMap<String, Object> width = null;
		//添加@关系
		for (HashMap<String, Object> node : nodes) {
			data = new HashMap<>();
			String uid = (String)node.get("userId");
			String aid = (String)node.get("atuserId");
			if(!uid.equals(aid)){
				String unum = microblogstatMapper.countLinkWeight(uid, aid);
				String anum = microblogstatMapper.countLinkWeight(aid, uid);
				if(TmStringUtils.isNotEmpty(anum)){
					int num = Integer.parseInt(unum) + Integer.parseInt(anum);
					data.put("weight", num);
					data.put("name", "@"+num+"次");
						itemstyle = new HashMap<>();
						width = new HashMap<>();
						width.put("width", num); 
						itemstyle.put("normal", width);
					data.put("itemStyle", itemstyle);
				}else{
					data.put("weight", unum);
					data.put("name", "@"+unum+"次");
						itemstyle = new HashMap<>();
						width = new HashMap<>();
						width.put("width", unum); 
						itemstyle.put("normal", width);
					data.put("itemStyle", itemstyle);
				}
				if(TmStringUtils.isNotEmpty((String)node.get("userAlias"))){
					data.put("source", node.get("userAlias"));
				}else{
					data.put("source", uid);
				}
				if(TmStringUtils.isNotEmpty((String)node.get("atuser"))){
					data.put("target", node.get("atuser"));
				}else{
					data.put("target", aid);
				}
				datas.add(data);
			}			
		}
		return datas;
	}
	
	
	
}
