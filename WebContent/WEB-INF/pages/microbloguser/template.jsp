<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="microbloguser" varStatus="microbloguserindex" items="${datas}">
	<tr class="gradeX">
		<td class="taskStatus">
			${microbloguser.id}
			<c:if test="${microbloguserindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>	
		<td class="taskStatus">${microbloguser.userAlias}</td>	
		<td class="taskStatus span5">${microbloguser.brief}</td>
		<td class="taskStatus">${microbloguser.userId}</td>	
		<td class="taskStatus">${microbloguser.birthday}</td>
		<td class="taskStatus">${microbloguser.location}</td>	
		<td class="taskStatus">${microbloguser.sex}</td>	
		<td class="taskStatus">${microbloguser.registerTime}</td>	
		<td class="taskStatus">${microbloguser.degree}</td>		
	</tr>
</c:forEach>