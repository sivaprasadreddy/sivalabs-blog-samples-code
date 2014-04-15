<!DOCTYPE html>
<%@include file="../taglib.jsp"%>
<html>
<head>
<title>Welcome</title>
</head>
<body>
	<h4>
		<a href="${rootUrl}home">Home</a>: <a href="${rootUrl}forums/${topic.forum.id}">${topic.forum.name}</a>
	</h4>
	<h5>
		Topic: <a href="${rootUrl}topics/${topic.id}">${topic.title}</a>
	</h5>
	<h5>
		<a href="${rootUrl}topics/${topic.id}/reply">Post Reply</a>
	</h5>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">${topic.title}</h3>
		</div>
		<div class="panel-body list-group">
			<c:forEach var="post" items="${topic.posts}">
				<div class="row list-group-item">
					<div class="col-md-2">
						<strong>${post.createdBy.firstName}
							${post.createdBy.lastName}</strong><br /> <img
							title="${post.createdBy.email}"
							src="${rootUrl}resources/images/user.jpg" width="80px;"><br />
						<strong>Posts: 2310</strong>
					</div>
					<div class="col-md-10">
						<strong>${post.title }</strong><br />
						<p>${post.content }</p>
					</div>
				</div>
			</c:forEach>

		</div>

	</div>



</body>
</html>