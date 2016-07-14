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
		<link rel="stylesheet" href="${basePath}/resources/css/uniform.css" />
		<link rel="stylesheet" href="${basePath}/resources/css/select2.css" />
		<link rel="stylesheet" href="${basePath}/resources/css/matrix-style.css" />
		<link rel="stylesheet" href="${basePath}/resources/css/matrix-media.css" />
		<link rel="stylesheet" href="${basePath}/resources/font-awesome/css/font-awesome.css" />
		<link href='http://fonts.useso.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
	
	</head>
	<body>

		<%@include file="/WEB-INF/pages/common/header.jsp"%>
		<%@include file="/WEB-INF/pages/common/left.jsp"%>
	
		<div id="content">
			<div id="content-header">
				<div id="breadcrumb">
					<a href="${basePath}/index" title="返回首页" class="tip-bottom"><i class="icon-home"></i>首页</a><a href="javascript:void(0);">用户管理</a><a href="#" class="current">用户添加</a>
				</div>
			</div>
			<div class="container-fluid">
				<hr>
				<div class="row-fluid">
					<div class="span12">
						<div class="widget-box">
							<div class="widget-title">
								<span class="icon"><i class="icon-info-sign"></i></span>
								<h5>用户添加</h5>
							</div>
							<div class="widget-content nopadding">
								<form class="form-horizontal" method="post" action="#" name="basic_validate" id="basic_validate" novalidate="novalidate">
									<div class="control-group">
										<label class="control-label">姓名：</label>
										<div class="controls">
											<input type="text" name="required" id="username">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">性别：</label>
										<div class="controls">
											<input type="text" name="required" id="male">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">身份证号：</label>
										<div class="controls">
											<input type="text" name="required" id="usernumber">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">邮箱：</label>
										<div class="controls">
											<input type="text" name="email" id="email">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">电话：</label>
										<div class="controls">
											<input type="text" name="required" id="telephone">
										</div>
									</div>									
									<div class="control-group">
										<label class="control-label">工作单位：</label>
										<div class="controls">
											<input type="text" name="required" id="required">
										</div>
									</div>									
									<div class="form-actions">
										<input type="submit" value="保存" class="btn btn-success">
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>		                              
	
		<%@include file="/WEB-INF/pages/common/footer.jsp"%>

		<script src="${basePath}/resources/js/ui/jquery.ui.custom.js"></script> 
		<script src="${basePath}/resources/js/ui/bootstrap.min.js"></script> 
		<script src="${basePath}/resources/js/ui/jquery.uniform.js"></script> 
		<script src="${basePath}/resources/js/ui/select2.min.js"></script> 
		<script src="${basePath}/resources/js/ui/jquery.validate.js"></script> 
		<script src="${basePath}/resources/js/ui/matrix.js"></script> 
		<script src="${basePath}/resources/js/ui/matrix.form_validation.js"></script>

		
	</body>
</html>
