/**
 * 互联网舆情监控大数据系统
 * bigdata
 * com.tz.model
 * Content.java
 * 创建人:wangjie 
 * 时间：2015年6月8日-下午1:13:00 
 * 中国民航大学-版权所有
 */
package cn.cauc.bean;


/**
 * 省份 Provinces 创建人:王杰 时间：2015年12月08日 14:33:39 qq：421875263
 * email：421875263@qq.com
 * 
 * @version 1.0.0
 * 
 */
public class Provinces implements java.io.Serializable {

	private Integer id;// 主键
	private String province;// 省份

	public Provinces() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}
