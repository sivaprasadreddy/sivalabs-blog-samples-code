<!DOCTYPE html>
<%@include file="taglib.jsp" %>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" href='<spring:url value="resources/css/styles.css"/>' />
<script type="text/javascript" src='<spring:url value="resources/jquery/jquery-1.10.2.js"/>'></script>
<script type="text/javascript" src='<spring:url value="resources/js/app.js"/>'></script>
<script type="text/javascript">
$(document).ready(function() {
	//console.log("ready!");
	$("#loginForm").submit(function( event ) {
		
		  $("#userNameError").html("");
		  $("#passwordError").html("");
		  
		  var userName = $.trim($("#userName").val());
		  var password = $.trim($("#password").val());
		  
		  if(userName == '' || password == '')
		  {
				alert("Please enter all mandatory fields");
				event.preventDefault();
				return false;
      }		   
	});
});
</script>
</head>
<body>
	<form:form id="loginForm" method="post" action="login" modelAttribute="user" class="form-horizontal" role="form" cssStyle="width: 800px; margin: 0 auto;">
  <h2 class="form-signin-heading">User Login Form</h2>
		<c:if test="${ERROR != null }">
			<div>
				<p>Error: ${ERROR}
			</div>
		</c:if>
		<table>
			
			<tr>
				<td>UserName*</td>
				<td><form:input path="userName" class="form-control" placeholder="UserName" /><span id="userNameError"></span></td>
			</tr>
			<tr>
				<td>Password*</td>
				<td><form:password path="password" class="form-control" placeholder="Password" /><span id="passwordError"></span> </td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" class="btn btn-primary" value="Login"> </td>
			</tr>
      <tr>
        <td>New User?</td>
        <td><a href="register">Register</a> </td>
      </tr>
		</table>
	</form:form>
	
</body>
</html>