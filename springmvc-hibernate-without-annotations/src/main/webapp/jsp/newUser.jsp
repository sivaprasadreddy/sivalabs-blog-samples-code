<%@include file="taglib.jsp"%>

<html>
<head>
<script src ="js/user.js" type="text/javascript">
	
</script>
<title>Welcome</title>
</head>
<body style="font-family: Arial; font-size: smaller;">

	<table style="border-collapse: collapse; width: 750px;" align="center"
		bgcolor="lightblue" border="1" bordercolor="#006699" height="500">
		<tbody>
			<tr>
				<td align="center"><h3>New User Form</h3></td>
			</tr>
			<tr valign="top" align="center">
				<td align="center">
				<form:form action="createUser.htm" commandName="newUser" method="post">
					<table style="border-collapse: collapse; width: 500px;" border="0"
						bordercolor="#006699" cellpadding="2" cellspacing="2">
						<tbody>
							<tr>
								<td width="100" align="right">UserId</td>
								<td width="150"><form:input path="userId"></form:input></td>
								<td align="left"><form:errors cssStyle="color:red" path="userId"/></td>
							</tr>
							
							<tr>
								<td width="100" align="right">Password</td>
								<td><form:password path="password"></form:password></td>
								<td align="left"><form:errors cssStyle="color:red" path="password"/></td>
							</tr>
							<tr>
								<td width="100" align="right">UserName</td>
								<td><form:input path="username"></form:input></td>
								<td align="left"><form:errors cssStyle="color:red" path="username"/></td>
							</tr>
							<tr>
								<td width="100" align="right">Email</td>
								<td><form:input path="emailId"></form:input></td>
								<td align="left"><form:errors cssStyle="color:red" path="emailId"/></td>
							</tr>
							
							<tr>
								<td colspan="3" align="center">
								<input name="" value="Save" type="submit"> 
									<input name="" value="Reset" type="reset"> 
									<input onclick="javascript:go('showUsers.htm');" 
									value="Back" type="button">
								</td>
							</tr>
						</tbody>
					</table>
				</form:form>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>