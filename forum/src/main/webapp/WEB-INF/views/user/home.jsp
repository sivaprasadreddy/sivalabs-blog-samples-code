<!DOCTYPE html>
<%@include file="../taglib.jsp" %>
<html>
<head>
<title>Welcome</title>
</head>
<body>
      
      <c:forEach var="cat" items="${categories}" varStatus="counter">
      <div class="panel panel-primary">
		  <div class="panel-heading">
		    <h3 class="panel-title">${cat.name }</h3>
		  </div>
		  <div class="panel-body">
		  
		  <ul class="list-group">
		  	  <c:forEach var="forum" items="${cat.forums}">
			  <li class="list-group-item">
					<div class="row">
			    	<div class="col-md-8">
			    		<strong><a href="forums/${forum.id}">${forum.name}</a></strong><br/>
			    		<small>${forum.description}</small>
			    	</div>
			    	<div class="col-md-4">
			    		Total Topics: ${forum.topics.size()} <br/>
			    	</div>
			    	</div>
				</li>
				</c:forEach>
			</ul>

		    
		  </div>
	  </div>
	  </c:forEach>
	  
</body>
</html>