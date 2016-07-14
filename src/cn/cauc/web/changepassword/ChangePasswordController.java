/**
 * 民航安全信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web.changepassword
 * ChangePasswordController.java
 * 创建人:wangjie
 * 时间：2016年02月26日 16:16:24
 * 中国民航大学-版权所有
 */
package cn.cauc.web.changepassword;

import static cn.cauc.util.TzConstant.SESSION_USER;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cauc.bean.TzParams;
import cn.cauc.bean.User;
import cn.cauc.service.user.IUserService;
import cn.cauc.util.TmStringUtils;

/**
 * 密码修改web
 * ChangePasswordController
 * 创建人:wangjie
 * 时间：2016年02月26日 16:16:24
 * @version 1.0.0
 */
@Controller
@RequestMapping("/admin/changepassword")
public class ChangePasswordController {
	
	@Autowired 
	private IUserService userService;
	
		
	@RequestMapping("/list")
	public String list(TzParams params){		
		return "changepassword/list";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/changepw")
	@ResponseBody
	public String changepw(HttpServletRequest request,TzParams params) throws JSONException{
		//System.out.println("==============1================"+JSONUtil.serialize(params));
		if (params!=null) {	
			//System.out.println("==================2=================");
			if(TmStringUtils.isNotEmpty(params.getAccount()) && TmStringUtils.isNotEmpty(params.getPassword())){
				//System.out.println("==================3=================");
				params.setPassword(TmStringUtils.md5Base64(params.getPassword()));
				params.setPasswordNew(TmStringUtils.md5Base64(params.getPasswordNew()));
				//System.out.println("==============9================"+JSONUtil.serialize(params));
				//获取session中的用户
				User user = (User)request.getSession().getAttribute(SESSION_USER);
				//System.out.println("==============10================"+JSONUtil.serialize(user));
				if(TmStringUtils.isNotEmpty(user.getEmail()) && !user.getEmail().equals(params.getAccount())){
					//System.out.println("==================4=================");
					return "account_error";//账号错误
					
				}else if(TmStringUtils.isNotEmpty(user.getPassword()) && !user.getPassword().equals(params.getPassword())){
					//System.out.println("==================5=================");
					return "password_error";//密码错误
					 
				}else {
					//System.out.println("==================6=================");
					user.setPassword(params.getPasswordNew());
					user.setUpdateTime(new Date());					
					//System.out.println("==============10================"+JSONUtil.serialize(user));
					userService.updatePW(user);
					
					return "sussess";//修改成功
				}					
			}
		}else {
			//System.out.println("==================7=================");
			return "null";//无参数
			
		}
		//System.out.println("==================8=================");
		return "fail";//修改失败
		
	}
	
}