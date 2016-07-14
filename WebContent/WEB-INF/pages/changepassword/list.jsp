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
		<link rel="stylesheet" href="${basePath}/resources/css/colorpicker.css" />
		<link rel="stylesheet" href="${basePath}/resources/css/datepicker.css" />
		<link rel="stylesheet" href="${basePath}/resources/css/uniform.css" />
		<link rel="stylesheet" href="${basePath}/resources/css/select2.css" />
		<link rel="stylesheet" href="${basePath}/resources/css/matrix-style.css" />
		<link rel="stylesheet" href="${basePath}/resources/css/matrix-media.css" />

		<link href="${basePath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet" />

	</head>
	<body>

		<%@include file="/WEB-INF/pages/common/header.jsp"%>
		<%@include file="/WEB-INF/pages/common/left.jsp"%>

		<div id="content">
		  <div id="content-header">
			<div id="breadcrumb"> <a href="${adminPath}/index" title="返回首页" class="tip-bottom"><i class="icon-home"></i> 首页</a><a href="#" class="current">密码修改</a> </div>
		  </div>
		  <div class="container-fluid">
			<div class="row-fluid">
			  <div class="span12">
				<div class="widget-box">
				  <div class="widget-title"> <span class="icon"> <i class="icon-pencil"></i> </span>
					<h5>密码修改</h5>
				  </div>
				  <div class="widget-content nopadding">
					<div class="form-horizontal" id="tbody" data-model="changepassword">
						<div class="control-group">
						  <label class="control-label">用户账号：</label>
						  <div class="controls">
							<input id="account" type="text"/>
						  </div>
						</div>
						<div class="control-group">
						  <label class="control-label">旧密码：</label>
						  <div class="controls">
							<input id="password" type="password"/>
						  </div>
						</div>						
						<div class="control-group">
						  <label class="control-label">新密码：</label>
						  <div class="controls">
							<input id="password-new" type="password"/>
						  </div>
						</div>
						<div class="control-group">
						  <label class="control-label">确认密码：</label>
						  <div class="controls">
							<input id="password-new-sure" type="password"/>
						  </div>
						</div>
					  <div class="form-actions">
						<input class="btn btn-success" type="reset" value="提交" onclick="tzAdmin.submit();"/>
						<input class="btn btn-primary" type="submit" value="重置" onclick="tzAdmin.reset();"/>
					  </div>
					</div>
				  </div>
				</div>
			  </div>
			</div>
		  </div>
		</div>
		<%@include file="/WEB-INF/pages/common/footer.jsp"%>
	<script type="text/javascript">
	$(function(){		
		//回车键搜索
		$(document).keydown(function(e){
 			if(e.keyCode==13){
 				tzAdmin.submit();
  			}
 		});
	});
	function loading2(target,mark){
		$.loading({target:$(target),mark:1}); 
	};
	var tzAdmin = {
		timer :null,
		ltimer :null,
		submit:function(){
			var account = $("#account").val();
			var password = $("#password").val();
			var passwordnew = $("#password-new").val();
			var passwordnewsure = $("#password-new-sure").val();
 			if (isEmpty(account) || isEmpty(password) || isEmpty(passwordnew) || isEmpty(passwordnewsure)) {
				loading("请输入必填项！",4);
				return;
			}
			if (isNotEmpty(passwordnew) && passwordnew != passwordnewsure) {
				loading("两个输入密码不一致！",4);
				return;
			}
			var params = {
					account:account,
					password:password,
					passwordNew:passwordnew
				};
			var model = $("#tbody").data("model");
			clearTimeout(this.ltimer);
			this.ltimer = setTimeout(function(){
				$.ajax({
					type:"post",
					url:adminPath+"/"+model+"/changepw",
					data:params,
					success:function(data){
						if(data == "fail"){
							loading("修改失败！",4);
						}else if(data == "null"){
							loading("请输入必填项！",4);
						}else if(data == "password_error"){
							loading("密码错误！",4);
						}else if(data == "account_error"){
							loading("账号错误！",4);
						}else{
							loading("密码更新成功！",4);
							tzAdmin.reset();
						}
					}
				});
			},300);
		},
		reset:function(){	
			var account = $("#account").val();
			var password = $("#password").val();
			var passwordnew = $("#password-new").val();
			var passwordnewsure = $("#password-new-sure").val();

			if(isNotEmpty(account)) $("#account").val("");
			if(isNotEmpty(password)) $("#password").val("");	
			if(isNotEmpty(passwordnew)) $("#password-new").val("");
			if(isNotEmpty(passwordnewsure)) $("#password-new-sure").val("");
		}
		
	};
	
		
	</script>
<script src="${basePath}/resources/js/ui/jquery.ui.custom.js"></script> 
<script src="${basePath}/resources/js/ui/bootstrap.min.js"></script> 
<script src="${basePath}/resources/js/ui/bootstrap-colorpicker.js"></script> 
<script src="${basePath}/resources/js/ui/bootstrap-datepicker.js"></script> 
<script src="${basePath}/resources/js/ui/masked.js"></script> 
<script src="${basePath}/resources/js/ui/jquery.uniform.js"></script> 
<script src="${basePath}/resources/js/ui/matrix.js"></script> 
<script src="${basePath}/resources/js/ui/jquery.peity.min.js"></script> 

		
	</body>
</html>
