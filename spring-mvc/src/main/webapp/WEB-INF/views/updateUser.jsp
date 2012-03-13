<%@include file="taglib.jsp"%>
<html>
<head>
	<script type="text/javascript">
		$(function(){
			$("#dob").datepicker({dateFormat: 'dd/mm/yy'});

			$(function(){
				$("#cancelBtn").click(function(){
					window.location = "home.htm";
				});
			});
			
		});
	</script>
</head>
<body>
	 <form:form action="updateUser.htm" commandName="updateUser" method="post">
		<span style="color: red;">
			<form:errors cssClass="error"></form:errors>
		</span>	
		<table>
			<form:hidden path="userId"/>
			<form:hidden path="userName"/>
			<form:hidden path="password"/>
			 
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
					<td>
						<form:input path="dob" id="dob"/>
					<form:errors cssStyle="color:red" path="dob"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input name="" value="Save" type="submit">	&nbsp;
						<input type="button" value="Cancel" id="cancelBtn">			
					</td>
				</tr>
			</tbody>
		</table>
	</form:form>
				
</body>
</head>
</html>
