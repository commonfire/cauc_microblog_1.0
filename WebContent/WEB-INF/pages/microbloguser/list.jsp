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
			.row-fluid [class*="span"]{margin-left:0%;}
		</style>		
	</head>
	<body>
		<%@include file="/WEB-INF/pages/common/header.jsp"%>
		<%@include file="/WEB-INF/pages/common/left.jsp"%>
		
		<div id="content">
			<div id="content-header">
				<div id="breadcrumb">
					<a href="${basePath}/index" title="返回首页" class="tip-bottom"><i class="icon-home"></i>首页</a><a href="#" class="current">微博用户检索</a>
				</div>				
			</div>
			<div class="container-fluid">
				<div class="row-fluid">

					<!-- selectlist start -->
					<div class="span12">
					 <div class="widget-box collapsible">
				        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
				          <h5>聚焦查询</h5>
				        </div>
				        <div class="widget-content nopadding">
				          <!-- form start -->
				          <div class="form-horizontal">
				            <div class="control-group span4">
				              <label class="control-label">微博用户账号：</label>
				              <div class="controls">
				                <input type="text" class="span11" id="cc-userid" placeholder="请输入微博账号..." />
				              </div>
				            </div>
				            <div class="control-group span4">
				              <label class="control-label">性别：</label>
				              <div class="controls">
				                <select id="cc-sex">
				                  <option value=" ">--请选择--</option>
				                  <option value="男">男</option>
				                  <option value="女">女</option>
				                </select>
				              </div>
				            </div> 
				            <div class="control-group span4">
				              <label class="control-label">昵称：</label>
				              <div class="controls">
				                <input type="text" class="span11" id="cc-useralias" placeholder="请输入昵称..." />
				              </div>
				            </div>				            
				            <div class="control-group span4">
				              <label class="control-label">个人博客：</label>
				              <div class="controls">
				                <input type="text" class="span11" id="cc-blog" placeholder="请输入博客地址..." />
				              </div>
				            </div>	
				            <div class="control-group span4">
				              <label class="control-label">所在地：</label>
					              <div class="controls">
					                <select id="cc-sf">
					                  <option value=" ">--请选择省份--</option>
					                  <c:forEach var="province" items="${provinces}">
					                  	<option value="${province.province}">${province.province}</option>
					                  </c:forEach>
					                </select>
					              </div>
				            </div>			            			            
				            <div class="control-group span4">
				              <label class="control-label">域名：</label>
				              <div class="controls">
				                <input type="text" class="span11" id="cc-domain" placeholder="请输入域名地址..." />
				              </div>
				            </div>
				            <div class="control-group span4">
				              <label class="control-label">简介：</label>
				              <div class="controls">
				                <input type="text" class="span11" id="cc-brief" placeholder="请输入个人简介..." />
				              </div>
				            </div>
				            <div class="control-group span6">
				              <label class="control-label">注册时间：</label>
				              <div class="controls">
				                <input type="text" data-date-format="yyyy-mm-dd" class="datepicker span4" id="cc-startdate">&nbsp;至&nbsp;<input type="text" data-date="2013-02-01" data-date-format="yyyy-mm-dd" class="datepicker span4" id="cc-enddate">
				              </div>				              
				            </div>				            
				            <div class="clearfix"></div>
				            <div class="form-actions">
				              <button type="submit" class="btn btn-success" onclick="tzAdmin.search(this);">检索</button>
				              <button type="reset" class="btn btn-primary" onclick="tzAdmin.reset(this);">重置</button>
				            </div>				            
				          </div>
				          <!-- form end -->
				        </div>
				      </div>
					</div>
					<!-- selectlist end -->	
					<!-- result start -->									
					<div class="span12">

						<div class="widget-box">
							<div class="widget-title">
								<span class="icon"><i class="icon-th"></i></span>
								<h5>检索结果</h5>
							</div>
							
							<div class="widget-content">
								<!-- box_label start--> 	
				                <div class="span12 btn-icon-pg">
				                  <ul>
				                    <li><a href="javascript:void(0);" mark="0" onclick="tzAdmin.search(this);"><i class="icon-refresh"></i> 刷新</a></li>
				                    <li><a href="javascript:void(0);" mark="1" onclick="tzAdmin.search(this);"><i class="icon-adjust"></i> 今天</a></li>
				                    <li><a href="javascript:void(0);" mark="2" onclick="tzAdmin.search(this);"><i class="icon-asterisk"></i> 昨天</a></li>
				                    <li><a href="javascript:void(0);" mark="3" onclick="tzAdmin.search(this);"><i class="icon-ban-circle"></i> 近五天</a></li>
				                    <li><a href="javascript:void(0);" mark="4" onclick="tzAdmin.search(this);"><i class="icon-bar-chart"></i> 本周</a></li>
				                    <li><a href="javascript:void(0);" mark="5" onclick="tzAdmin.search(this);"><i class="icon-barcode"></i> 上周 </a></li>
				                    <li><a href="javascript:void(0);" mark="6" onclick="tzAdmin.search(this);"><i class="icon-beaker"></i> 本月</a></li>
				                    <li><a href="javascript:void(0);" mark="7" onclick="tzAdmin.search(this);"><i class="icon-leaf"></i> 上月</a></li>
				                    <li><a href="javascript:void(0);" mark="8" onclick="tzAdmin.search(this);"><i class="icon-legal"></i> 上季度</a></li>
				                    <li><a href="javascript:void(0);" mark="9" onclick="tzAdmin.search(this);"><i class="icon-plus-sign"></i> 本季度</a></li>
				                  </ul>
				                </div>
								<!-- box_label end-->	
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>序号</th>
							                <th>昵称</th>
							                <th>简介</th>
							                <th>微博用户账号</th>
							                <th>出生日期</th>
							                <th>所在地</th>
							                <th>性别</th>
							                <th>注册时间</th>
							                <th>危险系数</th>								
										</tr>
									</thead>
									<tbody id="tbody" data-model="microbloguser">
										<tr>
											<td id="loading" colspan="50"></td>
										</tr>
									</tbody>								
								</table>
								<div class="cpage"></div>
							</div>
						</div>						
					</div>
					<!-- result end -->
				</div>
			</div>
		</div>	
		<%@include file="/WEB-INF/pages/common/footer.jsp"%>
	<script type="text/javascript">
		$(function(){
			
			//回车键搜索
			$(document).keydown(function(e){
	 			if(e.keyCode==13){
	 				tzAdmin.loadData(0,15,null,function(itemCount){
	 					tzAdmin.initPage(itemCount);
	 				});
	  			};
	 		});
			//访问页面时加载数据一次
			tzAdmin.loadData(0,15,null,function(itemCount){
				tzAdmin.initPage(itemCount);
			});	 
		});	
		function loading2(target,mark){
			$.loading({target:$(target),mark:1}); 
		};
		
		var tzAdmin = {
			timer :null,
			ltimer :null,
			initPage:function(itemCount){
				$(".cpage").tzPage(itemCount, {
					num_edge_entries : 1, //边缘页数
					num_display_entries :4, //主体页数
					num_edge_entries:5,
					current_page:0,
					showGo:true,
					showSelect:true,
					items_per_page : 15, //每页显示X项
					prev_text : "前一页",
					next_text : "后一页",
					callback : function(pageNo,psize){//回调函数
						tzAdmin.loadData(pageNo,psize);
					}
				});
			},
			loadData:function(pageNo,pageSize,obj,callback){
				var mark = 0;
				if(obj!=null){
					mark = $(obj).attr("mark");	
				}					
				var userid = $("#cc-userid").val();
				var useralias = $("#cc-useralias").val();
				var sex = $("#cc-sex").val();
				var blog = $("#cc-blog").val();
				var domain = $("#cc-domain").val();
				var startdate = $("#cc-startdate").val();
				var enddate = $("#cc-enddate").val();
				var sf = $("#cc-sf").val();
				var brief = $("#cc-brief").val();
				//alert(userid+"===="+sf+"======"+useralias+"========"+sex+"========"+blog+"========"+domain+"========"+startdate+"========"+enddate);
				var params = {
						pageNo:pageNo*pageSize,
						pageSize:pageSize,
						userId:userid,
						userAlias:useralias,
						sex:sex,
						brief:brief,
						sf:sf,
						blog:blog,
						domain:domain,
						startDate:startdate,
						endDate:enddate,
						mark:mark
					};
				
				var model = $("#tbody").data("model");
				clearTimeout(this.ltimer);
				this.ltimer = setTimeout(function(){
					$.ajax({
						type:"post",
						beforeSend:function(){loading2($("#tbody"),4);},
						url:adminPath+"/"+model+"/template",
						data:params,
						success:function(data){
							var $data = $(data);
							$("#tbody").html($data);//追加元素到dom中
							$(".tmui-tips").tmTip();
							var itemCount = $data.find("#itemCount").val();
							if(callback)callback(itemCount);
						}
					});
				},300);
			},
		
			search:function(obj){
		//		var keyword = $("#keywords").val();
		//			if(isEmpty(keyword)){
		//				loading("请输入关键字...",3);
		//				$("#keywords").focus();
		//				return;
		//			}
				tzAdmin.loadData(0,15,obj,function(itemCount){
					tzAdmin.initPage(itemCount);
				});
			},
			reset:function(){	
				var userid = $("#cc-userid").val();
				var useralias = $("#cc-useralias").val();
				var sex = $("#cc-sex").val();
				var blog = $("#cc-blog").val();
				var domain = $("#cc-domain").val();
				var startdate = $("#cc-startdate").val();
				var enddate = $("#cc-enddate").val();
				var sf = $("#cc-sf").val();
				var brief = $("#cc-brief").val();
				if(isNotEmpty(userid)) $("#cc-userid").val("");
				if(isNotEmpty(sex)){
					$("#cc-sex > option:first").attr("selected","selected");
					$("#s2id_cc-sex > a > span:first").html("");					
				} 
				if(isNotEmpty(sf)){
					$("#cc-sf > option:first").attr("selected","selected");
					$("#s2id_cc-sf > a > span:first").html("");					
				} 
				if(isNotEmpty(useralias)) $("#cc-useralias").val("");	
				if(isNotEmpty(domain)) $("#cc-domain").val("");
				if(isNotEmpty(blog)) $("#cc-blog").val("");
				if(isNotEmpty(startdate)) $("#cc-startdate").val("");
				if(isNotEmpty(enddate)) $("#cc-enddate").val("");
				if(isNotEmpty(brief)) $("#cc-brief").val("");	
			}
		};
		
	</script>
		
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
