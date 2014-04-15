<!DOCTYPE html>
<%@include file="../taglib.jsp" %>
<html>
<head>
<title>Welcome</title>
</head>
<body>
	<h4><a href="${rootUrl}home">Home</a>: ${forum.name} </h4>
	<h5><a href="${rootUrl}topics/new?forumId=${forum.id}">New Topic</a></h5>
	<div class="panel panel-default">
	  <table class="table table-bordered table-striped table-hover">
		<thead>
			<tr class="table-header-row">
				<th >Title</th>
				<th>Replies/Views</th>
				<th>Last Posted By</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="topic" items="${forum.topics}">
				<tr>
					<td><a href="${rootUrl}topics/${topic.id}">${topic.title}</a>
					</td><td>${topic.posts.size() -1}</td>
					<td>${topic.lastPost.createdBy.firstName} ${topic.lastPost.createdBy.lastName}</td>
				</tr>
			</c:forEach>
			
		</tbody>
		
	  </table>
	</div>
	  
</body>
</html>