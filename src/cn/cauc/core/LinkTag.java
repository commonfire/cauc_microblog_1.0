/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.core
 * LinkTag.java
 * 创建人:xuchengfei 
 * 时间：2015年12月21日-下午11:53:14 
 * 2015潭州教育公司-版权所有
 */
package cn.cauc.core;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import cn.cauc.util.TmStringUtils;

/**
 * 
 * LinkTag 创建人:xuchengfei 时间：2015年12月21日-下午11:53:14
 * 
 * @version 1.0.0
 * 
 */
public class LinkTag extends BodyTagSupport {

	/*
	 * <tz:link <a href="javascript:void(0);" onclick="" id="" class title ></a>
	 */
	private String href ="javascript:void(0);";
	private String id;
	private String onclick;
	private String className;
	private String title;
	private String text;
	private String html;

	@Override
	public int doStartTag() throws JspException {
		StringBuilder builder = new StringBuilder();
		builder.append("<a href=\""+href+"\"");
		if(TmStringUtils.isNotEmpty(id)){
			builder.append(" id=\""+id+"\"");
		}
		if(TmStringUtils.isNotEmpty(className)){
			builder.append(" class=\""+className+"\"");
		}
		if(TmStringUtils.isNotEmpty(title)){
			builder.append(" title=\""+title+"\"");
		}else {
			builder.append(" title=\""+text+"\"");
		}
		if(TmStringUtils.isNotEmpty(onclick)){
			builder.append(" onclick=\""+onclick+"\"");
		}
		builder.append(" "+html+">");	
		builder.append(text);
		builder.append("</a>");
		try {
			this.pageContext.getOut().print(builder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setText(String text) {
		this.text = text;
	}

}
