<%@ include file="taglib.jsp" %>
<html>
<head>
	<script type="text/javascript">
	$(function(){
		$("#cancelBtn").click(function(){
			window.location = "home.htm";
		});
	});
	</script>
</head>
<body>
	<div>
	
	<form:form action="changePwd.htm" commandName="changePwd" method="post">
		<span style="color: red;">
			<form:errors cssClass="error" path="*"></form:errors>
		</span>	
		<table>
			<form:hidden path="userId"/>
			<tbody>
				<tr>
					<td width="200" align="right">Current Password* </td>
					<td><input type="password" name="currentPwd"></td>
				</tr>
				<tr>
					<td width="200" align="right">New Password* </td>
					<td><input type="password" name="newPwd"> 
					</td>
				</tr>
				<tr>
					<td width="200" align="right">Confirm Password* </td>
					<td><input type="password" name="confirmPwd"> 
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input value="Change Password" type="submit">&nbsp;						
						<input type="button" value="Cancel" id="cancelBtn">
					</td>
				</tr>
			</tbody>
		</table>
	</form:form>
	</div>
</body>
</html>	
	