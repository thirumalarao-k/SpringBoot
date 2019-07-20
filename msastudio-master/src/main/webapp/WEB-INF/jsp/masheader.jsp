<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en"  ng-app="app">
<head>
  <title>MSA Studio</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link href="css/bootstrap.css" rel="stylesheet">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.js"></script>
  <script src="js/jquery.dataTables.min.js"></script>
  
  <link href="css/jquery.dataTables.min-1.10.16.css" rel="stylesheet">

<style>
.navbar {
	background-color: #59b668;
	border-radius: 0px;
	border-color: #59b668;
}

.navbar .navbar-brand {
	color: #ecf0f1;
}

.navbar-inverse .navbar-nav>li>a {
	color: #ecf0f1;
}

.navbar-inverse .navbar-nav>.open>a, .navbar-inverse .navbar-nav>.open>a:focus,
	.navbar-inverse .navbar-nav>.open>a:hover {
	color: #fff;
	background-color: green;
}

.form-horizontal .control-label {
	text-align: left;
}

.bar {
	fill: steelblue;
}

.bar:hover {
	fill: brown;
}

.axis {
	font: 10px sans-serif;
}

.axis path, .axis line {
	fill: none;
	stroke: #000;
	shape-rendering: crispEdges;
}

table {
	margin: 0 auto;
	width: 100%;
	clear: both;
	border-collapse: collapse;
	table-layout: fixed;
	word-wrap: break-word;
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
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#example')
								.DataTable(
										{
											dom : "<'row'<'col-sm-2'l><'col-sm-4'f><'col-sm-6'p>>"
													+ "<'row'<'col-sm-12'tr>>"
													+ "<'row'<'col-sm-5'i><'col-sm-7'p>>",
											"scrollY" : 360,
											"scrollX" : false
										});
						 $('a[data-toggle="tab"]').on( 'shown.bs.tab', function (e) {
						        $.fn.dataTable.tables( {visible: true, api: true} ).columns.adjust();
						    } );
					});
</script>


 <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-touch.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-animate.js"></script>
   <script src="http://ui-grid.info/docs/grunt-scripts/csv.js"></script>
    <script src="http://ui-grid.info/docs/grunt-scripts/pdfmake.js"></script>
    <script src="http://ui-grid.info/docs/grunt-scripts/vfs_fonts.js"></script>
    <script src="http://ui-grid.info/docs/grunt-scripts/lodash.min.js"></script>
    <script src="http://ui-grid.info/docs/grunt-scripts/jszip.min.js"></script>
    <script src="http://ui-grid.info/docs/grunt-scripts/excel-builder.dist.js"></script>
    <script src="http://ui-grid.info/release/ui-grid.js"></script>
    <link rel="stylesheet" href="http://ui-grid.info/release/ui-grid.css" type="text/css">
	<script src="http://ui-grid.info/release/ui-grid.pagination.min.js"></script>
    <link rel="stylesheet" href="http://ui-grid.info/release/ui-grid.css" type="text/css">
    
</head>
<body>

<nav class="navbar navbar-inverse" style="margin-bottom:0px;">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand"  href="#">MSA Studio</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav" >
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" >Code Analysis<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<c:out value='${pageContext.servletContext.contextPath}' />/analyseMicroService">Analyse Code</a></li>
            <!-- li><a href="#"/>Generate Service</a></li> -->
          </ul>
        </li>
		<li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" >Analysis Status<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<c:out value='${pageContext.servletContext.contextPath}' />/scheduledjob">Scheduled Jobs</a></li>
		    <li><a href="<c:out value='${pageContext.servletContext.contextPath}' />/completedjob">Completed Jobs</a></li>
          </ul>
        </li>
         <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" >Reports<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<c:out value='${pageContext.servletContext.contextPath}' />/microservice">Micro Service Analysis Report</a></li>
            <li><a href="<c:out value='${pageContext.servletContext.contextPath}' />/sessioninfo">Session Detail Analysis Report</a></li>
            <li><a href="<c:out value='${pageContext.servletContext.contextPath}' />/datamodel">Data Model Analysis Report</a></li>
            <li><a href="<c:out value='${pageContext.servletContext.contextPath}' />/transactioninfo">Transactional Boundaries Analysis Report</a></li>
	        <li><a href="<c:out value='${pageContext.servletContext.contextPath}' />/objectreference">Object References  Analysis Report</a></li>
	        <li><a href="<c:out value='${pageContext.servletContext.contextPath}' />/integrationpoint">Integration Points Analysis Report</a></li>
			<li><a href="<c:out value='${pageContext.servletContext.contextPath}' />/dependency">Dependency Analysis Report</a></li>
  			<li><a href="<c:out value='${pageContext.servletContext.contextPath}' />/vulnerability">Vulnerability Analysis Report</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#" ><span class="glyphicon glyphicon-user" ></span> Welcome 
        <b>
        <c:if test="${not empty loggedInUser}">
        ${fn:toUpperCase(loggedInUser)}
        </c:if></b>
        </a></li>
        <li><a href="<c:out value='${pageContext.servletContext.contextPath}' />/login" ><span class="glyphicon glyphicon-log-in" ></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>