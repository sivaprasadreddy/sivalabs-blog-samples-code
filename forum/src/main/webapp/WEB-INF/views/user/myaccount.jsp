<!DOCTYPE html>
<%@include file="../taglib.jsp"%>
<html>
<head>
<title>MyAccount</title>
<script type="text/javascript">
	$(document).ready(function() {

		$("#myAccountForm").submit(function(event) {

			var firstName = $.trim($("#firstName").val());
			var email = $.trim($("#email").val());
			if (firstName == '' || email == '') {
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
		<c:if test="${msg != null }">
			<div class="alert alert-success">
				<p>${msg}
			</div>
		</c:if>
	</div>

	<div class="row">
		<div class="col-md-6 col-md-offset-2">

			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">My Profile</h3>
				</div>
				<div class="panel-body">
					<form:form id="myAccountForm" method="post" action="updateUser"
						modelAttribute="user" cssStyle="width: 800px; margin: 0 auto;"
						class="form-horizontal" role="form">
						<input type="hidden" name="id" value="${user.id}"> 
						<input type="hidden" name="password" value="${user.password}"> 
						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">Email*</label>
							<div class="col-sm-4">
								<input type="text" id="email" name="email" value="${user.email}"
									class="form-control" placeholder="Email" readonly="readonly"/>
								<form:errors path="email" />
							</div>
						</div>
						<div class="form-group">
							<label for="firstName" class="col-sm-2 control-label">FirstName*</label>
							<div class="col-sm-4">
								<input type="text" id="firstName" name="firstName" value="${user.firstName}"
									class="form-control" placeholder="FirstName" />
								<form:errors path="firstName" />
							</div>
						</div>

						<div class="form-group">
							<label for="lastName" class="col-sm-2 control-label">LastName</label>
							<div class="col-sm-4">
								<input type="text" id="lastName" name="lastName" value="${user.lastName}"
									class="form-control" placeholder="LastName" />
								<form:errors path="lastName" />
							</div>
						</div>

						<div class="form-group">
							<label for="dob" class="col-sm-2 control-label">Date Of
								Birth</label>
							<div class="col-sm-4">
								<input type="text" id="dob" name="dob" class="form-control" value="${user.dob}"
									placeholder="yyyy-MM-dd" />
								<form:errors path="dob" cssClass="text-danger" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-4">
								<input type="submit" class="btn btn-primary" value="Save">
							</div>
						</div>
					</form:form>

				</div>
			</div>
		</div>
	</div>


</body>
</html>