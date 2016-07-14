/**
 * 民航安全信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.content
 * ContentController.java
 * 创建人:wangjie
 * 时间：2016年02月24日 20:31:58
 * 中国民航大学-版权所有
 */
package cn.cauc.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cauc.bean.Content;
import cn.cauc.bean.TzParams;
import cn.cauc.dao.content.IContentMapper;
import cn.cauc.service.content.IContentService;
import cn.cauc.util.TmStringUtils;

/**
 * 内容管理serviceImpl
 * IContentService
 * 创建人:wangjie 
 * 时间：2016年02月24日 20:31:58
 * @version 1.0.0
 * 
 */
@Service
public class ContentServiceImpl implements IContentService{

	@Autowired
	private IContentMapper contentMapper;
	
	@Override
	public List<Content> findContents(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return contentMapper.findContents(params);
	}
	
	@Override
	public int count(TzParams params){
		return contentMapper.count(params);
	}

	@Override
	public Content get(Integer id) {
		return contentMapper.get(id);
	}

	@Override
	public int save(Content content) {
		return contentMapper.save(content);
	}

	@Override
	public int update(Content content) {
		return contentMapper.update(content);
	}

	@Override
	public int delete(TzParams params) {
		return contentMapper.delete(params);
	}
}
