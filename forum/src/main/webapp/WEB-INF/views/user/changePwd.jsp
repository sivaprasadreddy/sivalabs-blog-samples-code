<!DOCTYPE html>
<%@include file="../taglib.jsp"%>
<html>
<head>
<title>MyAccount</title>
<script type="text/javascript">
	$(document).ready(function() {

		$("#changePwdForm").submit(function(event) {

			var oldPwd = $.trim($("#oldPwd").val());
			var newPwd = $.trim($("#newPwd").val());
			var confPwd = $.trim($("#confPwd").val());
			if (oldPwd == '' || newPwd == '' || confPwd == '') {
				alert("Please enter all mandatory fields");
				event.preventDefault();
				return false;
			}
			if(newPwd !== confPwd){
				alert("New Password and Confirm Password are not matching");
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
					<h3 class="panel-title">Change Password</h3>
				</div>
				<div class="panel-body">
					<form:form id="changePwdForm" method="post" action="changePwd"
						modelAttribute="changePwdBean" cssStyle="width: 800px; margin: 0 auto;"
						class="form-horizontal" role="form">
						<input type="hidden" name="email" value="${changePwdBean.email}"> 
						
						 <div class="form-group">
						    <label for="password" class="col-sm-2 control-label">Old Password*</label>
						    <div class="col-sm-4">
						      <input type="password" id="oldPwd" name="oldPwd" class="form-control" placeholder="Old Password" />
						    </div>
						  </div>
						  
						   <div class="form-group">
						    <label for="password" class="col-sm-2 control-label">New Password*</label>
						    <div class="col-sm-4">
						      <input type="password" id="newPwd" name="newPwd" class="form-control" placeholder="New Password" />
						    </div>
						  </div>
						   <div class="form-group">
						    <label for="password" class="col-sm-2 control-label">Confirm Password*</label>
						    <div class="col-sm-4">
						      <input type="password" id="confPwd" name="confPwd" class="form-control" placeholder="Confirm Password" />
						    </div>
						  </div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-4">
								<input type="submit" class="btn btn-primary" value="Change Password">
							</div>
						</div>
					</form:form>

				</div>
			</div>
		</div>
	</div>


</body>
</html>