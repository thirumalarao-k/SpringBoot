<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>MAS Studio</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="resources/static/css/common.css" rel="stylesheet">
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
						<h3 class="panel-title">Create your Account</h3>
					</div>

					<div class="panel-body">
						<form:form method="POST" modelAttribute="userForm"
							action="registration" class="form-signin">
							<spring:bind path="username">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input type="text" path="username" class="form-control"
										placeholder="Username" autofocus="true"></form:input>
									<form:errors cssClass="error-text" path="username"></form:errors>
								</div>
							</spring:bind>

							<spring:bind path="password">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input type="password" path="password"
										class="form-control" placeholder="Password"></form:input>
									<form:errors cssClass="error-text" path="password"></form:errors>
								</div>
							</spring:bind>

							<spring:bind path="passwordConfirm">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<form:input type="password" path="passwordConfirm"
										class="form-control" placeholder="Confirm your password"></form:input>
									<form:errors cssClass="error-text" path="passwordConfirm"></form:errors>
								</div>
							</spring:bind>

							<button class="btn btn-lg btn-success btn-block" type="submit">Submit</button>
						</form:form>
					</div>
				</div>
				<div style="text-align: center;">
					Already registered? <a href="${pageContext.request.contextPath}/login">Login</a>
				</div>
			</div>
		</div>
	</div>
</body>    
</html>   