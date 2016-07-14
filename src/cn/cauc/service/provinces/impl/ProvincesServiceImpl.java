/**
 * 互联网舆情监控大数据系统
 * bigdata
 * cn.cauc.service.provinces
 * IProvincesService.java
 * 创建人:王杰 
 * 时间：2015年12月08日 14:33:39
 * 中国民航大学-版权所有
 */
package cn.cauc.service.provinces.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cauc.bean.Provinces;
import cn.cauc.dao.provinces.IProvincesMapper;
import cn.cauc.service.provinces.IProvincesService;

/**
 * 省份serviceImpl
 * IProvincesService
 * 创建人:王杰 
 * 时间：2015年12月08日 14:33:39
 * @version 1.0.0
 * 
 */
@Service
public class ProvincesServiceImpl implements IProvincesService{

	@Autowired
	private IProvincesMapper provincesMapper;
	
	@Override
	public List<Provinces> findProvincess(){		
		return provincesMapper.findProvincess();
	}

}
