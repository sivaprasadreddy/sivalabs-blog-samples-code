<%@include file="taglib.jsp" %>

<html>
<head>

</head>
<body>
<h2>SivaLabs eBuddy</h2>
<hr color="blue" width="100%">
<div>
 	<p><a href="./">Home</a>
 </div>
	<h3>All Links</h3>
	<table style="border-collapse: collapse;" border="1">
		<tr bgcolor="lightblue" style="border: 1; border-collapse: collapse;">
			<th>Title</th>
			<th>URL</th>			
			<th>PostedBy</th>	
			<th>PostedOn</th>
			
		</tr>
		<c:if test="${empty ALL_LINKS}">
		<tr>
			<td colspan="4">No Links found</td>
		</tr>
		</c:if>
		<c:if test="${! empty ALL_LINKS}">
			<c:forEach var="link" items="${ALL_LINKS}">		
		    <tr style="border: 1; border-collapse: collapse;">
				<td><c:out value="${link.title}"></c:out></td>
				<td><c:out value="${link.url}"></c:out></td>
				<td><c:out value="${link.postedBy.firstName}"></c:out> </td>
				<td><fmt:formatDate value="${link.postedOn}" pattern="dd/MM/yyyy hh:mm:ss"/></td>				
			</tr>
			</c:forEach>
		</c:if>				
	</table>
	
	<hr>
	<h3>User Links</h3>
	<table style="border-collapse: collapse;" border="1">
		<tr bgcolor="lightblue" style="border: 1; border-collapse: collapse;">
			<th>Title</th>
			<th>URL</th>			
			<th>PostedBy</th>	
			<th>PostedOn</th>
			
		</tr>
		<c:if test="${empty USER_LINKS}">
		<tr>
			<td colspan="4">No Links found</td>
		</tr>
		</c:if>
		<c:if test="${! empty USER_LINKS}">
			<c:forEach var="link" items="${USER_LINKS}">		
		    <tr style="border: 1; border-collapse: collapse;">
				<td><c:out value="${link.title}"></c:out></td>
				<td><c:out value="${link.url}"></c:out></td>
				<td><c:out value="${link.postedBy.firstName}"></c:out> </td>
				<td><fmt:formatDate value="${link.postedOn}" pattern="dd/MM/yyyy hh:mm:ss"/></td>				
			</tr>
			</c:forEach>
		</c:if>				
	</table>
</body>
</html>