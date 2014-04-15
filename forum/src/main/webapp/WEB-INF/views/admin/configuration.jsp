<!DOCTYPE html>
<%@include file="../taglib.jsp"%>
<html>
<head>
<title>Administrator</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<h2>Manage Configuration</h2>
	
		<div class="col-md-10">
		
          <div class="panel panel-default">
	  		<table class="table table-bordered table-striped table-hover">
              <thead>
                <tr class="table-header-row">
                  <th>ID</th>
                  <th>Name</th>
                  <th>Value</th>
                  <th>Description</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach var="configParam" items="${configParameters}" varStatus="counter">
              		<tr>
	                  <td><a href="#id=${configParam.id}">${configParam.id}</a> </td>
	                  <td>${configParam.name }</td>
	                  <td>${configParam.value }</td>
	                  <td>${configParam.description }</td>
	                </tr>
              	</c:forEach>
                
              </tbody>
              
              
            </table>
          </div>
          </div>
	 
	
	<div class="col-md-8">
		<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Create Configuration Parameter</h3>
			</div>
			<div class="panel-body">
				<form role="form" method="post" action="${rootUrl}admin/configuration/create">
					<div class="form-group">
						<label for="name">Name</label> <input
							type="text" class="form-control" id="name" name="name" placeholder="Enter Name">
					</div>
					<div class="form-group">
						<label for="name">Value</label> <input
							type="text" class="form-control" id="value" name="value" placeholder="Enter Value">
					</div>
					<div class="form-group">
						<label for="description">Description</label>
						<textarea class="form-control" rows="3" id="description" name="description"></textarea>
					</div>
				
					<button type="submit" class="btn btn-primary">Save</button>
				</form>
			</div>
		</div>
		
	</div>
	 
</body>
</html>