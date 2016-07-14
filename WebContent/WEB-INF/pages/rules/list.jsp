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

		<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>	
		<style type="text/css">
			.row-fluid [class*="span"]{margin-left:0%}
			.rf-search{position:relative;}
			#search{top:76px;right:16px;}
			

		</style>		
	</head>
	<body>
		<%@include file="/WEB-INF/pages/common/header.jsp"%>
		<%@include file="/WEB-INF/pages/common/left.jsp"%>
		
		<div id="content">
			<div id="content-header">
				<div id="breadcrumb">
					<a href="${adminPath}/index" title="返回首页" class="tip-bottom"><i class="icon-home"></i>首页</a><a href="#" class="current">数据采集/预警规则</a>
				</div>				
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
					<!-- rules start -->									
					<div class="span12 rf-search">						
						<div class="widget-box">						
							
							
							  <!-- tab start -->
					          <div class="widget-title">
					            <ul class="nav nav-tabs">
					              <li class="active"><a data-toggle="tab" href="#tab1">采集规则</a></li>
					              <li><a data-toggle="tab" href="#tab2">预警规则</a></li>
					              <li><a data-toggle="tab" href="#tab3">舆情算法规则</a></li>
					            </ul>
					          </div>
					          <div class="widget-content tab-content">
					            <div id="tab1" class="tab-pane active">
					              <p>在这里制定爬虫规则</p>
					              <img src="${basePath}/resources/img/demo/demo-image1.jpg" alt="demo-image"/></div>
					            <div id="tab2" class="tab-pane"> 
					              <p>在这里制定预警规则</p>
					              <img src="${basePath}/resources/img/demo/demo-image2.jpg" alt="demo-image"/>		             
					            </div>
					            <div id="tab3" class="tab-pane">
					              <p>在这里制定情感分析算法规则</p>
					              <img src="${basePath}/resources/img/gallery/imgbox3.jpg" alt="demo-image"/></div>
					          </div>								
							  <!-- tab end -->
							  							
						</div>						
					</div>
					<!-- rules end -->
				</div>
			</div>
		</div>
		<%@include file="/WEB-INF/pages/common/footer.jsp"%>


<script src="${basePath}/resources/js/ui/jquery.ui.custom.js"></script> 
<script src="${basePath}/resources/js/ui/bootstrap.min.js"></script> 
<script src="${basePath}/resources/js/ui/bootstrap-colorpicker.js"></script> 
<script src="${basePath}/resources/js/ui/bootstrap-datepicker.js"></script> 
<script src="${basePath}/resources/js/ui/masked.js"></script> 
<script src="${basePath}/resources/js/ui/jquery.uniform.js"></script> 
<script src="${basePath}/resources/js/ui/select2.min.js"></script> 
<script src="${basePath}/resources/js/ui/matrix.js"></script> 
<script src="${basePath}/resources/js/ui/matrix.form_common.js"></script> 
<script src="${basePath}/resources/js/ui/jquery.peity.min.js"></script> 

	</body>
</html>
