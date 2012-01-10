<%@include file="taglib_includes.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SivaLabs </title>
<script type="text/javascript" src="resources/js/user.js"></script>
</head>
<body style="font-family: Arial; font-size:smaller;">
	<center>
	<form action="searchUsers" method="post">		
			<table style="border-collapse: collapse;" border="0" bordercolor="#006699" width="500">
			<tr>
				<td>Enter User Name</td> 
				<td><input type="text" name="name"/>
					&nbsp;&nbsp;<input type="submit" value="Search"/>
					&nbsp;&nbsp;<input type="button" value="New User" onclick="javascript:go('saveUser');"/>
			</td></tr>
		</table>
	</form>
	
	<table style="border-collapse: collapse;" border="1" bordercolor="#006699" width="500">
		<tr bgcolor="lightblue">
			<th>Id</th>
			<th>Name</th>			
			<th>Email</th>	
			<th>Mobile</th>
			<th></th>
		</tr>
		<c:if test="${empty SEARCH_USERS_RESULTS_KEY}">
		<tr>
			<td colspan="4">No Results found</td>
		</tr>
		</c:if>
		<c:if test="${! empty SEARCH_USERS_RESULTS_KEY}">
			<c:forEach var="user" items="${SEARCH_USERS_RESULTS_KEY}">		
		    <tr>
				<td><c:out value="${user.userId}"></c:out></td>
				<td><c:out value="${user.firstname} ${user.lastname}"></c:out></td>
				<td><c:out value="${user.emailId}"></c:out> </td>
				<td><c:out value="${user.phone}"></c:out></td>
				<td>
					&nbsp;<a href="updateUser?id=${user.userId}">Edit</a>
					&nbsp;&nbsp;<a href="javascript:deleteUser('deleteUser?id=${user.userId}');">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</c:if>				
	</table>	
	</center>
		
</body>
</html>