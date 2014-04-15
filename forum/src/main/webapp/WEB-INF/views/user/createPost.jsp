<!DOCTYPE html>
<%@include file="../taglib.jsp" %>
<html>
<head>
<title>Welcome</title>
</head>
<body>
	<h4><a href="${rootUrl}home">Home</a>: <a href="${rootUrl}forums/${post.topic.forum.id}">${post.topic.forum.name}</a> </h4>
	<h5>Topic: <a href="${rootUrl}topics/${post.topic.id}">${post.topic.title}</a> </h5>
		
	<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Post Reply</h3>
			</div>
			<div class="panel-body">
				<form role="form" method="post" action="${rootUrl}topics/${post.topic.id}/postReply">
					<div class="form-group">
						<label for="title">Title</label> 
						<input type="text" class="form-control" id="title" name="title" placeholder="Enter Title"
						value="${POST.title}">
					</div>
					<div class="form-group">
						<label for="content">Content</label>
						<textarea class="form-control" rows="3" id="content" name="content"></textarea>
					</div>
					<button type="submit" class="btn btn-primary">Save</button>
				</form>
			</div>
		</div>
		
	
	<div class="panel panel-primary">
	  	 <div class="panel-heading">
		    <h3 class="panel-title">${post.topic.title}</h3>
		  </div>
		  <div class="panel-body list-group">
		  <c:forEach var="post" items="${post.topic.posts}">
		  
		  
		  <div class="row list-group-item" >
			  <div class="col-md-2">
			    <strong>${post.createdBy.firstName} ${post.createdBy.lastName}</strong><br/>
			    <img title="${post.createdBy.email}" src="${rootUrl}resources/images/user.jpg" width="80px;"><br/>
			    <strong>Posts: 2310</strong>
			  </div>
			  <div class="col-md-10">
			  	<strong>${post.title }</strong><br/>
			  	<p>
			  		${post.content }
			  	</p>
			  </div>
		  </div>
		  </c:forEach>
		  
		  </div>
		  
		</div>
	
      
	  
</body>
</html>