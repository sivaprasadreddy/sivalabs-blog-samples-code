<!DOCTYPE html>
<%@include file="taglib.jsp" %>
<html>
<head>
<title>Welcome</title>
<script type="text/javascript">
	$(document).ready(function() {
	
		
	});
</script>
</head>
<body>

<div class="row">

	<div class="col-md-4">
     
     <form action="messages" method="post" class="form-horizontal" role="form">
       <div class="form-group">
         <label class="sr-only" for="exampleInputEmail2">Message</label>
         <textarea id="tweetMsg" name="text" class="form-control" rows="10" cols="50" style="width: 400px" maxlength="500"></textarea>
       </div>
       <button id="postBtn" type="submit" class="btn btn-default">Submit</button>
     </form>
     
  </div>         
   <div class="col-md-8">    
      	<table id="tweetsTbl" class="table table-bordered">
      		<thead>
      			<tr class="success">
      				<th>Message</th>
      				<th>Posted By</th>
      				<sec:authorize access="hasRole('ROLE_ADMIN')"><th>Delete</th></sec:authorize> 
      			</tr>
      		</thead>
      		<tbody>
             
      			<c:forEach var="msg" items="${messages}">
      				<tr>
      					<td>${msg.text}</td>
      					<td>${msg.postedBy.userName}</td>
      					<sec:authorize access="hasRole('ROLE_ADMIN')"><td>Delete</td></sec:authorize>
      				</tr>
      			</c:forEach>
             
      		</tbody>
      	</table>
    </div>
    </div>
    
</body>
</html>