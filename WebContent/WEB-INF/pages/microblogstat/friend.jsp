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
					<a href="${adminPath}/index" title="返回首页" class="tip-bottom"><i class="icon-home"></i>首页</a><a href="javascript:void(0);">微博统计分析</a><a href="#" class="current">用户朋友圈</a>
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
<!-- 				            <div class="control-group span4">
				              <label class="control-label">用户昵称：</label>
				              <div class="controls">
				                <input type="text" class="span11" id="s-useralias" placeholder="请输入用户微博昵称..." />
				              </div>
				            </div>				            			            
 -->				        <div class="clearfix"></div>
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
									
								<div class="chart" id="main" style="height: 650px;"></div>
								
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
			 	if(isEmpty(userid)){
			 		userid = "3655612552";
			 	}
				$.ajax({
					type:"post",
					url:adminPath+"/microblogstat/friendlist",
					data:{userId:userid},
					success:function(data){
						//alert(JSON.stringify(data));
						var nodes = data[0];
						var links = data[1];		
						var json = {
							title:"微博用户所在地统计",	
							nodes:nodes,
							links:links
						};	
						//alert(JSON.stringify(json.nodes));
						//alert(JSON.stringify(json.links));
						initChart("main",json);//初始化统计报表
					}
				});
			},
			
			reset:function(){	
				var userid = $("#s-userid").val();
				if(isNotEmpty(userid)) $("#s-userid").val("");
			}
			
		};
		
		//数据格式化
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
		}
	
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
                'echarts/chart/force', // 按需加载模块
                'echarts/chart/chord'
            ],
           function (ec) {
                var myChart = ec.init(document.getElementById(targetId));
                var option = {
                	    title : {
                	        text: '微博@用户关系',
                	        subtext: '数据来自新浪微博',
                	        x:'center',
                	        y:'top'
                	    },
                	    tooltip : {
                	        trigger: 'item',
                	        formatter: '{a} : {b}'
                	    },
                	    toolbox: {
                	        show : true,
                	        feature : {
                	            restore : {show: true},
                	            magicType: {show: true, type: ['force', 'chord']},
                	            saveAsImage : {show: true}
                	        }
                	    },
                	    legend: {
                	        x: 'left',
                	        data:['微博一级@用户','微博二级@用户','微博三级@用户']
                	    },
                	    series : [
                	        {
                	            type:'force',
                	            name : "微博@用户关系",
                	            ribbonType: false,
                	            categories : [
           			                {
           			                    name: '主人物'
           			                },
           			                {
           			                    name: '微博一级@用户'
           			                },
           			                {
           			                    name: '微博二级@用户'
           			                },          			                
           			                {
           			                    name: '微博三级@用户'
           			                }
                  			            ],
                	            itemStyle: {
                	                normal: {
                	                    label: {
                	                        show: true,
                	                        textStyle: {
                	                            color: '#333'
                	                        }
                	                    },
                	                    nodeStyle : {
                	                        brushType : 'both',
                	                        borderColor : 'rgba(255,215,0,0.4)',
                	                        borderWidth : 1
                	                    },
                	                    linkStyle: {
                	                        type: 'curve'
                	                    }
                	                },
                	                emphasis: {
                	                    label: {
                	                        show: false
                	                        // textStyle: null      // 默认使用全局文本样式，详见TEXTSTYLE
                	                    },
                	                    nodeStyle : {
                	                        //r: 30
                	                    },
                	                    linkStyle : {}
                	                }
                	            },
                	            useWorker: false,
                	            minRadius : 18,
                	            maxRadius : 30,
                	            gravity: 1.1,
                	            scaling: 1.1,
                	            roam: 'move',
                	            nodes: json.nodes,
                	            links :json.links              	            	
                	        }
                	    ]
                	};
                	var ecConfig = require('echarts/config');
                	function focus(param) {
                		//alert(JSON.stringify(param));
                		
                	    var data = param.data;
                	    //alert(data.category);
                	    var links = option.series[0].links;
                	    var nodes = option.series[0].nodes;
                	   // alert(JSON.stringify(links));
                	   // alert(nodes);
                	    if (
                	        data.source !== undefined
                	        && data.target !== undefined
                	    ) { //点击的是边
                	        var sourceNode = nodes.filter(function (n) {return n.name == data.source})[0];
                	        var targetNode = nodes.filter(function (n) {return n.name == data.target})[0];
                	        console.log("选中了边 " + sourceNode.name + ' -> ' + targetNode.name + ' (' + data.weight + ')');
                	    } else { // 点击的是点
                	        console.log("选中了" + data.name + '(' + data.value + ')');
                	    }
                	}
                	myChart.on(ecConfig.EVENT.CLICK, focus)
                	
                	myChart.on(ecConfig.EVENT.FORCE_LAYOUT_END, function () {
                	    console.log(myChart.chart.force.getPosition());
                	});

             	                               
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
