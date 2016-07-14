<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
    
	<head>
        <title>民航安保信息管理分析预警平台</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        
		<%@include file="/WEB-INF/pages/common/common.jsp" %>	
		<link rel="stylesheet" href="${basePath}/resources/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${basePath}/resources/css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="${basePath}/resources/css/matrix-login.css" />
        <link href="${basePath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet" />

    </head>
    <body>
        <div id="loginbox">            
            <form id="loginform" class="form-vertical">
				 <div class="control-group normal_text"> <h3>民航安保信息管理分析预警平台</h3></div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_lg"><i class="icon-user"></i></span><input type="text" id="account" autocomplete="off" autofocus="autofocus" maxlength="60" placeholder="请输入用户名..." />
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_ly"><i class="icon-lock"></i></span><input type="password" id="password" maxlength="20" autocomplete="off" placeholder="请输入密码..."/>
                        </div>
                    </div>
                </div>
                <div class="control-group" id="kcode" style="display: block;">
                    <div class="controls">
                        <div class="main_input_box" style="position: relative;">
                            <span class="add-on bg_lo"><i class="icon-key"></i></span><input type="text" id="code" maxlength="4" autocomplete="off" placeholder="请输入验证码..." />
                       		<img src="${basePath}/kaptcha/code" onclick="this.src=basePath+'/kaptcha/code?d='+new Date().getTime();" style="position: absolute;top:1px;right:28px;"/>
                        </div>                        
                    </div>
                </div>
                <div class="form-actions">
                    <span class="pull-left"><a href="#" class="flip-link btn btn-info" id="to-recover">丢失密码？</a></span>
                    <span class="pull-right"><a type="submit"  href="javascript:void(0);" onclick="tz_login(this);" class="btn btn-success" /> 登录</a></span>
                </div>
            </form>
            <form id="recoverform" action="#" class="form-vertical">
				<p class="normal_text">请联系管理员：421875263@qq.com</p>
                <div class="form-actions">
                    <span class="pull-left"><a href="#" class="flip-link btn btn-success" id="to-login">&laquo; 返回登陆</a></span>
                    <span class="pull-right"><a href="index.jsp" class="btn btn-info"/>返回首页</a></span>
                </div>
            </form>
        </div>
        <script src="${basePath}/resources/js/ui/matrix.login.js"></script> 
	  <script type="text/javascript">

	 	 $(function(){
	 		$(document).keydown(function(e){
	 			if(e.keyCode==13){
	  				tz_login();
	  			}
	 		});	 		
/* 	 		$("#account").keyup(function(){
				tzMap.put("cauc_account",$(this).val(),1);	 			
	 		});	 		
	 		var username = tzMap.get("cauc_account",1);
	 		if(username)$("#account").val(username);
 */	  	});
	 	//记录登陆错误次数
	 	var loginIndex = 1;
	  	function tz_login(obj){
	  		var account = $("#account").val();
	  		var password = $("#password").val();
	  		var code = $("#code").val();

	  		var markFlag = $("#kcode").is(":hidden");//true  //is(":visible")
	  		if(isEmpty(account)){
	  			loading("请输入账号",4);
	  			$("#account").focus();
	  			return;
	  		}
	  		if(isEmpty(password)){
	  			loading("请输入密码",4);
	  			$("#password").focus();
	  			return;
	  		}
	  		//错误输入的次数为3时候.显示验证码
	  		if(loginIndex==3){
	  			$("#kcode").show();
	  		}
	  		if(!markFlag){
	  			if(isEmpty(code)){
	  				loading("请输入验证码...",3);
	  				$("#code").focus();
	  				return;
	  			}
	  		}	  		
	  		var params = {account:account,password:password,code:code};
	  		$(obj).removeAttr("onclick").text("登陆中....");
	  		tzAjax.request({
	  			url:basePath+"/logined",
	  			error:function(){$(obj).attr("onclick","tz_login(this)").text("登陆中");},
	  			success:function(data){
	  				$(obj).attr("onclick","tz_login(this)").text("登陆中");
	  				if(data=="error" || data=="null"){
	  					loading("请填写账号或者密码...",4);
	  					$("#password").val("");
	  					$("#account").select();
	  					loginIndex++;
	  				}else if(data=="fail"){
	  					//账号或者密码输入错误
	  					$("#password").val("");
	  					$("#account").select();
	  					loading("请输入正确的账号和密码!!!",4);
	  					loginIndex++;
	  				}else if(data=="forbiden"){
	  					$("#password").val("");
	  					$("#account").select();
	  					loading("您的账号已被禁止...",4);
	  					loginIndex++;
	  				}else if (data=="code_error"){
	  					loading("验证码输入有误...",4);
	  					$("#code").val("").focus();
	  				}else{
	  					var refer = document.referrer;
	  					//登陆成功
	  					//window.location.href = isNotEmpty(refer) ? refer: adminPath+"/index";
	  					window.location.href = adminPath+"/index";
	  				}
	  			}
	  		},params);
	  	};
	  </script>
    </body>

</html>
