<%@include file="taglib.jsp"%>
<html>
<head>
<body>
	 <div>
	 	<p><a href="./">Home</a>
	 </div>
	<form:form action="registration.htm" commandName="user" method="post">
		<table>
			<tbody>							
				<tr>
					<td width="100" align="right">UserName* </td>
					<td><form:input path="userName"></form:input>
					<form:errors cssStyle="color:red" path="userName"/></td>
				</tr>
				<tr>
					<td width="100" align="right">Password* </td>
					<td><form:password path="password"></form:password>
					<form:errors cssStyle="color:red" path="password"/></td>
				</tr>
				<tr>
					<td width="100" align="right">FirstName </td>
					<td><form:input path="firstName"></form:input>
					<form:errors cssStyle="color:red" path="firstName"/></td>
				</tr>
				<tr>
					<td width="100" align="right">LastName</td>
					<td><form:input path="lastName"></form:input>
					<form:errors cssStyle="color:red" path="lastName"/></td>
				</tr>
				<tr>
					<td width="100" align="right">Email </td>
					<td><form:input path="email"></form:input>
					<form:errors cssStyle="color:red" path="email"/></td>
				</tr>						
				<tr>
					<td width="100" align="right">DOB(dd/MM/yyyy) </td>
					<td><input type="text" id="dob" name="dob">
					<form:errors cssStyle="color:red" path="dob"/></td>
				</tr>
				<tr>
					<td colspan="2" align="left">
						<input name="" value="Register" type="submit">						
					</td>
				</tr>
			</tbody>
		</table>
	</form:form>
				
</body>
</head>
</html>
