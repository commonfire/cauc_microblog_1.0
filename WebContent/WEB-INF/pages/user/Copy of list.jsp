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
		<link href="${basePath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet" />
		<link href='http://fonts.useso.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
		
	</head>
	<body>

		<%@include file="/WEB-INF/pages/common/header.jsp"%>
		<%@include file="/WEB-INF/pages/common/left.jsp"%>
		
		<div id="content">
			<div id="content-header">
				<div id="breadcrumb">
					<a href="${basePath}/index" title="返回首页" class="tip-bottom"><i class="icon-home"></i>首页</a><a href="javascript:void(0);">用户管理</a><a href="#" class="current">用户列表</a>
				</div>
				<h1>用户列表</h1>
			</div>
			<div class="container-fluid">
				<hr>
<!-- 				<div class="row-fluid">
					<div class="span6">
					select start
					<div class="widget-box ">
						<div class="widget-title">
							<span class="icon"> <i class="icon-align-justify"></i></span>
							<h5>检索条件</h5>
						</div>
						<div class="widget-content nopadding ">
							<form  class="form-horizontal">
								<div class="control-group">
									<label class="control-label">First Name :</label>
									<div class="controls">
										<input id="realname" type="text" class="span11" placeholder="First name" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">Last Name :</label>
									<div class="controls">
										<input type="text" class="span11" placeholder="Last name" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">Password input</label>
									<div class="controls">
										<input type="password" class="span11" placeholder="Enter Password" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">Company info :</label>
									<div class="controls">
										<input type="text" class="span11" placeholder="Company name" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">Description field:</label>
									<div class="controls">
										<input type="text" class="span11" /> <span class="help-block">Description
											field</span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">Message</label>
									<div class="controls">
										<textarea class="span11"></textarea>
									</div>
								</div>
								<div class="form-actions">
									<button class="btn btn-success">开始检索</button>
								</div>
							</form>
						</div>
					</div>
					select end
						
					</div>
				</div>
				 -->
				<div class="row-fluid">
					<div class="span12">
					
					<!-- result start -->
					<div class="widget-box">
							<div class="widget-title">
								<span class="icon"><i class="icon-th"></i></span>
								<h5>检索结果</h5>
							</div>
							<div class="widget-content nopadding">
								<table class="table table-bordered data-table">
									<thead>
										<tr>
											<th>主键</th>
											<th>姓名</th>
											<th>性别</th>
											<th>身份证号</th>
											<th>邮箱</th>
											<th>电话</th>
											<th>工作单位</th>
											<th>创建时间</th>
											<th>删除状态</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody id="cc-tbody" data-model="user">
										<c:forEach var="user" varStatus="userindex" items="${datas}">
											<tr class="gradeX">
												<td class="taskStatus">${user.id}</td>
												<td class="taskStatus">${user.realName}</td>						
												<td class="taskStatus">${user.male}</td>
												<td class="taskStatus">${user.cardId}</td>
												<td class="taskStatus">${user.email}</td>
												<td class="taskStatus">${user.telephone}</td>
												<td class="taskStatus">${user.company}</td>
												<td class="taskStatus">${user.createTime}</td>
												<td class="taskStatus">${user.isDelete}</td>
												<td class="taskOptions">
													<a href="#" class="tip-top" data-original-title="更新"><i class="icon-ok"></i></a> 
													<a href="#" class="tip-top" data-original-title="删除"><i class="icon-remove"></i></a>
												</td>										 
 											</tr>	
										</c:forEach>
									</tbody>
									
									
								</table>
							</div>
						</div>
						<!-- result end -->
					</div>
				</div>
			</div>
		</div>	
		<%@include file="/WEB-INF/pages/common/footer.jsp"%>

		<script src="${basePath}/resources/js/ui/jquery.ui.custom.js"></script> 
		<script src="${basePath}/resources/js/ui/bootstrap.min.js"></script> 
		<script src="${basePath}/resources/js/ui/jquery.uniform.js"></script> 
		<script src="${basePath}/resources/js/ui/select2.min.js"></script> 
		<script src="${basePath}/resources/js/ui/jquery.dataTables.min.js"></script> 
		<script src="${basePath}/resources/js/ui/matrix.js"></script> 
		<script src="${basePath}/resources/js/ui/matrix.tables.js"></script>	
		
	</body>
</html>
