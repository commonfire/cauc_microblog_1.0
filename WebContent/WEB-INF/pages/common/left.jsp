<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div id="sidebar">
  <ul>
    <li class="active"><a href="${adminPath}/index"><i class="icon icon-home"></i> <span>首页</span></a> </li>
    <li class="submenu"> <a href="javascript:void(0);"><i class="icon icon-user"></i> <span>用户管理</span><span class="label label-important">2</span></a> 
      <ul>
        <li><a href="${adminPath}/user/list">用户列表</a></li>
        <li><a href="${adminPath}/user/add">用户添加</a></li>
      </ul>       
    </li>
    <li class="submenu"> <a href="#"><i class="icon icon-inbox"></i> <span>系统管理</span> <span class="label label-important">2</span></a> 
      <ul>
        <li><a href="${adminPath}/permission/list">权限管理</a></li>
        <li><a href="${adminPath}/role/list">角色管理</a></li>
      </ul>    
    </li>
    <li><a href="${adminPath}/microbloguser/list"><i class="icon icon-th"></i> <span>微博用户检索</span></a></li>
    <li><a href="${adminPath}/microblogcontent/list"><i class="icon icon-fullscreen"></i> <span>微博内容检索</span></a></li>
    <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>微博统计分析</span> <span class="label label-important">5</span></a>
      <ul>
      	<li><a href="${adminPath}/microblogstat/contentlist">微博内容统计</a></li>
        <li><a href="${adminPath}/microblogstat/age">用户年龄</a></li>
        <li><a href="${adminPath}/microblogstat/male">用户性别</a></li>
        <li><a href="${adminPath}/microblogstat/location">用户地域</a></li>
        <li><a href="${adminPath}/microblogstat/friend">用户朋友圈</a></li>
        <li><a href="${adminPath}/microblogstat/degree">民航威胁度</a></li>
      </ul>
    </li>
    <li class="submenu"> <a href="#"><i class="icon icon-file"></i> <span>平台日志统计</span> <span class="label label-important">2</span></a>
      <ul>
        <%-- <li><a href="${adminPath}/adminstat/list">发布微博数量</a></li> --%>
        <li><a href="${adminPath}/adminstat/userlist">用户注册数统计</a></li>
        <%-- <li><a href="${adminPath}/adminstat/contentlist">微博内容统计</a></li> --%>
      </ul>
    </li>
    <li><a href="${adminPath}/rules/list"><i class="icon icon-legal"></i> <span>数据采集/预警规则</span></a></li>
    <li><a href="${adminPath}/blackman/list"><i class="icon icon-heart"></i> <span>重点人员管理</span></a></li>
    <li><a href="${adminPath}/warnningman/list"><i class="icon icon-bell"></i> <span>预警人员管理</span></a></li>
    <li><a href="${adminPath}/changepassword/list"><i class="icon icon-key"></i> <span>密码修改</span></a></li>
    <li><a href="http://10.1.46.170:8180/xjmhga-web/index.jsp#/yujing"><i class="icon icon-pencil"></i> <span>人物图谱</span></a></li>    
  </ul>
</div>

