<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="microblogcontent" varStatus="microblogcontentindex" items="${datas}">
	<tr class="gradeX">
		<td class="taskStatus">
			${microblogcontent.id}
			<c:if test="${microblogcontentindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>		
		<td class="taskStatus">${microblogcontent.userAlias}</td>						
		<td class="taskStatus">${microblogcontent.userId}</td>
		<td class="content_keys">${microblogcontent.content}</td>
		<td class="taskStatus">${microblogcontent.repostUser}</td>
		<td class="taskStatus">
			${microblogcontent.publishTime}
		</td>
		<td class="taskStatus">score</td>
	</tr>	
</c:forEach>
