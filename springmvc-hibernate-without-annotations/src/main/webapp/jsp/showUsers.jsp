<%@include file="taglib.jsp"%>

<html>
<head>

<title>Welcome</title>
<script src ="js/user.js" type="text/javascript">
	
</script>
</head>
<body style="font-family: Arial; font-size: smaller;">
	<center>
		<form action="showUsers.htm" method="post">
			<table style="border-collapse: collapse; width: 500px;" border="0"
				bordercolor="#006699">
				<tbody>
					<tr>
						<td>Enter Name</td>
						<td><input name="name" type="text"> 
						<input value="Search" type="submit"> 
						<input onclick="javascript:go('createUser.htm');" value="New User"
							type="button">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<table style="border-collapse: collapse; width: 500px;" border="1" bordercolor="#006699">
			<tbody>
				<tr bgcolor="lightblue">
					<th>UserId</th>
					<th>UserName</th>
					<th>Email</th>
					<th></th>
				</tr>
		<c:if test="${empty USERS_KEY}">
			<tr>
				<td colspan="4">No Results found</td>
			</tr>
		</c:if>
		<c:if test="${! empty USERS_KEY}">
			<c:forEach items="${USERS_KEY}" var="user">
				<tr>
					<td><c:out value="${user.userId}"></c:out>
					</td>
					<td><c:out value="${user.username}"></c:out>
					</td>
					<td><c:out value="${user.emailId}"></c:out>
					</td>
					<td><a href="updateUser.htm?id=${user.id}">Edit</a>
						<a href="javascript:deleteUser('deleteUser.htm?id=${user.id}');">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
		</tbody>
		</table>
	</center>

</body>
</html>