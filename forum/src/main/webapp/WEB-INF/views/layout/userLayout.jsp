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
          	<sec:authorize access="hasRole('ROLE_ADMIN')"><li><a href="${rootUrl}admin/home">Administration</a></li></sec:authorize>
            <li class="dropdown">
                  <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                      My Account
                  </a>
                  <ul class="dropdown-menu dropdown-user">
                      <li><a href="${rootUrl}myAccount"><i class="fa fa-user fa-fw"></i>User Profile</a>
                      </li>
                      <li><a href="${rootUrl}changePwd"><i class="fa fa-gear fa-fw"></i>Change Password</a>
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
                 <div class="col-md-10 col-md-offset-1">
                 	<div class="jumbotron">
				        <h1>Welcome to SivaLabs Forum!</h1>
				        <p>A simple forum where you can ask questions or answer others questions.</p>
				      </div>
      
                    <decorator:body/>
                  </div>
          </div>
    </div>
    </div>
</body>
</html>