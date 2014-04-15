<!DOCTYPE html>
<html>
<head>
	<title>Welcome</title>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="resources/bootstrap-3.1.0/css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="resources/jquery/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="resources/bootstrap-3.1.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/app.js"></script>
	<link href="resources/css/styles.css" rel="stylesheet">
	
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
          <a class="navbar-brand" href="#">SivaLabs Forum</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="index.jsp">Home</a></li>
            <li><a href="#">Settings</a></li>
            <li class="dropdown">
                  <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                      Profile
                  </a>
                  <ul class="dropdown-menu dropdown-user">
                      <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                      </li>
                      <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                      </li>
                      <li class="divider"></li>
                      <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                      </li>
                  </ul>
                  <!-- /.dropdown-user -->
              </li>
            
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row">
      
      	
        <div class="col-md-2 sidebar">
        
	        <div class="list-group">
			  <a href="#" class="list-group-item active">Administration</a>
			  <a href="#" class="list-group-item">Categories</a>
			  <a href="#" class="list-group-item">Forums</a>
			  <a href="#" class="list-group-item">Tags</a>
			  <a href="#" class="list-group-item active">Settings</a>
			  <a href="#" class="list-group-item">Email</a>
			  <a href="#" class="list-group-item">Cache</a>
			  <a href="#" class="list-group-item">Logging</a>
			  
			</div>

        </div>
        
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2">
          
          <h2 class="sub-header">Forums</h2>
          <div class="panel panel-default">
	  		<table class="table table-bordered table-striped table-hover">
              <thead>
                <tr class="table-header-row">
                  <th>#</th>
                  <th>Header</th>
                  <th>Header</th>
                  <th>Header</th>
                  <th>Header</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1,001</td>
                  <td>Siva</td>
                  <td>admin</td>
                  <td>admin@gmail.com</td>
                  <td>Active</td>
                </tr>
                <tr>
                  <td>1,001</td>
                  <td>Siva</td>
                  <td>admin</td>
                  <td>admin@gmail.com</td>
                  <td>Active</td>
                </tr>
                <tr>
                  <td>1,001</td>
                  <td>Siva</td>
                  <td>admin</td>
                  <td>admin@gmail.com</td>
                  <td>Active</td>
                </tr>
                <tr>
                  <td>1,001</td>
                  <td>Siva</td>
                  <td>admin</td>
                  <td>admin@gmail.com</td>
                  <td>Active</td>
                </tr>
              </tbody>
            </table>
          </div>
        
        <div class="col-md-6">
        <div class="panel panel-primary ">
        <div class="panel-heading">
		    <h3 class="panel-title">Category 2</h3>
		  </div>
		  <div class="panel-body">
		  
        <form role="form">
		  <div class="form-group">
		    <label for="exampleInputEmail1">Category Name</label>
		    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter Name">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputEmail1">Category Description</label>
		    <textarea class="form-control" rows="3"></textarea>
		  </div>
		  <div class="form-group">
		    <label for="exampleInputEmail1">Parent</label>
		    <select class="form-control">
			  <option>1</option>
			  <option>2</option>
			  <option>3</option>
			  <option>4</option>
			  <option>5</option>
			</select>
		  </div>
		  
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
		</div>
		</div>
		</div>
		
        </div>
      </div>
    </div>
    
	
</body>
</html>