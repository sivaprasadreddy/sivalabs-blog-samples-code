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

<div class="navbar navbar-inverse navbar-fixed-top " role="navigation">
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
            <li><a href="admin.jsp">Administration</a></li>
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

     <div class="container" role="main">

      <div class="jumbotron">
        <h1>Welcome to SivaLabs Forum!</h1>
        <p>A simple forum where you can ask questions or answer others questions.</p>
      </div>
      
      <div class="panel panel-primary">
		  <div class="panel-heading">
		    <h3 class="panel-title">Category 1</h3>
		  </div>
		  <div class="panel-body">
		  
		  <ul class="list-group">
			  <li class="list-group-item">
					<div class="row">
			    	<div class="col-md-8">
			    		<strong><a href="#">Forum Title</a></strong><br/>
			    		<small>Forum description goes here</small>
			    	</div>
			    	<div class="col-md-4">
			    		Forum Statistics
			    	</div>
			    	</div>
				</li>
				
				<li class="list-group-item">
					<div class="row">
			    	<div class="col-md-8">
			    		<strong><a href="#">Forum Title</a></strong><br/>
			    		<small>Forum description goes here</small>
			    	</div>
			    	<div class="col-md-4">
			    		Forum Statistics
			    	</div>
			    	</div>
				</li>
			</ul>

		    
		  </div>
	  </div>
	  
	  <div class="panel panel-primary">
		  <div class="panel-heading">
		    <h3 class="panel-title">Category 2</h3>
		  </div>
		  <div class="panel-body">
		  
		  <ul class="list-group">
			  <li class="list-group-item">
					<div class="row">
			    	<div class="col-md-8">
			    		<strong><a href="#">Forum Title</a></strong><br/>
			    		<small>Forum description goes here</small>
			    	</div>
			    	<div class="col-md-4">
			    		Forum Statistics
			    	</div>
			    	</div>
				</li>
				
				<li class="list-group-item">
					<div class="row">
			    	<div class="col-md-8">
			    		<strong><a href="#">Forum Title</a></strong><br/>
			    		<small>Forum description goes here</small>
			    	</div>
			    	<div class="col-md-4">
			    		Forum Statistics
			    	</div>
			    	</div>
				</li>
			</ul>

		    
		  </div>
	  </div>
	  <div class="panel panel-default">
	  <table class="table table-bordered table-striped table-hover">
		<thead>
			<tr class="table-header-row">
				<th >Title</th><th>Replies/Views</th><th>Last Posted By</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Topic1 title</td><td>1002</td><td>Siva</td>
			</tr>
			<tr>
				<td>Topic1 title</td><td>1002</td><td>Siva</td>
			</tr>
			<tr>
				<td>Topic1 title</td><td>1002</td><td>Siva</td>
			</tr>
			<tr>
				<td>Topic1 title</td><td>1002</td><td>Siva</td>
			</tr>
		</tbody>
		
	  </table>
	</div>
	
	<div>
		<ul class="pagination ">
		  <li class="disabled"><a href="#">&laquo;</a></li>
		  <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
		  <li><a href="#">2</a></li>
		  <li><a href="#">3</a></li>
		  <li><a href="#">4</a></li>
		  <li><a href="#">5</a></li>
		  <li><a href="#">&raquo;</a></li>
		</ul>
	</div>
	  
	  <div class="panel panel-primary">
	  	 <div class="panel-heading">
		    <h3 class="panel-title">Topic Title</h3>
		  </div>
		  <div class="panel-body list-group">
		  <div class="row list-group-item" >
			  <div class="col-md-2">
			    <strong>Siva Prasad</strong><br/>
			    <img alt="Siva" src="resources/images/user.jpg" width="80px;"><br/>
			    <strong>Posts: 2310</strong>
			  </div>
			  <div class="col-md-10">
			  	<strong>Post Title</strong><br/>
			  	<p>
			  		Hi,
					I have devloped a RESTful webservice using Spring boot.The next thing i want to do is add Spring security to my webservice.I can't get the security working. Could you please tell me how if I had to implement a basic security feature, username and password in the request header which i want it to get authenticated by AuthenticationManager?
			  	</p>
			  </div>
		  </div>
		  
		  
		  <div class="row list-group-item">
			  <div class="col-md-2">
			    <strong>Siva Prasad</strong><br/>
			    <img alt="Siva" src="resources/images/user.jpg" width="80px;"><br/>
			    <strong>Posts: 2310</strong>
			  </div>
			  <div class="col-md-10">
			  	<strong>Post Title</strong><br/>
			  	<p>
			  		Hi,
					I have devloped a RESTful webservice using Spring boot.The next thing i want to do is add Spring security to my webservice.I can't get the security working. Could you please tell me how if I had to implement a basic security feature, username and password in the request header which i want it to get authenticated by AuthenticationManager?
			  	</p>
			  </div>
		  </div>
		  
		  <div class="row list-group-item">
			  <div class="col-md-2">
			    <strong>Siva Prasad</strong><br/>
			    <img alt="Siva" src="resources/images/user.jpg" width="80px;"><br/>
			    <strong>Posts: 2310</strong>
			  </div>
			  <div class="col-md-10">
			  	<strong>Post Title</strong><br/>
			  	<p>
			  		Hi,
					I have devloped a RESTful webservice using Spring boot.The next thing i want to do is add Spring security to my webservice.I can't get the security working. Could you please tell me how if I had to implement a basic security feature, username and password in the request header which i want it to get authenticated by AuthenticationManager?
			  	</p>
			  </div>
		  </div>
		  </div>
		  
		</div>
	  
	  	<form role="form">
	  	<div class="form-group">
	  		<textarea class="form-control" rows="3" placeholder="Enter comment"></textarea>
	  	</div>
	  	<button type="button" class="btn btn-primary">Submit</button>
	  	</form>
	  	
	  	
	  	<form role="form">
		  <div class="form-group">
		    <label for="exampleInputEmail1">Title</label>
		    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter title">
		  </div>
		  <div class="form-group">
		    <textarea class="form-control" rows="10" placeholder="Enter text"></textarea>
		  </div>
		  <div class="form-group">
		    <label for="exampleInputFile">File input</label>
		    <input type="file" id="exampleInputFile">
		    <p class="help-block">Example block-level help text here.</p>
		  </div>
		  
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>
    
	
</body>
</html>