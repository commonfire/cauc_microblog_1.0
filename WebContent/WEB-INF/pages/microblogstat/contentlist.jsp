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
		<script src="${basePath}/resources/js/echart/echarts.js"></script>
		<script type="text/javascript" src="${basePath}/resources/js/date/WdatePicker.js"></script>
		<style type="text/css">
			.row-fluid [class*="span"]{margin-left:0%}
			.rf-search{position:relative;}
			#search{top:100px;right:16px;}			
		</style>		
	</head>
	<body>
		<%@include file="/WEB-INF/pages/common/header.jsp"%>
		<%@include file="/WEB-INF/pages/common/left.jsp"%>
		
		<div id="content">
			<div id="content-header">
				<div id="breadcrumb">
					<a href="${adminPath}/index" title="返回首页" class="tip-bottom"><i class="icon-home"></i>首页</a><a href="javascript:void(0);">平台日志统计</a><a href="#" class="current">微博内容统计</a>
				</div>				
			</div>
			<div class="container-fluid">
				<div class="row-fluid">

					<!-- chart start -->									
					<div class="span12">						
						<div class="widget-box">
							<div class="widget-title">
								<span class="icon"><i class="icon-th"></i></span>
								<h5>内容统计</h5>
							</div>
							
							<div class="widget-content">
							   
								<div class="control-group">									
									<div class="controls">
										<input type="text"  id="date" onFocus="WdatePicker({onpicking:changeDate,dateFmt:'yyyy'})" class="Wdate"/>
									</div>
								</div>							
								<div class="chart" id="main" style="height: 400px;"></div>
								
							</div>
						</div>						
					</div>
					<!-- chart end -->

					<!-- result start -->									
					<div class="span12 rf-search">
						<!-- search start -->
						<div id="search">
						  <input type="text" id="s_keyword" placeholder="请输入内容关键词..."/>
						  <button type="submit" class="tip-top" title="Search" onclick="tzAdmin.search(this);"><i class="icon-search icon-white"></i></button>
						</div>
						<!-- search end -->
						
						
						<div class="widget-box">
							<div class="widget-title">
								<span class="icon"><i class="icon-th"></i></span>
								<h5>检索结果</h5>
							</div>
							
							<div class="control-group span3">									
								<select id="sort">
									<option value="asc">升序</option>
									<option value="desc" selected="selected">降序</option>
								</select>
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
											<th>主键</th>
											<th>用户昵称</th>	
											<th>微博账号</th>	
											<th class="span8">微博内容</th>
											<th>转发用户</th>		
											<th>发布时间</th>	
											<th>算法得分</th>												
										</tr>
									</thead>
									<tbody id="tbody" data-model="microblogcontent">
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
		//loadData(new Date().getFullYear());
		loadData(2015);
	});
	
	// 点击日期的回调函数
	function changeDate(dp){
		var date = dp.cal.getNewDateStr();
		loadData(date);
	}
	
	//数据加载，初始化统计报表
	function loadData(year){
		$.ajax({
			type:"post",
			url:adminPath+"/microblogstat/groupcotent",
			data:{year:year},
			success:function(data){
				var json = {
					title:year+"年度发布微博数量",	
					datas:parseData(data)
				};
				initChart("main",json);//初始化统计报表
			}
		});
	};

	//数据月份补零
	function parseData(jsonArr){
		var jsonObj = {};
		for(var key in jsonArr){
			var num = jsonArr[key].num;
			var m = jsonArr[key].m;
			jsonObj["s"+parseInt(m)]= num;
		};
		var arr = [];
		for(var i=1;i<=12;i++){
			arr.push(jsonObj["s"+i]||0);
		}
		return arr;
	};


	//统计报表的初始化
	function initChart(targetId,json){
		require.config({
            paths: {
                echarts: basePath+'/resources/js/echart'
            }
        });
        require(
            [
                'echarts',
                'echarts/chart/bar',
				'echarts/chart/pie'
            ],
           function (ec) {
                var myChart = ec.init(document.getElementById(targetId));
                var option  = {
					    title : {
					    	x: "center",
					        text: json.title,
					        subtext: "月份/微博总数"
					    },
					    tooltip : {
					        trigger: 'axis'
					    },
					   
					    toolbox: {
					        show : true,
					        feature : {
					            mark : {show: true},
					            dataView : {show: true, readOnly: false},
					            magicType : {show: true, type: ['line', 'bar']},
					            restore : {show: true},
					            saveAsImage : {show: true}
					        }
					    },
					    
					    calculable : true,
					    xAxis : [
					        {
					            type : 'category',
					            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
					        }
					    ],
					    yAxis : [
					        {
					            type : 'value'
					        }
					    ],
					    series : [
					        {
					            name:'发布微博数',
					            type:'bar',
					            data:json.datas,
					            markPoint : {
					                data : [
					                    {type : 'max', name: '最大值'},
					                    {type : 'min', name: '最小值'}
					                ]
					            },
					            markLine : {
					                data : [
					                    {type : 'average', name: '平均值'}
					                ]
					            }
					        }
					    ]
					};
                //添加报表数据给echart
				myChart.setOption(option);
                //初始化echart的config对象
				var ecConfig = require('echarts/config');
                //执行config的回调函数
				myChart.on(ecConfig.EVENT.CLICK, eConsole);
            }
        );
	};
		
	//点击柱形图回调事件
//		var timer = null;
//		function eConsole(d) {
//			//获取用户点击的数据
//			var month = parseInt(d.name);
//			//参数
//	 		var params ={
//				month:month,
//				order:"create_time desc",
//				pageNo:0,
//				pageSize:30
//	 		};
//			loading2($("#tbody"),4);
//			//执行业务
//			clearTimeout(timer);
//	 		timer = setTimeout(function(){
//	 			$.ajax({
//		 			type:"post",
//		 			url:adminPath+"/adminstat/groupcontent",
//		 			data:params,
//		 			success:function(data){
//		 				var len = data.length;
//		 				var html = "";
//		 				for(var i=0;i<len;i++){
//		 					html+="<tr>"+
//		 					"	<td>"+data[i].id+"</td>"+
//		 					"	<td>"+data[i].title+"</td>"+
//		 					"	<td>"+data[i].time+"</td>"+
//		 					"	<td>操作</td>"+
//		 					"</tr>";
//		 				}
//		 				$("#tbody").html(html);
//		 			}
//		 		});
//	 		},200);
//		};
	
	
	var mark = true;
	function eConsole(d) {
		//获取用户点击的数据
		var month = parseInt(d.name);
		var sort = document.getElementById("sort").value||"desc";
		//参数
 		var params ={
				month:month,
				order:"publish_time "+sort,
				pageNo:0,
				pageSize:30
 		};
		loading2($("#tbody"),4);
		if(mark){
			mark = !mark;
			//执行业务
 			$.ajax({
	 			type:"post",
	 			url:adminPath+"/microblogstat/groupcontents",
	 			data:params,
	 			error:function(){mark=true;},
	 			success:function(data){
	 				var len = data.length;
	 				var html = "";
	 				for(var i=0;i<len;i++){
	 					html+="<tr>"+
	 					"	<td>"+data[i].id+"</td>"+
	 					"	<td>"+data[i].userAlias+"</td>"+
	 					"	<td>"+data[i].userId+"</td>"+
	 					"	<td>"+data[i].content+"</td>"+
	 					"	<td>"+data[i].repostUser+"</td>"+
	 					"	<td>"+data[i].publishTime+"</td>"+
	 					"	<td>"+"score"+"</td>"+
	 					"</tr>";
	 				}
	 				$("#tbody").html(html);
	 				mark = true;
	 			}
	 		});
		}
	};
	
		$(function(){			
			//回车键搜索
			$(document).keydown(function(e){
	 			if(e.keyCode==13){
	 				tzAdmin.loadData(0,15,null,function(itemCount){
	 					tzAdmin.initPage(itemCount);
	 				});
	  			}
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
				var userid = $("#s-userid").val();
				var useralias = $("#s-useralias").val();
				var repostuser = $("#s-repostuser").val();
				var content = $("#s-content").val();
				var startdate = $("#s-startdate").val();
				var enddate = $("#s-enddate").val();
				var keyword = $("#s_keyword").val();
				var params = {
						pageNo:pageNo*pageSize,
						pageSize:pageSize,
						userId:userid,
						userAlias:useralias,
						repostUser:repostuser,
						content:content,
						startDate:startdate,
						endDate:enddate,
						mark:mark
					};
				var model = $("#tbody").data("model");
				var $this = this;
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
							if(isNotEmpty(keyword))$this.highligter(keyword);
							if(callback)callback(itemCount);
						}
					});
				},300);
			},
			highligter:function(key){
				if(isEmpty(key))return;
				$("#tbody").find(".content_keys").each(function(){
					var text = $(this).text();
					//var nt = text.replace(key,"<span class='red'>"+key+"</span>");
					//var nt = text.replace(key,"<span class='red'>"+key+"</span>");
					var regex = new RegExp(key,"ig");
					var nt = text.replace(regex,"<span class='red'>"+key+"</span>");
					$(this).html(nt);
				});
			},
			search:function(obj){
				tzAdmin.loadData(0,15,obj,function(itemCount){
					tzAdmin.initPage(itemCount);//分页加载一次吗
				});
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
