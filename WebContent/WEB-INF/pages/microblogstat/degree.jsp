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

		<script type="text/javascript" src="${basePath}/resources/js/echart/echarts.js"></script>
		<script type="text/javascript" src="${basePath}/resources/js/date/WdatePicker.js"></script>		
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
					<a href="${adminPath}/index" title="返回首页" class="tip-bottom"><i class="icon-home"></i>首页</a><a href="javascript:void(0);">微博统计分析</a><a href="#" class="current">民航威胁度</a>
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
				                <input type="text" class="span11" id="s-userid" placeholder="请输入微博用户账号..." />
				              </div>
				            </div>
				            <div class="control-group span4">
				              <label class="control-label">用户昵称：</label>
				              <div class="controls">
				                <input type="text" class="span11" id="s-useralias" placeholder="请输入用户微博昵称..." />
				              </div>
				            </div>				            			            
				            <div class="clearfix"></div>
				            <div class="form-actions">
				              <button type="submit" class="btn btn-success" onclick="tzAdmin.loadData();">检索</button>
				              <button type="reset" class="btn btn-primary" onclick="tzAdmin.reset();">重置</button>
				            </div>				            
				          </div>
				          <!-- form end -->
				        </div>
				      </div>
					</div>
					<!-- selectlist end -->	
					<!-- result start -->									
					<div class="span12 rf-search">						
						<div class="widget-box">
							<div class="widget-title">
								<span class="icon"><i class="icon-th"></i></span>
								<h5>检索结果</h5>
							</div>
							
							<div class="widget-content">
									
								<div class="chart" id="main" style="height: 500px;"></div>
								
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
	 				tzAdmin.loadData();
	  			}
	 		});
			tzAdmin.loadData();
		});
		
		var tzAdmin = {
			loadData:function(){
			 	var userid = $("#s-userid").val();		 	
				var useralias = $("#s-useralias").val();
				//alert(userid+"=========="+useralias);

				if(isNotEmpty(userid) && userid.length != 10){
					loading("请输入正确的微博账号！",4);
					return;
				}
				$.ajax({
					type:"post",
					url:adminPath+"/microblogstat/degreescore",
					data:{userId:userid,userAlias:useralias},
					success:function(data){	

						if(data == "0"){
							data = parseInt(data);
							loading("请输入检索条件！",4);
						}else if(data == "null"){
							data = 0;
							loading("没有对该用户进行评分!",5);
						}else{
							data = parseFloat(data);
							loading("您输入的微博用户评分<span class='red' style='font-size:25px'>"+data+"</span>",15);
						}					
						var json = {
							title:"微博舆情等级",	
							datas:data
						};
						//初始化统计报表
						initChart("main",json);
					}
				});
			},
			
			reset:function(){	
				var userid = $("#s-userid").val();
				var useralias = $("#s-useralias").val();
				if(isNotEmpty(userid)) $("#s-userid").val("");
				if(isNotEmpty(useralias)) $("#s-useralias").val("");	
			}
			
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
	                'echarts/chart/gauge'
	            ],
	           function (ec) {
	                var myChart = ec.init(document.getElementById(targetId));
	                var option = {
	                	    tooltip : {
	                	        formatter: "{a} <br/>{b} : {c}"
	                	    },
	                	    toolbox: {
	                	        show : true,
	                	        feature : {
	                	            mark : {show: true},
	                	            restore : {show: true},
	                	            saveAsImage : {show: true}
	                	        }
	                	    },
	                	    series : [
	                	        {
	                	            name:'舆情评分表盘',
	                	            type:'gauge',
	                	            center : ['50%', '50%'],    // 默认全局居中
	                	            radius : [0, '90%'],
	                	            startAngle: 140,
	                	            endAngle : -140,
	                	            min: -1,                     // 最小值
	                	            max: 1,                   // 最大值
	                	            precision: 0,               // 小数精度，默认为0，无小数点
	                	            splitNumber: 10,             // 分割段数，默认为5
	                	            axisLine: {            // 坐标轴线
	                	                show: true,        // 默认显示，属性show控制显示与否
	                	                lineStyle: {       // 属性lineStyle控制线条样式
	                	                    color: [[0.2, '#ff4500'],[0.4, 'orange'],[0.6, 'gold'],[0.8, 'turquoise'],[1, 'lightgreen']], 
	                	                    width: 30
	                	                }
	                	            },
	                	            axisTick: {            // 坐标轴小标记
	                	                show: true,        // 属性show控制显示与否，默认不显示
	                	                splitNumber: 10,    // 每份split细分多少段
	                	                length :10,         // 属性length控制线长
	                	                lineStyle: {       // 属性lineStyle控制线条样式
	                	                    color: '#eee',
	                	                    width: 1,
	                	                    type: 'solid'
	                	                }
	                	            },
	                	            axisLabel: {           // 坐标轴文本标签，详见axis.axisLabel
	                	                show: true,
	                	                formatter: function(v){
	                	                    switch (v+''){
		                	                    case '-1': return '最高(-1.0)';
		        		                        case '-0.8': return '高(-0.8)';
		        		                        case '-0.4': return '较高(-0.4)';
		        		                        case '0': return '中(0)';
		        		                        case '0.4': return '较低(0.4)';
		        		                        case '0.8': return '低(0.8)';
		        		                        case '1': return '最低(1.0)';
	                	                        default: return '';
	                	                    }
	                	                },
	                	                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
	                	                    color: '#333'
	                	                }
	                	            },
	                	            splitLine: {           // 分隔线
	                	                show: true,        // 默认显示，属性show控制显示与否
	                	                length :30,         // 属性length控制线长
	                	                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
	                	                    color: '#eee',
	                	                    width: 2,
	                	                    type: 'solid'
	                	                }
	                	            },
	                	            pointer : {
	                	                length : '95%',
	                	                width : 8,
	                	                color : 'auto'
	                	            },
	                	            title : {
	                	                show : true,
	                	                offsetCenter: ['-65%', -10],       // x, y，单位px
	                	                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
	                	                    color: '#444',
	                	                    fontSize : 20,
	                	                    fontFamily : '微软雅黑'
	                	                }
	                	            },
	                	            detail : {
	                	                show : true,
	                	                backgroundColor: 'rgba(0,0,0,0)',
	                	                borderWidth: 0,
	                	                borderColor: '#ccc',
	                	                width: 100,
	                	                height: 40,
	                	                offsetCenter: ['-65%', 10],       // x, y，单位px
	                	                formatter:'{value}',
	                	                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
	                	                    color: 'auto',
	                	                    fontSize : 40
	                	                }
	                	            },
	                	            data:[{value: json.datas, name:json.title}]
	                	        }
	                	    ]
	                	};

	                	/* clearInterval(timeTicket);
	                	timeTicket = setInterval(function (){
	                	    option.series[0].data[0].value = (Math.random()*100).toFixed(2) - 0;
	                	    myChart.setOption(option, true);
	                	},2000);  */
	                	                               
	                //添加报表数据给echart
					myChart.setOption(option,true);
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
