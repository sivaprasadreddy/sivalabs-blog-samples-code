<!DOCTYPE html>

<%@ include file="../taglib.jsp" %>

<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SivaLabs : Forum</title>
        <%@ include file="../fragments/assets.jspf" %>
        <decorator:head/>        
</head>
<body>

 <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${rootUrl}home">SivaLabs Forum</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
          	<li><a href="${rootUrl}home">Forum Home</a></li>
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
    
    <div style="padding: 0 15px;">
    <div class="container-fluid">    
                 
          <div class="row">
          	<div class="col-md-3 sidebar">
        
		        <div class="list-group">
				  <a href="#" class="list-group-item active">Administration</a>
				  <a href="${rootUrl}admin/categories" class="list-group-item">Categories</a>
				  <a href="${rootUrl}admin/forums" class="list-group-item">Forums</a>
				  
				  <a href="#" class="list-group-item active">Settings</a>
				  <a href="${rootUrl}admin/configuration" class="list-group-item">Configuration</a>
				  
				</div>

       		 </div>
        
                  <div class="col-md-9 col-md-offset-3">
                    <decorator:body/>
                  </div>
          </div>
    	</div>
    </div>
</body>
</html>