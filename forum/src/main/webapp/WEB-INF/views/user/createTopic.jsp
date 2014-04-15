<!DOCTYPE html>
<%@include file="../taglib.jsp" %>
<html>
<head>
<title>Welcome</title>
</head>
<body>
	<h4><a href="${rootUrl}home">Home</a>: <a href="${rootUrl}forums/${topic.forum.id}">${topic.forum.name}</a> </h4>
	<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Create Topic</h3>
			</div>
			<div class="panel-body">
				<form role="form" method="post" action="${rootUrl}topics/create">
					<div class="form-group">
						<label for="title">Title</label> 
						<input type="text" class="form-control" id="title" name="title" placeholder="Enter Title">
					</div>
					<div class="form-group">
						<label for="content">Content</label>
						<textarea class="form-control" rows="3" id="content" name="content"></textarea>
					</div>
					<input type="hidden" name="topic.forum.id" value="${topic.forum.id}">
					<button type="submit" class="btn btn-primary">Save</button>
				</form>
			</div>
		</div>
		
	
      
	  
</body>
</html>