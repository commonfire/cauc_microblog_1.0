/**
 * 民航安保信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.microblogcontent
 * MicroblogContentController.java
 * 创建人:wangjie
 * 时间：2016年03月09日 21:28:17
 * 中国民航大学-版权所有
 */
package cn.cauc.service.microblogcontent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cauc.bean.MicroblogContent;
import cn.cauc.bean.TzParams;
import cn.cauc.dao.microblogcontent.IMicroblogContentMapper;
import cn.cauc.service.microblogcontent.IMicroblogContentService;
import cn.cauc.util.TmStringUtils;

/**
 * 微博内容serviceImpl
 * IMicroblogContentService
 * 创建人:wangjie 
 * 时间：2016年03月09日 21:28:17
 * @version 1.0.0
 * 
 */
@Service
public class MicroblogContentServiceImpl implements IMicroblogContentService{

	@Autowired
	private IMicroblogContentMapper microblogcontentMapper;
	
	@Override
	public List<MicroblogContent> findMicroblogContents(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("publish_time desc");
		return microblogcontentMapper.findMicroblogContents(params);
	}
	
	@Override
	public int count(TzParams params){
		return microblogcontentMapper.count(params);
	}

	@Override
	public MicroblogContent get(Integer id) {
		return microblogcontentMapper.get(id);
	}

	@Override
	public int save(MicroblogContent microblogcontent) {
		return microblogcontentMapper.save(microblogcontent);
	}

	@Override
	public int update(MicroblogContent microblogcontent) {
		return microblogcontentMapper.update(microblogcontent);
	}

	@Override
	public int delete(TzParams params) {
		return microblogcontentMapper.delete(params);
	}
}
