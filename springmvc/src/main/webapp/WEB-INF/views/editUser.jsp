<%@include file="taglib_includes.jsp" %>

<html>
<head>
	<script type="text/javascript" src="resources/js/user.js"></script>
	<title>SivaLabs </title>
</head>
<body style="font-family: Arial; font-size:smaller;">

<table  bgcolor="lightblue" width="750" height="500" align="center" style="border-collapse: collapse;" border="1" bordercolor="#006699" >
	<tr>
		<td align="center"><h3>Edit User Form</h3></td>
	</tr>
  <tr valign="top" align="center">
    <td align="center">
 		<form:form action="updateUser" method="post" commandName="editUser">
				<table width="500" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2">					
					<tr>
						<td width="100" align="right">Id</td>
						<td width="150">
						<form:input path="userId" readonly="true"/></td>
						<td align="left">
						<form:errors path="userId" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">EmailId</td>
						<td><form:input path="emailId"/></td>
						<td align="left">
						<form:errors path="emailId" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">Password</td>
						<td><form:input path="password"/></td>
						<td align="left"><form:errors path="password" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr>
						<td width="100" align="right">FirstName</td>
						<td>
						<form:input path="firstname"/></td>
						<td align="left">
						<form:errors path="firstname" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
					<tr>
						<td width="100" align="right">DOB</td>
						<td><form:input path="dob"/></td>
						<td align="left"><form:errors path="dob" cssStyle="color:red"></form:errors>  </td>
					</tr>
					
					<tr>
						<td width="100" align="right">Phone</td>
						<td><form:input path="phone"/></td>
						<td align="left">
						<form:errors path="phone" cssStyle="color:red"></form:errors>  </td>
					</tr>
					<tr valign="bottom">
						<td colspan="3" align="center">
						<input type="button"  value="Delete" onclick="javascript:deleteUser('deleteUser?id=${editUser.userId}');">
						&nbsp;&nbsp;
						<input type="submit" name="" value="Save">						
						&nbsp;&nbsp;
						<input type="button"  value="Back" onclick="javascript:go('viewAllUsers');">
						</td>
					</tr>
					
				</table>				
		</form:form>
    </td>    
  </tr>
</table>


</body>
</html>
