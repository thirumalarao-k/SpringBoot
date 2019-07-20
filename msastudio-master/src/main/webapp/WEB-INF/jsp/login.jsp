<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

 <style>
.navbar {
  background-color: #59b668;
}
.navbar .navbar-brand {
  color: #ecf0f1;
}
.navbar-inverse .navbar-nav>li>a {
    color:#ecf0f1;
}
.navbar-inverse .navbar-nav>.open>a, .navbar-inverse .navbar-nav>.open>a:focus, .navbar-inverse .navbar-nav>.open>a:hover {
    color: #fff;
    background-color: green;
}
.login-panel {   
       margin-top: 150px; 
}
.error-text {
	color: red;
	font-weight: bold;
} 
.success-text {
	color: green;
	font-weight: bold;
} 
   
</style>   
<body>   
<nav class="navbar navbar-inverse" >
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">MSA Studio</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav navbar-right">
         <li><a href="registration"><span class="glyphicon glyphicon-user" ></span> Sign Up</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">Sign In</h3>
				</div>
				<div class="panel-body">
					<form role="form" method="post" action="login">
						<p>
							<span class="success-text">${message}</span>
						</p>
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="username"
									name="username" id="username" type="text" autofocus>
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Password"
									name="password" id="password" type="password" value="">
							</div>
							<p>
								<span class="error-text">${error}</span>
							</p>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input
								class="btn btn-lg btn-success btn-block" type="submit"
								value="login" name="login">
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>    
</html>   