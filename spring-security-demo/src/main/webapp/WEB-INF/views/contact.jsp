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

$('#submitBtn').click(function(event){
    var email = $.trim($('#email').val());
    var title = $.trim($('#title').val());
    var message = $.trim($('#message').val());
    
    if(email == '' || title == '' || message == '')
    {
   		//alert("Please enter all mandatory fields");
   		//event.preventDefault();
		//return false;
    }
    
    var jsonData = {
    		"email": email,
    		"title": title,
    		"message": message    		
    };
    
	  $.ajax({ 
		    url: "contactUs", 
		    type: 'POST',         
		    dataType: 'json', 
		    data: JSON.stringify(jsonData),
		    contentType: 'application/json',
		    success: function(data) { 
		        if(data.status == true){
              		$('#email').val('');
              		$('#title').val('');
              		$('#message').val('');
		        	alert("Email sent successfully");
              
		        } else {
		        	alert("Error: "+data.message);
		        }
		    },
		    error:function(data,status,er) { 
		        alert("Error: "+er);
		    }
	  });
	  
	});
});

</script>
</head>
<body>
	
	<div class="row">
		<div class="col-md-6 col-md-offset-2">	
			<h2>Contact Us</h2>
			<div id="status"></div>
			<form class="form-horizontal" role="form">
		  <div class="form-group">
		    <label for="email" class="col-sm-2 control-label">Email*</label>
		    <div class="col-sm-10">
		      <input type="email" name="email" class="form-control" id="email" placeholder="Email">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="title" class="col-sm-2 control-label">Title*</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="title" name="title" placeholder="Title">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="title" class="col-sm-2 control-label">Message*</label>
		    <div class="col-sm-10">
		      <textarea class="form-control" rows="3" id="message" name="message"></textarea>
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="button" id="submitBtn" class="btn btn-default">Submit</button>
		    </div>
		  </div>
		</form>
	</div>
</div>

</body>
</html>