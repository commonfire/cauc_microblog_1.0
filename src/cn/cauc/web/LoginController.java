/**
 * 民航安全信息管理分析预警平台
 * cauc_microblog
 * cn.cauc.web
 * LoginController.java
 * 创建人:wangjie
 * 时间：2016年02月24日 20:31:58
 * 中国民航大学-版权所有
 */
package cn.cauc.web;

import static cn.cauc.util.TzConstant.SESSION_USER;
import static cn.cauc.util.TzConstant.SESSION_USER_ROLE;
import static cn.cauc.util.TzConstant.SESSION_USER_USERNAME;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cauc.bean.TzParams;
import cn.cauc.bean.User;
import cn.cauc.core.BaseController;
import cn.cauc.service.role.IRoleService;
import cn.cauc.service.user.IUserService;
import cn.cauc.util.TmStringUtils;

import com.google.code.kaptcha.Constants;
/**
 * 
 * LoginController
 * 创建人:wangjie 
 * 时间：2016年3月10日-下午2:20:47 
 * @version 1.0.0
 */
@Controller
public class LoginController extends BaseController{
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
		
	@RequestMapping("/login")
	public String login(){
		return "login";
	}

	/**
	 * 登陆方法
	 * cn.cauc.web 
	 * 方法名：logined
	 * 创建人：wangjie
	 * 时间：2015年11月24日-上午1:13:34 
	 * @param params
	 * @return 
	 * 返回类型：String
	 * @exception 
	 * @since  1.0.0
	 */
	@ResponseBody
	@RequestMapping(value="/logined",method=RequestMethod.POST)
	public String logined(TzParams params,HttpServletRequest request){
		System.out.println("进来了吗？？？？？？？？？？");
		if(params!=null){
			if(TmStringUtils.isNotEmpty(params.getAccount()) && TmStringUtils.isNotEmpty(params.getPassword())){
				params.setPassword(TmStringUtils.md5Base64(params.getPassword()));
				//获取用户传递进来的验证码
				String code = request.getParameter("code");
				if(TmStringUtils.isNotEmpty(code)){
					//获取session中的验证码
					String sessionCode = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
					//如果输入的验证码和会话的验证码不一致的,提示用户输入有误
					if(TmStringUtils.isNotEmpty(sessionCode) && !code.equalsIgnoreCase(sessionCode)){
						return "code_error";
					}
				}
				
				User user = userService.getLogin(params);
				if(user!=null){
					if(user.getForbiden()==1){
						return "forbiden";
					}else{
						HashMap<String, Object> roleMap = roleService.findRolesByUserId(user.getId());
						session.setAttribute(SESSION_USER, user);
						session.setAttribute(SESSION_USER_ROLE, roleMap);
						session.setAttribute(SESSION_USER_USERNAME, user.getRealName());
						//日记监控用户行为和获取请求参数
						request.getServletContext().setAttribute("user_log", user);
						request.getServletContext().setAttribute("request_log", request);
						return "success";
					}
				}else{
					return "fail";
				}
			}else{
				return "null";//请输入账号和密码
			}
		}else{
			return "error";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(){
		session.invalidate();
		return "redirect:login";
	}
}