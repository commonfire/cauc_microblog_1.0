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
		<!-- 引入树的js和css -->
		<link rel="stylesheet" href="${basePath}/resources/sg/tree/tm_tree.css"/>
		<script type="text/javascript" src="${basePath}/resources/sg/tree/tm_tree.js"></script>	
		<style type="text/css">
			#permissiontree{background:#B78080;margin:10px}
		</style>
	</head>
	<body>
		<%@include file="/WEB-INF/pages/common/header.jsp"%>
		<%@include file="/WEB-INF/pages/common/left.jsp"%>
		
		<div id="content">
			<div id="content-header">
				<div id="breadcrumb">
					<a href="${basePath}/index" title="返回首页" class="tip-bottom"><i class="icon-home"></i>首页</a><a href="javascript:void(0);">系统管理</a><a href="#" class="current">权限列表</a>
				</div>				
			</div>
			<div class="container-fluid">
				<div class="row-fluid">

				  <!-- useradd start -->
			      <div class="span12">
			        <div class="widget-box">
			          <div class="widget-title bg_ly" data-toggle="collapse" ><span class="icon"><i class="icon-chevron-down"></i></span>
			            <h5>权限列表</h5>
			          </div>
			          <div class="widget-content nopadding">
			           <form class="form-horizontal">
			           	  	<div id="permissiontree"></div>
			           </form>
			          </div>
			        </div>
			      </div>
			      <!-- useradd end -->
			    </div>
			</div>
		</div>
		<%@include file="/WEB-INF/pages/common/footer.jsp"%>
	<script type="text/javascript">
		$(function(){
			
			
			
			function initPermissionTree(){
				tzAjax.request({
					path:adminPath,
					model:"permission",
					method:"root",
					success:function(data){				
						var root = data.root;
						var children = data.children;
						$("#permissiontree").tmTree({outhtml:"<a href='javascript:void(0);' class='remove'><i class='icon-remove'></i></a>",root:root,children:children,type:"checkbox",onclick:function($obj,data){
							//alert(JSON.stringify(data));
						}});
					}
				});
			};
			initPermissionTree();
		});
		
	</script>
	
<script src="${basePath}/resources/js/ui/jquery.ui.custom.js"></script> 
<script src="${basePath}/resources/js/ui/bootstrap.min.js"></script> 
<script src="${basePath}/resources/js/ui/bootstrap-colorpicker.js"></script> 
<script src="${basePath}/resources/js/ui/bootstrap-datepicker.js"></script> 
<script src="${basePath}/resources/js/ui/masked.js"></script> 
<script src="${basePath}/resources/js/ui/jquery.uniform.js"></script> 
<script src="${basePath}/resources/js/ui/select2.min.js"></script> 
<script src="${basePath}/resources/js/ui/matrix.js"></script> 
<script src="${basePath}/resources/js/ui/jquery.peity.min.js"></script> 


	</body>
</html>
