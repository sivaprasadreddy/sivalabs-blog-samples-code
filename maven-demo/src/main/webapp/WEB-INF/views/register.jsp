<!DOCTYPE html>
<%@include file="taglib.jsp" %>
<html>
<head>
<title>Create User</title>
<script type="text/javascript">
$(document).ready(function() {
	
	$("#registrationForm").submit(function( event ) {
		
		  var userName = $.trim($("#userName").val());
		  var password = $.trim($("#password").val());
		  var email = $.trim($("#email").val());
		  if(userName == '' || password == '' || email == '')
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

<div class="col-md-6 col-md-offset-2">	
<c:if test="${error != null }">
	<div class="alert alert-danger">
		<p>${error}
	</div>
</c:if>

</div>	

<div class="row">
		<div class="col-md-6 col-md-offset-2">	
			<h2>User Registration Form</h2>
			<form:form id="registrationForm" method="post" action="register" modelAttribute="user" cssStyle="width: 800px; margin: 0 auto;" class="form-horizontal" role="form">
		  <div class="form-group">
		    <label for="userName" class="col-sm-2 control-label">UserName*</label>
		    <div class="col-sm-4">
		      <form:input path="userName" id="userName"  cssClass="form-control" />
		      <form:errors path="userName"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="password" class="col-sm-2 control-label">Password*</label>
		    <div class="col-sm-4">
		      <form:password path="password" id="password" cssClass="form-control"/>
		      <form:errors path="password"/>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="email" class="col-sm-2 control-label">Email*</label>
		    <div class="col-sm-4">
		      <form:input path="email" id="email"  cssClass="form-control" />
		      <form:errors path="email"/>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="firstName" class="col-sm-2 control-label">FirstName*</label>
		    <div class="col-sm-4">
		      <form:input path="firstName" id="firstName"  cssClass="form-control" />
		      <form:errors path="firstName"/>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="lastName" class="col-sm-2 control-label">LastName</label>
		    <div class="col-sm-4">
		      <form:input path="lastName" id="lastName"  cssClass="form-control" />
		      <form:errors path="lastName"/>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="dob" class="col-sm-2 control-label">Date Of Birth</label>
		    <div class="col-sm-4">
		      <form:input path="dob" id="dob"  cssClass="form-control" />
		      <form:errors path="dob" cssClass="text-danger" />
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-4">
		      <input type="submit" class="btn btn-primary" value="Register">
		    </div>
		  </div>
		   <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-4">
		      Already Registered? <a href="login">Login</a>
		    </div>
		  </div>
		  
		</form:form>
	</div>
</div>

	
</body>
</html>