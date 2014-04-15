<!DOCTYPE html>
<%@include file="taglib.jsp" %>
<html ng-app="myApp">
<head>
<title>DashBoard</title>
<base href="${rootUrl}"/>

<script type="text/javascript" src="resources/jquery/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css"/>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap-theme.min.css"/>
<script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/angularjs/angular.js"></script>
<link rel="stylesheet" href="resources/css/styles.css"/>
<script type="text/javascript" src="resources/js/app.js"></script>

</head>
<body ng-controller="UserController">
	
 <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="home">DashBoard</a>
        </div>
        
      </div>
    </div>
    
     <div style="padding: 0 15px;">
    <div class="container-fluid">    
                 
          <div class="row">
          	<div class="col-md-3 sidebar">
        
		        <div class="list-group">
				  <a href="#" class="list-group-item active">Administration</a>
				  <a href="#users" class="list-group-item">Users</a>
				  <a href="#roles" class="list-group-item">Roles</a>
				  <!-- 
				  <a href="#" class="list-group-item active">Settings</a>
				  <a href="admin/configuration" class="list-group-item">Configuration</a>
				   -->
				  
				</div>

       		 </div>
        
             <div class="col-md-9 col-md-offset-3">
             <br/>
             	<form role="form" class="col-md-6">
	             	<div class="input-group">
				      <input type="text" class="form-control" placeholder="Search Users" ng-model="query">
				      <span class="input-group-btn">
				        <button class="btn btn-default" type="button" ng-click="searchUsers()">Search</button>&nbsp;&nbsp;
				        <button type="button" class="btn btn-primary" ng-click="newUserForm()">New User</button>
				      </span>
				    </div>
				</form>
               <br/> <br/>
               
               <table class="table table-striped table-bordered table-hover">
               		<thead>
               			<tr>
               			<th>Id</th>
               			<th>Name</th>
               			<th>Email</th>
               			<th></th>
               			</tr>
               		</thead>
               		<tbody>
               			<tr ng-repeat="user in users">
               				<td>{{user.id}}</td>
               				<td>{{user.name}}</td>
               				<td>{{user.email}}</td>
               				<td>
               					<button type="button" class="btn btn-primary" ng-click="editUserForm(user.id)">Edit</button>&nbsp;&nbsp;
               					<button type="button" class="btn btn-danger" ng-click="deleteUser(user.id)">Delete</button>
               				</td>
               			</tr>
               		</tbody>
               </table>
               
               <br/>
               
               <div class="panel panel-primary" ng-show="newUser">
               	  <div class="panel-heading">New User Form</div>
				  <div class="panel-body">
				    
				    <form role="form" name="new_user_form">			    
					  
					  <div class="form-group">
					    <label for="name">Name</label>
					    <input type="text" class="form-control" id="name" ng-model="newUser.name"
					    >
					  </div>
					  <div class="form-group">
					    <label for="email">Email</label>
					    <input type="text" class="form-control" id="email" ng-model="newUser.email"
					    >
					  </div>
					  <div class="form-group">
					    <label for="password">Password</label>
					    <input type="password" class="form-control" id="password" ng-model="newUser.password" 
					    >
					  </div>
					</form>
				  </div>
				  <div class="panel-footer">
				  		<button type="button" class="btn btn-primary" ng-click="createUser()">Save</button>&nbsp;&nbsp;
				  </div>
				</div>
				
                <div class="panel panel-primary" ng-show="currentUser">
               	  <div class="panel-heading">Edit User</div>
				  <div class="panel-body">
				    
				    <form role="form" name="edit_user_form">
				    
					  <div class="form-group">
					    <label for="userId">Id</label>
					    <input type="text" class="form-control" id="userId" ng-model="currentUser.id" ng-readonly="true"
					    placeholder="UserId">
					  </div>
					  <div class="form-group">
					    <label for="name">Name</label>
					    <input type="text" class="form-control" id="name" ng-model="currentUser.name"
					   	>
					  </div>
					  <div class="form-group">
					    <label for="email">Email</label>
					    <input type="text" class="form-control" id="email" ng-model="currentUser.email"
					    >
					  </div>
					  <div class="form-group">
					    <label for="password">Password</label>
					    <input type="password" class="form-control" id="password" ng-model="currentUser.password" 
					    >
					  </div>
					</form>
				  </div>
				  <div class="panel-footer">
				  		<button type="button" class="btn btn-primary" ng-click="updateUser()">Save</button>&nbsp;&nbsp;
               			<button type="button" class="btn btn-danger" ng-click="deleteUser(currentUser.id)">Delete</button>
				  </div>
				</div>
               
             </div>
          </div>
    	</div>
    </div>
    
    
</body>
</html>