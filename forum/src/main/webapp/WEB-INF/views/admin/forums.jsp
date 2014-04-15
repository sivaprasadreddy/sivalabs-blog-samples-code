<!DOCTYPE html>
<%@include file="../taglib.jsp" %>
<html>
<head>
<title>Administrator</title>
<script type="text/javascript">

</script>
</head>
<body>
	<h2>Manage Forums</h2>
	
		<div class="col-md-10">
		
          <div class="panel panel-default">
	  		<table class="table table-bordered table-striped table-hover">
              <thead>
                <tr class="table-header-row">
                  <th>ID</th>
                  <th>Name</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach var="forum" items="${forumsPage.iterator()}" varStatus="counter">
              		<tr>
	                  <td><a href="#id=${forum.id}">${forum.id}</a> </td>
	                  <td>${forum.name }</td>
	                </tr>
              	</c:forEach>
                
              </tbody>
              <tfoot>
              	<tr>
              		<td colspan="2" align="center">
              		<ul class="pagination" style="margin: 0px;">
              			<c:if test="${forumsPage.firstPage}">
              				<li class="disabled"><a href="${rootUrl}admin/forums?page=1">&laquo;</a></li>
              			</c:if>
              			<c:if test="${not forumsPage.firstPage}">
              				<li><a href="${rootUrl}admin/forums?page=1">&laquo;</a></li>
              			</c:if>
              			
              		<c:forEach begin="1" end="${forumsPage.totalPages}" var="p">
				         
				         <c:if test="${forumsPage.number+1 == p }">
              			 	<li class="active"><a href="${rootUrl}admin/forums?page=${p}">${p}</a></li>
              			 </c:if>
				         <c:if test="${forumsPage.number+1 != p }">
					         <li><a href="${rootUrl}admin/forums?page=${p}">${p}</a></li>
              			 </c:if>
              			 
				    </c:forEach>
				    <c:if test="${forumsPage.lastPage}">
              				<li class="disabled"><a href="${rootUrl}admin/forums?page=${forumsPage.totalPages}">&raquo;</a></li>
              			</c:if>
              			<c:if test="${not forumsPage.lastPage}">
              				<li><a href="${rootUrl}admin/forums?page=${forumsPage.totalPages}">&raquo;</a></li>
              			</c:if>
				    </ul>
				    
              		 </td>
              	</tr>
              </tfoot>
            </table>
          </div>
          </div>
          
          <div class="col-md-8">
		<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Create Forum</h3>
			</div>
			<div class="panel-body">
				<form role="form" method="post" action="${rootUrl}admin/forums/create">
					<div class="form-group">
						<label for="name">Forum Name</label> <input
							type="text" class="form-control" id="name" name="name" placeholder="Enter Name">
					</div>
					<div class="form-group">
						<label for="description">Forum Description</label>
						<textarea class="form-control" rows="3" id="description" name="description"></textarea>
					</div>
					<div class="form-group">
					    <label for="exampleInputEmail1">Category</label>
					    <select class="form-control" name="category.id">
					    	<c:forEach var="cat" items="${categories}" varStatus="counter">
					    		<option label="${cat.name}" value="${cat.id}"/>
					    	</c:forEach>
						</select>
					  </div>
					<button type="submit" class="btn btn-primary">Save</button>
				</form>
			</div>
		</div>
		
	</div>
          
</body>
</html>