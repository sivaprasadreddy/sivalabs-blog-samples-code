<!DOCTYPE html>
<%@include file="taglib.jsp" %>
<html>
<head>
<title>Create User</title>
<script type="text/javascript">
$(document).ready(function() {
	console.log("ready!");
	$("#registrationForm").submit(function( event ) {
		
		  $("#userNameError").html("");
		  $("#emailError").html("");
		  
		  var userName = $.trim($("#userName").val());
		  var password = $.trim($("#password").val());
		  var firstName = $.trim($("#userName").val());
		  var email = $.trim($("#email").val());
		  if(userName == '' || password == '' || firstName == '' || email == '')
		  {
				alert("Please enter all mandatory fields");
				event.preventDefault();
				return false;
          }
          else
          {
        	  var validForm = true;
        	  $.ajaxSetup({async: false});
        	  $.get("checkUserNameExists",{ userName : userName }, function(response){            	  
        		    if(response.status == false){
        		    	$("#userNameError").html(response.errors[0]);
        		    	validForm = false;
            		}
        	  });
        	  
        	  $.get("checkEmailExists",{ email : email }, function(response){
      		    if(response.status == false){
    		    	$("#emailError").html(response.errors[0]);
    		    	validForm = false;
          		}
      	  	});
        	
        	$.ajaxSetup({async: true});
        	if(!validForm){
        		event.preventDefault();
  				return false; 
            }
			return true;
          }	 
		   
	});
});
</script>
</head>
<body>
	<form:form id="registrationForm" method="post" action="register" modelAttribute="user" cssStyle="width: 800px; margin: 0 auto;" class="form-horizontal" role="form">
   <%--  <spring:message code="appTitle"></spring:message> --%>
		<c:if test="${ERROR != null }">
			<div>
				<p>Error: ${ERROR}
			</div>
		</c:if>
    <%--
     <div>
      <form:errors path="*"></form:errors>
    </div> 
    --%>
		<table>
			
			<tr>
				<td>UserName*</td>
				<td><form:input path="userName" /><span id="userNameError"><form:errors path="userName"/> </span></td>
			</tr>
			<tr>
				<td>Password*</td>
				<td><form:password path="password"/><span id="passwordError"><form:errors path="password"/></span> </td>
			</tr>
			<tr>
				<td>FirstName*</td>
				<td><form:input path="firstName" /><span id="firstNameError"><form:errors path="firstName"/></span> </td>
			</tr>
			<tr>
				<td>LastName</td>
				<td><form:input path="lastName" /> </td>
			</tr>
			<tr>
				<td>Email*</td>
				<td><form:input path="email" /><span id="emailError"><form:errors path="email"/></span> </td>
			</tr>
			
			<tr>
				<td>DOB(dd-MM-yyyy)</td>
				<td><form:input path="dob" /> <span id="dobError"><form:errors path="dob"/></span></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" class="btn btn-primary" value="Register"> </td>
			</tr>
      <tr>
        <td>Already Registered?</td>
        <td><a href="login">Login</a> </td>
      </tr>
		</table>
	</form:form>
	
</body>
</html>