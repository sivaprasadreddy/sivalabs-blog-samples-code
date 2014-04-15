<!DOCTYPE html>

<%@ include file="taglib.jsp" %>

<html lang="en" ng-app="usersApp">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SivaLabs : Forum</title>
        <%@ include file="assets.jspf" %>
</head>
<body>

 <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${rootUrl}home">My DashBoard</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
          	
            <li class="dropdown">
                  <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                      My Account
                  </a>
                  <ul class="dropdown-menu dropdown-user">
                      <li><a href="${rootUrl}myAccount"><i class="fa fa-user fa-fw"></i> User Profile</a>
                      </li>
                      <li><a href="${rootUrl}changePwd"><i class="fa fa-gear fa-fw"></i> Settings</a>
                      </li>
                      <li class="divider"></li>
                      <li><a href="${rootUrl}logout">Logout</a>
                      </li>
                  </ul>
                  <!-- /.dropdown-user -->
              </li>
              <li><a href="${rootUrl}logout">Logout</a></li>
          </ul>
          
        </div>
      </div>
    </div>
    
    
    <div class="container">    
                 
          <div class="row">
          	<div class="col-md-3 sidebar">
        
		        <div class="list-group">
				  <span class="list-group-item active">Personal Data</span>
				  <a href="#phonebook" class="list-group-item">PhoneBook</a>
				  <a href="#events" class="list-group-item">Events</a>
				  
				  <span class="list-group-item active">Settings</span>
				  <a href="#" class="list-group-item">Configuration</a>
				  
				</div>

       		 </div>        
             <div class="col-md-9 " ng-controller="UserCtrl">
               
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th width="20px;">Id</th>
								<th width="100px;">FirstName</th>
								<th width="100px;">LastName</th>
								<th width="150px;">Email</th>
								<th width="100px;">Edit / Delete</th>
							</tr>							
						</thead>
						<tbody>
								<tr ng-repeat="user in userList">
									<td>{{user.id}}</td>
									<td>{{user.firstName}}</td>
									<td>{{user.lastName}}</td>
									<td>{{user.email}}</td>
									<td>
										<span style="cursor: pointer;" class="glyphicon glyphicon-pencil" ng-click="handleEditUser(user)"></span>&nbsp;&nbsp;
										<span style="cursor: pointer;" class="glyphicon glyphicon-trash" ng-click="handleDeleteUser(user)"></span>
									</td>
								</tr>
							</tbody>
					</table>
					
					<div class="panel panel-default">
					  <div class="panel-heading">Edit User</div>
					  <div class="panel-body">
					    	
					    	<form class="form-horizontal" role="form">
							  <div class="form-group">
							    <label for="inputId" class="col-sm-2 control-label">Id</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="inputId" placeholder="Id" ng-model="editUser.id">
							    </div>
							  </div>
							  
							  <div class="form-group">
							    <label for="inputFirstName" class="col-sm-2 control-label">FirstName</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="inputFirstName" placeholder="FirstName" ng-model="editUser.firstName">
							    </div>
							  </div>
							  
							  <div class="form-group">
							    <label for="inputLastName" class="col-sm-2 control-label">LastName</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="inputLastName" placeholder="LastName" ng-model="editUser.lastName">
							    </div>
							  </div>
							  
							  <div class="form-group">
							    <label for="inputEmail" class="col-sm-2 control-label">Email</label>
							    <div class="col-sm-10">
							      <input type="email" class="form-control" id="inputEmail" placeholder="Email" ng-model="editUser.email">
							    </div>
							  </div>
							  
							  <div class="form-group">
							    <div class="col-sm-offset-2 col-sm-10">
							      <button type="submit" class="btn btn-default" ng-click="handleUpdateUser(editUser)">Save</button>
							    </div>
							  </div>
							</form>

					  </div>
					</div>
             </div>
          </div>
    	</div>
   
</body>
</html>