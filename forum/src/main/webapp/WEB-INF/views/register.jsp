<!DOCTYPE html>
<%@include file="taglib.jsp" %>
<html>
<head>
<title>Register</title>
<script type="text/javascript">
$(document).ready(function() {
	
	$("#registrationForm").submit(function( event ) {
		
		  var password = $.trim($("#password").val());
		  var firstName = $.trim($("#firstName").val());
		  var email = $.trim($("#email").val());
		  if(password == '' || firstName == '' || email == '')
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
<div>&nbsp;</div>
<div class="col-md-6 col-md-offset-2">	
<c:if test="${ERROR != null }">
			<div class="alert alert-danger">
				<p>${ERROR}
			</div>
		</c:if>
		</div>
		
<div class="row">
		<div class="col-md-6 col-md-offset-2">	
			
			<div class="panel panel-primary">
		  <div class="panel-heading">
		    <h3 class="panel-title">Registration Form</h3>
		  </div>
		  <div class="panel-body">
			<form:form id="registrationForm" method="post" action="register" modelAttribute="user" cssStyle="width: 800px; margin: 0 auto;" class="form-horizontal" role="form">
		  <div class="form-group">
		    <label for="email" class="col-sm-2 control-label">Email*</label>
		    <div class="col-sm-4">
		      <input type="text" id="email" name="email" class="form-control" placeholder="Email" />
		      <form:errors path="email"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="password" class="col-sm-2 control-label">Password*</label>
		    <div class="col-sm-4">
		      <input type="password" id="password" name="password" class="form-control" placeholder="Password" />
		      <form:errors path="password"/>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="firstName" class="col-sm-2 control-label">FirstName*</label>
		    <div class="col-sm-4">
		      <input type="text" id="firstName" name="firstName" class="form-control" placeholder="FirstName" />
		      <form:errors path="firstName"/>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="lastName" class="col-sm-2 control-label">LastName</label>
		    <div class="col-sm-4">
		      <input type="text" id="lastName" name="lastName" class="form-control" placeholder="LastName" />
		      <form:errors path="lastName"/>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="dob" class="col-sm-2 control-label">Date Of Birth</label>
		    <div class="col-sm-4">
		      <input type="text" id="dob" name="dob" class="form-control" placeholder="yyyy-MM-dd" />
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
		      Already Registered? <a href="loginForm">Login</a>
		    </div>
		  </div>
		  
		</form:form>
		
		</div>
		</div>
	</div>
</div>

	
</body>
</html>