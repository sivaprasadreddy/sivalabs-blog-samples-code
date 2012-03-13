<%@ include file="taglib.jsp" %>
<html>
<head>
	<script type="text/javascript">
	$(function(){

		$("#registrationBtn").click(function(){
			window.location = "registration.htm";
		});
		
	});
	</script>
</head>
<body>
	<div>
	
	<form:form action="login.htm" commandName="loginUser" method="post">
		<span style="color: red;">
			<form:errors cssClass="error"></form:errors>
		</span>	
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
					<td colspan="2" align="right">
						<input value="Login" type="submit">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						New User? <input type="button" value="Register" id="registrationBtn">
					</td>
				</tr>
			</tbody>
		</table>
	</form:form>
	</div>
</body>
</html>	
	