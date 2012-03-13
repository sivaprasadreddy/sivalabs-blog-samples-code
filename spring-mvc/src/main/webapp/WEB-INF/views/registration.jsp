<%@include file="taglib.jsp"%>
<html>
<head>
		<script type="text/javascript">
		$(function(){
			$("#dob").datepicker({dateFormat: 'dd/mm/yy'});

			$("#loginBtn").click(function(){
				window.location = "login.htm";
			});
			
		});
	</script>
</head>
<body>

<form:form action="registration.htm" commandName="registrationUser" method="post">
		<span style="color: red;">
			<form:errors cssClass="error"></form:errors>
		</span>	
		<table>
			<tbody>
				<tr>
					<td width="100" align="right">FirstName* </td>
					<td><form:input path="firstName"></form:input>
					<form:errors cssStyle="color:red" path="firstName"/></td>
				</tr>
				<tr>
					<td width="100" align="right">lastName </td>
					<td><form:input path="lastName"></form:input>
					<form:errors cssStyle="color:red" path="lastName"/></td>
				</tr>
				<tr>
					<td width="100" align="right">Email* </td>
					<td><form:input path="email"></form:input>
					<form:errors cssStyle="color:red" path="email"/></td>
				</tr>						
				<tr>
					<td width="100" align="right">DOB </td>
					<td><input type="text" id="dob" name="dob">
					<form:errors cssStyle="color:red" path="dob"/></td>
				</tr>
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
					<td colspan="2" align="right">
						<input name="" value="Register" type="submit">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						Existing User? <input type="button" value="Login" id="loginBtn">
					</td>
				</tr>
			</tbody>
		</table>
	</form:form>

</body>
</html>