<!DOCTYPE html>
<%@include file="../taglib.jsp"%>
<html>
<head>
<title>Administrator</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<h2>Manage Categories</h2>
	
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
              	<c:forEach var="cat" items="${categoriesPage.iterator()}" varStatus="counter">
              		<tr>
	                  <td><a href="#id=${cat.id}">${cat.id}</a> </td>
	                  <td>${cat.name }</td>
	                </tr>
              	</c:forEach>
                
              </tbody>
              <tfoot>
              	<tr>
              		<td colspan="2" align="center">
              		<ul class="pagination" style="margin: 0px;">
              			<c:if test="${categoriesPage.firstPage}">
              				<li class="disabled"><a href="${rootUrl}admin/categories?page=1">&laquo;</a></li>
              			</c:if>
              			<c:if test="${not categoriesPage.firstPage}">
              				<li><a href="${rootUrl}admin/categories?page=1">&laquo;</a></li>
              			</c:if>
              			
              		<c:forEach begin="1" end="${categoriesPage.totalPages}" var="p">
              			 <c:if test="${categoriesPage.number+1 == p }">
              			 	<li class="active"><a href="${rootUrl}admin/categories?page=${p}">${p}</a></li>
              			 </c:if>
				         <c:if test="${categoriesPage.number+1 != p }">
					         <li><a href="${rootUrl}admin/categories?page=${p}">${p}</a></li>
              			 </c:if>
				    </c:forEach>
				    <c:if test="${categoriesPage.lastPage}">
              				<li class="disabled"><a href="${rootUrl}admin/categories?page=${categoriesPage.totalPages}">&raquo;</a></li>
              			</c:if>
              			<c:if test="${not categoriesPage.lastPage}">
              				<li><a href="${rootUrl}admin/categories?page=${categoriesPage.totalPages}">&raquo;</a></li>
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
				<h3 class="panel-title">Create Category</h3>
			</div>
			<div class="panel-body">
				<form role="form" method="post" action="${rootUrl}admin/categories/create">
					<div class="form-group">
						<label for="name">Category Name</label> <input
							type="text" class="form-control" id="name" name="name" placeholder="Enter Name">
					</div>
					<div class="form-group">
						<label for="description">Category Description</label>
						<textarea class="form-control" rows="3" id="description" name="description"></textarea>
					</div>
				
					<button type="submit" class="btn btn-primary">Save</button>
				</form>
			</div>
		</div>
		
	</div>
	
</body>
</html>