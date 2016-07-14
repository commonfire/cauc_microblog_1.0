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
		<link rel="stylesheet" href="${basePath}/resources/font-awesome/css/font-awesome.css"/>

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
					<a href="${adminPath}/index" title="返回首页" class="tip-bottom"><i class="icon-home"></i>首页</a><a href="javascript:void(0);">系统管理</a><a href="#" class="current">角色列表</a>
				</div>				
			</div>
			<div class="container-fluid">
				<div class="row-fluid">

					<!-- result start -->									
					<div class="span12 rf-search">
						<!-- search start -->
						<div id="search">
						  <input type="text" id="keywords" placeholder="请输入名称..."/>
						  <button type="submit" class="tip-top" title="Search" onclick="tzAdmin.search(this);"><i class="icon-search icon-white"></i></button>
						</div>
						<!-- search end -->
												
						<div class="widget-box">
							<div class="widget-title">
								<span class="icon"><i class="icon-th"></i></span>
								<h5>角色列表</h5>
							</div>
							
							<div class="widget-content">
								<!-- box_label start--> 	
				                <div class="span12 btn-icon-pg">
				                  <ul>
				                    <li><i class="icon-adjust"></i> 编辑</li>
				                    <li><i class="icon-asterisk"></i> 删除</li>
				                    <li><i class="icon-ban-circle"></i> 置顶</li>
				                    <li><i class="icon-bar-chart"></i> 静态化</li>
				                    <li><i class="icon-barcode"></i> 上传资料</li>
				                    <li><i class="icon-beaker"></i> 刷新数据</li>
				                  </ul>
				                </div>
								<!-- box_label end-->	
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>主键</th>
											<th>名称</th>	
											<th>用户</th>	
											<th>创建时间</th>	
											<th>删除状态</th>	
											<th>操作</th>
										</tr>
									</thead>
									<tbody id="tbody" data-model="role">
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
	 				tzAdmin.loadData(0,10,function(itemCount){
	 					tzAdmin.initPage(itemCount);
	 				});
	  			}
	 		});
			//访问页面时加载数据一次
			tzAdmin.loadData(0,10,function(itemCount){
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
					items_per_page : 10, //每页显示X项
					prev_text : "前一页",
					next_text : "后一页",
					callback : function(pageNo,psize){//回调函数
						tzAdmin.loadData(pageNo,psize);
					}
				});
			},
			loadData:function(pageNo,pageSize,callback){
				var keyword = $("#keywords").val();
				var model = $("#tbody").data("model");
				var $this = this;

				clearTimeout(this.ltimer);
				this.ltimer = setTimeout(function(){
					$.ajax({
						type:"post",
						beforeSend:function(){loading2($("#tbody"),4);},
						url:adminPath+"/"+model+"/template",
						data:{pageNo:pageNo*pageSize,pageSize:pageSize,keyword:keyword},
						success:function(data){
					
							var $data = $(data);
							$("#tbody").html($data);//追加元素到dom中
							$(".tmui-tips").tmTip();
							var itemCount = $data.find("#itemCount").val();
							if(isNotEmpty(keyword))$this.highligter(keyword);
							if(callback)callback(itemCount);
						}
					});
				},300);
			},
		
			search:function(){
		//		var keyword = $("#keywords").val();
		//			if(isEmpty(keyword)){
		//				loading("请输入关键字...",3);
		//				$("#keywords").focus();
		//				return;
		//			}
				tzAdmin.loadData(0,10,function(itemCount){
					tzAdmin.initPage(itemCount);//分页加载一次吗
				});
			},
			op:function(obj){
				var $this = $(obj);
				var opid = $this.attr("opid");
				var mark = $this.attr("mark");
				var val = $this.attr("val");
				var model = $("#tbody").data("model");
				var params = {};
				params[mark] = val;
				params["id"] = opid;
				//alert(JSON.stringify(params));
				clearTimeout(this.timer);
				this.timer = setTimeout(function(){
					loading("请稍后数据执行中...");
					$.ajax({
						type:"post",
						url:adminPath+"/"+model+"/update",
						data:params,
						success:function(data){
							loading("执行成功...",3);
							if(data=="success"){
								$this.attr({opid:opid,val:val==0?1:0}).removeClass().addClass(val==0?"red":"green").text(val==0?"否":"是");
							}
						}
					});
				},200); 
			},
			remove:function(obj){
				$.tzConfirm({title:"友情提示",content:"您确定删除吗?",callback:function(ok){
					if(ok){
						var $this = $(obj);
						var opid = $this.data("opid");
						var model = $("#tbody").data("model");
						clearTimeout(this.timer);
						var params = {};
						params["id"] = opid;
						this.timer = setTimeout(function(){
							loading("请稍后数据执行中...");
							$.ajax({
								type:"post",
								url:adminPath+"/"+model+"/delete",
								data:params,
								success:function(data){
									loading("执行成功...",3);
									$this.parents("tr").remove();
									var len = $("#tbody").find("tr").length;
									if(len==0){
										//window.location.href =window.location.href;
										tzAdmin.loadData(0,10,function(itemCount){
											tzAdmin.initPage(itemCount);//分页加载一次吗
										});
									}
								}
							});
						},200); 
					}
				}});
			}
		};
		
		var tzRole = {
				user:function(obj){
					var $obj = $(obj);
					var opid = $obj.data("opid");
					$.tzIframe({width:320,height:400,title:"用户分配角色",drag:false,content:adminPath+"/role/user/"+opid,callback:function(iframe,$dialog,opts){
						if(iframe){
							iframe.tzUserRole.save(opid);
						}
					}});
				},
				permission:function(obj){
					var $obj = $(obj);
					var opid = $obj.data("opid");
					$.tzIframe({width:460,height:420,title:"权限分配",drag:false,content:adminPath+"/role/permission/"+opid,callback:function(iframe,$dialog,opts){
						if(iframe){
							iframe.saveRolePermission(opid,$dialog,opts);
						}
					},loadSuccess:function(iframe){
						iframe.initPermissionTree(function(){
							//选中已授权的权限
							var arr = [2,3,1];
							for(var i=0;i<arr.length;i++){
								$(iframe.document).find("body").find(".tm-tree-checkbox[opid="+arr[i]+"]").addClass("tm-tree-checkbox-checked");
							}
						});
					}});
				},
				del:function(){
					
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
<script src="${basePath}/resources/js/ui/jquery.peity.min.js"></script> 

	</body>
</html>
