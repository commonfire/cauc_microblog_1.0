<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/cauc_microblog/resources/js/ui/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	 c = setInterval(checkIsExist,1000);//每1秒执行一次checkIsExist方法
	});

	function checkIsExist(){
	    $.ajax({
	        type: "GET",
	        url: "NewFile.jsp",
	        //data: url参数
	        success: function(response_flag){
	        	if (response_flag == 1)
	             {
	                 saveHere = response_text;
	                 console.log("this time I get 1,so stop.")  
	                 <%System.out.println("this is a test");%>
	                 window.clearInterval(c);
	             }else{
	            	 console.log('calling again...');
	             }
	        }
	    });
	}
</script>

</body>
</html>