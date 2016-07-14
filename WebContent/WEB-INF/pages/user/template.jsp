<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="user" varStatus="userindex" items="${datas}">
	<tr class="gradeX">
		<td class="taskStatus">
			${user.id}
			<c:if test="${userindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>
		<td class="taskStatus">${user.realName}</td>						
		<td class="taskStatus">
			<tz:if test="${user.male==1}">
				<tz:then>男</tz:then>
			</tz:if>
			<tz:if test="${user.male==0}">
				<tz:then>女</tz:then>				
			</tz:if>
			<tz:if test="${user.male==2}">
				<tz:then>未知</tz:then>				
			</tz:if>					
		</td>
		<td class="taskStatus">${user.cardId}</td>
		<td class="taskStatus">${user.email}</td>
		<td class="taskStatus">${user.telephone}</td>
		<td class="taskStatus">${user.company}</td>
		<td class="taskStatus tmui-tips" tip="${tz:timeFormat(user.createTime)}">${tz:formatDate(user.createTime,'yyyy-MM-dd HH:mm:ss')}</td>
		<td class="taskStatus">
			<tz:if test="${user.isDelete==0}">
				<tz:then><a href="javascript:void(0)" opid="${user.id}" mark="isDelete" val="1" onclick="tzAdmin.op(this);" class="green">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${user.id}" mark="isDelete" val="0" onclick="tzAdmin.op(this);" class="red">是</a></tz:else>
			</tz:if>	
		</td>
		<td class="taskStatus">
			<tz:if test="${user.forbiden==0}">
				<tz:then><a href="javascript:void(0)" opid="${user.id}" mark="forbiden" val="1" onclick="tzAdmin.op(this);" class="green">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${user.id}" mark="forbiden" val="0" onclick="tzAdmin.op(this);" class="red">是</a></tz:else>
			</tz:if>	
		</td>	
		
		<td class="taskOptions">
			<%-- <a href="javascript:void(0);" data-opid="${user.id}" onclick="tzAdmin.op(this);" class="tmui-tips" tip="更新"><i class="icon-ok"></i></a>  --%>
			<a href="javascript:void(0);" data-opid="${user.id}" onclick="tzAdmin.remove(this);" class="tmui-tips" tip="删除"><i class="icon-remove"></i></a>
		</td>
	</tr>	
</c:forEach>
