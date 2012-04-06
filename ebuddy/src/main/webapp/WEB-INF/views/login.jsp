<%@include file="taglib.jsp"%>
<html>
<head>
<body>
	 <div>
	 	<p><a href="./">Home</a>
	 </div>
	<form:form action="login.htm" commandName="user" method="post">
		<table>
			<tbody>							
				<tr>
					<td width="100" align="right">UserName </td>
					<td><form:input path="userName"></form:input>
					<form:errors cssStyle="color:red" path="userName"/></td>
				</tr>
				
				<tr>
					<td width="100" align="right">Password </td>
					<td><form:password path="password"></form:password>
					<form:errors cssStyle="color:red" path="password"/></td>
				</tr>				
				<tr>
					<td colspan="2" align="left">
						<input name="" value="Login" type="submit">						
					</td>
				</tr>
			</tbody>
		</table>
	</form:form>
				
</body>
</head>
</html>
