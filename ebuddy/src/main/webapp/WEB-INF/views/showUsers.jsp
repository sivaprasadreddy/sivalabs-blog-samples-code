<%@include file="taglib.jsp" %>
<html>
<head>

<link rel="stylesheet" type="text/css" href="resources/jquery/css/ui-lightness/jquery-ui-1.8.16.custom.css">
<script type="text/javascript" src="resources/jquery/js/jquery-1.6.2.min.js"></script>
</head>
<body>
 <div>
 	<p><a href="./">Home</a>
 </div>
	<form action="showUsers.htm" method="post">		
			<table>
			<tr>
				<td>Enter User Name</td> 
				<td><input type="text" name="name"/>
					&nbsp;&nbsp;<input type="submit" value="Search"/>
					
				</td>
			</tr>
		</table>
	</form>
	
	<table style="border-collapse: collapse;" border="1">
		<tr bgcolor="lightblue" style="border: 1; border-collapse: collapse;">
			<th>UserId</th>
			<th>UserName</th>			
			<th>Email</th>	
			<th>DOB</th>
			
		</tr>
		<c:if test="${empty USERS_KEY}">
		<tr>
			<td colspan="4">No Results found</td>
		</tr>
		</c:if>
		<c:if test="${! empty USERS_KEY}">
			<c:forEach var="user" items="${USERS_KEY}">		
		    <tr style="border: 1; border-collapse: collapse;">
				<td><c:out value="${user.userId}"></c:out></td>
				<td><c:out value="${user.userName}"></c:out></td>
				<td><c:out value="${user.email}"></c:out> </td>
				<td><fmt:formatDate value="${user.dob}" pattern="dd/MM/yyyy"/></td>
				
			</tr>
			</c:forEach>
		</c:if>				
	</table>
	
</body>
</html>