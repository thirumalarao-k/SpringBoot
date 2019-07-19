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
		document.location = "datamodel/" +projectId;
		return true;
}

</script> 
</head>
<div  style=" width:100%;align=center; margin: auto;" class="panel panel-success text-center">
      <div class="panel-heading"><Strong>Data Model Analysis Report</Strong></div>
    </div>
<table width="50%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tbody>
         <tr>
            <td colspan="2" align="center">
			
				<form method="post" action="<c:out value='${pageContext.servletContext.contextPath}' />/datamodelreport">
				<div class="form-group">
				
					<div class="col-xs-12">
					 <select name="projectId" class="breadcrumb" id="projectId" >
							<option value=''>------------- Choose a project -------------</option>
								<c:forEach var="project" items="${projects}">
										<option value="${project.projectId}:${project.technology}">${project.projectName}</option>
							     </c:forEach>
					</select>
					</div>
						</div>
					<%-- 
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
				</div> --%>
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
