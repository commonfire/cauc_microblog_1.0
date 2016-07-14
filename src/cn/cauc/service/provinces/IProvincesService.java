/**
 * 互联网舆情监控大数据系统
 * bigdata
 * cn.cauc.service.provinces
 * IProvincesService.java
 * 创建人:王杰 
 * 时间：2015年12月08日 14:33:39
 * 中国民航大学-版权所有
 */
package cn.cauc.service.provinces;

import java.util.List;

import cn.cauc.bean.Provinces;

/**
 * 
 * IProvincesService
 * 创建人:王杰 
 * 时间：2015年12月08日 14:33:39
 * @version 1.0.0
 * 
 */
public interface IProvincesService {


	/**
	 * 
	 * cn.cauc.service.provinces 
	 * 方法名：findProvincess
	 * 创建人：王杰 
	 * 手机号码:13920979915
	 * 时间：2015年12月08日 14:33:39
	 * @param params
	 * @return 
	 * 返回类型：List<Provinces>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Provinces> findProvincess();

}
