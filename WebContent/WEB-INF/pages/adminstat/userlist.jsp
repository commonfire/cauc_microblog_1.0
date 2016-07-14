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
		<script type="text/javascript" src="${basePath}/resources/js/echart/echarts.js"></script>
		<script type="text/javascript" src="${basePath}/resources/js/date/WdatePicker.js"></script>	
	
	</head>
	<body>
		<%@include file="/WEB-INF/pages/common/header.jsp"%>
		<%@include file="/WEB-INF/pages/common/left.jsp"%>
		
		<div id="content">
			<div id="content-header">
				<div id="breadcrumb">
					<a href="${adminPath}/index" title="返回首页" class="tip-bottom"><i class="icon-home"></i>首页</a><a href="javascript:void(0);">平台日志统计</a><a href="#" class="current">用户注册数统计</a>
				</div>				
			</div>
			<div class="container-fluid">
				<div class="row-fluid">

					<!-- result start -->									
					<div class="span12 rf-search">
						
						<div class="widget-box">
							<div class="widget-title">
								<span class="icon"><i class="icon-th"></i></span>
								<h5>用户注册数统计</h5>
							</div>
							
							<div class="widget-content">
							   
								<div class="control-group">									
									<div class="controls">
										<input type="text"  id="date" onFocus="WdatePicker({onpicking:changeDate})" class="Wdate"/>	
									</div>
								</div>
									
								<div class="chart" id="main" style="height: 400px;"></div>
								
							</div>
						</div>
					</div>						
				</div>
				<!-- result end -->
			</div>
		</div>

	<%@include file="/WEB-INF/pages/common/footer.jsp"%>
	<script type="text/javascript">
			$(function(){
				var d = new Date().format('yyyy-MM-dd');
				loadData(d);
				$("#date").val(d);
			});
			
			function loadData(date){
				tzAjax.request({
					path:adminPath,
					model:"adminstat",
					method:"groupusers",
		//			params:"username=keke&password=123456",
		//				before:function(){
		//					loading("请稍后，数据加载中...");
		//				},
		//				error:function(){
		//					loading("请求出错...",4);
		//				},
		//				logout:function(){
		//					//记录用户退出的时间和记录，写入到数据库中....
		//				},
					success:function(data){
						var json = {
							title:date+"时段内平台注册人数详情",	
							datas:parseData(data),
							timeLines:getTimeLine()
						};
						initChart("main",json);
					}
				},{"date":date});
			};
			
			// 点击日期的回调函数
			function changeDate(dp){
				var date = dp.cal.getNewDateStr();
				loadData(date);
			}
			
			
			function parseData(jsonArr){
				var jsonObj = {};
				for(var key in jsonArr){
					var num = jsonArr[key].num;
					var m = jsonArr[key].h;
					jsonObj["s"+parseInt(m)]= num;
				};
				var arr = [];
				for(var i=0;i<=23;i++){
					arr.push(jsonObj["s"+i]||0);
				}
				return arr;
			}
			
			//时间轴准备
			function getTimeLine(){
				var arr = [];
				for(var i=0;i<=23;i++){
					arr.push((i<10?"0"+i:i)+":00");
				}
				return arr;
			};
		
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
						'echarts/chart/pie',
						'echarts/chart/line'
		            ],
		           function (ec) {
		                var myChart = ec.init(document.getElementById(targetId));
		                var option = {
		           	    title : {
		           	    	x:"center",
		           	        text: json.title,
		           	        subtext: '时间/注册数'
		           	    },
		           	    tooltip : {
		           	        trigger: 'axis'
		           	    },
		//            	    legend: {
		//            	        data:['意向','预购','成交']
		//            	    },
		           	    toolbox: {
		           	        show : true,
		           	        feature : {
		           	            mark : {show: true},
		           	            dataView : {show: true, readOnly: false},
		           	            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
		           	            restore : {show: true},
		           	            saveAsImage : {show: true}
		           	        }
		           	    },
		           	    calculable : true,
		           	    xAxis : [
		           	        {	
		           	        	name:"时间段",
		           	            type : 'category',
		           	            data :json.timeLines
		           	        }
		           	    ],
		           	    yAxis : [
		           	        {
		           	        	name:"注册数",	
		           	            type : 'value'
		           	        }
		           	    ],
		           	    series : [
		           	        {
		           	            name:'注册数',
		           	            type:'line',
		           	            smooth:true,
		           	            itemStyle: {normal: {areaStyle: {type: 'default'}}},
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
					            },
		           	            data:json.datas
		           	        }
		           	    ]
		           	};
		                	                    
						myChart.setOption(option);
						var ecConfig = require('echarts/config');
						myChart.on(ecConfig.EVENT.CLICK, eConsole);
		            }
		        );
		}
			
		
		function eConsole(param) {
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
