<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="warnningman" varStatus="warnningmanindex" items="${datas}">
	<tr class="gradeX">
		<td class="taskStatus">
			${warnningman.id}
			<c:if test="${warnningmanindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>	
		<td class="taskStatus">${warnningman.userAlias}</td>	
		<td class="taskStatus span5">${warnningman.brief}</td>
		<td class="taskStatus">${warnningman.userId}</td>	
		<td class="taskStatus">${warnningman.birthday}</td>
		<td class="taskStatus">${warnningman.location}</td>	
		<td class="taskStatus">${warnningman.sex}</td>	
		<td class="taskStatus">${warnningman.registerTime}</td>	
		<td class="taskStatus">${warnningman.degree}</td>		
	</tr>
</c:forEach>