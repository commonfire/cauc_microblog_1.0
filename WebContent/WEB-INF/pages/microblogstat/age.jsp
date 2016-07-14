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
					<a href="${adminPath}/index" title="返回首页" class="tip-bottom"><i class="icon-home"></i>首页</a><a href="javascript:void(0);">微博统计分析</a><a href="#" class="current">用户年龄统计</a>
				</div>				
			</div>
			<div class="container-fluid">
				<div class="row-fluid">

					<!-- result start -->									
					<div class="span12 rf-search">
						
						<div class="widget-box">
							<div class="widget-title">
								<span class="icon"><i class="icon-th"></i></span>
								<h5>用户年龄统计</h5>
							</div>
							
							<div class="widget-content">
							   
<!-- 								<div class="control-group">									
									<div class="controls">
										<input type="text"  id="date" onFocus="WdatePicker({onpicking:changeDate})" class="Wdate"/>	
									</div>
								</div> -->
									
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
				loadData();
			});
			
		/* 		// 点击日期的回调函数
			function changeDate(dp){
				var date = dp.cal.getNewDateStr();
				loadData(date);
			}
		*/
			//数据加载，初始化统计报表
			function loadData(){
				$.ajax({
					type:"post",
					url:adminPath+"/microblogstat/groupage",
					success:function(data){
						//alert(JSON.stringify(data));
						//alert(parseData(data));
						var json = {
							title:"微博用户年龄统计",	
							datas:parseData(data)
						};
						initChart("main",json);//初始化统计报表
					}
				});
			};
			//数据预处理
			function parseData(jsonArr){
				for(var key in jsonArr){
					if(jsonArr[key].name=="10后"){
						d10 = jsonArr[key].num;
					}else if(jsonArr[key].name=="00后"){
						d00 = jsonArr[key].num;
					}else if(jsonArr[key].name=="90后"){
						d90 = jsonArr[key].num;
					}else if(jsonArr[key].name=="80后"){
						d80 = jsonArr[key].num;
					}else if(jsonArr[key].name=="70后"){
						d70 = jsonArr[key].num;
					}else if(jsonArr[key].name=="60后"){
						d60 = jsonArr[key].num;
					}
				}
				var arr = [];
				arr.push(d10);
				arr.push(d00);
				arr.push(d90);
				arr.push(d80);
				arr.push(d70);
				arr.push(d60);
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
		            var option = {
		            	    title: {
		            	        x: 'center',
		            	        text: json.title,
		            	        subtext: '新浪微博用户'
		            	    },
		            	    tooltip: {
		            	        trigger: 'item'
		            	    },
		            	    toolbox: {
		            	        show: true,
		            	        feature: {
		            	            dataView: {show: true, readOnly: false},
		            	            restore: {show: true},
		            	            saveAsImage: {show: true}
		            	        }
		            	    },
		            	    calculable: true,
		            	    grid: {
		            	        borderWidth: 0,
		            	        y: 80,
		            	        y2: 60
		            	    },
		            	    xAxis: [
		            	        {
		            	            type: 'category',
		            	            show: true,
		            	            data: ['10后','00后','90后','80后','70后','60后']
		            	        }
		            	    ],
		            	    yAxis: [
		            	        {
		            	            type: 'value',
		            	            show: true
		            	        }
		            	    ],
		            	    series: [
		            	        {
		            	            name: json.title,
		            	            type: 'bar',               	           
		            	            data: json.datas,                	            
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
					//var ecConfig = require('echarts/config');
		            //执行config的回调函数
					//myChart.on(ecConfig.EVENT.CLICK, eConsole);
		        }
		    );
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
