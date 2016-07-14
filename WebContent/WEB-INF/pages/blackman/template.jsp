<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="blackman" varStatus="blackmanindex" items="${datas}">
	<tr class="gradeX">
		<td class="taskStatus">
			${blackman.id}
			<c:if test="${blackmanindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>	
		<td class="taskStatus">${blackman.userAlias}</td>	
		<td class="taskStatus span5">${blackman.brief}</td>
		<td class="taskStatus">${blackman.userId}</td>	
		<td class="taskStatus">${blackman.birthday}</td>
		<td class="taskStatus">${blackman.location}</td>	
		<td class="taskStatus">${blackman.sex}</td>	
		<td class="taskStatus">${blackman.registerTime}</td>	
		<td class="taskStatus">${blackman.degree}</td>		
	</tr>
</c:forEach>