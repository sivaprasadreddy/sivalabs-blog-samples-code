<!DOCTYPE html>
<%@include file="taglib.jsp" %>
<html>
<head>
<title>Login</title>
<script type="text/javascript">
$(document).ready(function() {
	//console.log("ready!");
	$("#loginForm").submit(function( event ) {
		  
		  var email = $.trim($("#email").val());
		  var password = $.trim($("#password").val());
		  
		  if(email == '' || password == '')
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
			<c:if test="${ERROR != null}">
	             <div class="alert alert-danger">
	                 ${ERROR}
	             </div>
         	</c:if>
         	<c:if test="${msg != null}">
	             <div class="alert alert-success">
	                 ${msg}
	             </div>
         	</c:if>
         	<c:if test="${param.error != null}">
				<div class="alert alert-danger">
					Failed to login.
					<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
						Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
					</c:if>
				</div>
			</c:if>
			
			<c:if test="${param.logout != null}">
				<div class="alert alert-success">
				You have been logged out.
				</div>
			</c:if>	
     </div>  
            
     <div class="row">
		<div class="col-md-6 col-md-offset-2">	
		
		<div class="panel panel-primary">
		  <div class="panel-heading">
		    <h3 class="panel-title">User Login Form</h3>
		  </div>
		  <div class="panel-body">
		    <form:form id="loginForm" method="post" action="login" modelAttribute="user" 
						class="form-horizontal" role="form" cssStyle="width: 800px; margin: 0 auto;">
		
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
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-4">
				      <input type="submit" class="btn btn-primary" value="Login">
				    </div>
				  </div>
				   <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-4">
				      New User? <a href="register">Register</a>
				    </div>
				  </div>
				  
				</form:form>
		  </div>
		</div>

			
	</div>
</div>

	
</body>
</html>