<%@ include file="masheader.jsp" %>  

<head>
<style type="text/css">
  .table {
    border-radius: 5px;
    width: 50%;
    margin: 0px auto;
    float: none;
}
</style>   

<script type="text/javascript">

function chooseProject(projects) {
		var projectId = projects.value;
		document.location = "microservice/" +projectId;
		return true;
}

</script>
</head>
<p>&nbsp;  </p>
<p>&nbsp;  </p>
<p>&nbsp;  </p>

<table width="500" border="0" align="center" cellpadding="0" cellspacing="0">
      <tbody>
         <tr>
            <td colspan="2" align="center">
			<div class="panel panel-success">
      <div class="panel-heading"><Strong>Micro Service Analysis Report</Strong></div>
    </div>
				<form method="post" action="<c:out value='${pageContext.servletContext.contextPath}' />/microserviceReport" name="microservice">
				<div class="form-group">
				    <label for="projectname" class="col-xs-5">Project Name</label>
				 </div>   
					 
				<div class="col-xs-6">
					  					
					<select name="projectId" class="breadcrumb" id="projectId"  onChange='window.location="microservice/projectId=" + this.value;'>
							<option value='' selected="selected">--Choose Projects--</option>
								<c:forEach var="project" items="${projects}">
										<option value="${project.projectId}">${project.projectName}</option>
							     </c:forEach>
					</select>
				</div>
				
				 <div class="form-group">
				    <label for="projectname" class="col-xs-5">Job Id</label>
					<div class="col-xs-6">
						<select name="jobId" class="breadcrumb" id="jobId" >
						   <option value=''>Choose Job</option>
								<c:forEach var="job" items="${jobs}">
									<option value="${job.jobId}">${job.jobId}</option>
								</c:forEach>
						</select>
					</div>
				</div> 
				
				 <select id="mainSelect">
				        <option value="option1">option 1</option>
				        <option value="option2">option 2</option>
				        <option value="option3">option 3</option>
    			</select>
    <select id="subSelect">
			        <option value="option5" data-option="option1">option 5</option>
			        <option value="option8" data-option="option3">option 8</option>
			        <option value="option9" data-option="option2">option 9</option>
    </select>
				<div class="form-group">
					<button type="submit"  align="center" class="btn btn-success">Submit</button>
				</div>
				</form>
			</td>
          </tr>	
              
      </tbody>
    </table>  	
</body>
</html>
