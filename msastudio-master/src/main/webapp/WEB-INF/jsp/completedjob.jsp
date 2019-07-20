<%@ include file="masheader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="refresh" content="120" />
</head>
<div class="table-responsive">

	<table class="table table-hover text-centered">
		<tbody>
			<tr>
				<td colspan="7" align="center">
					<div class="panel panel-success">
						<div class="panel-heading">
							<Strong>Completed Jobs</Strong>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<th>S.No</th>
				<th>Job Id</th>
				<th>Project Id</th>
				<th>Project Name</th>
				<th>Start Time</th>
				<th>End Time</th>
				<th>Job Status</th>
			</tr>
			<!--    <tr class="info">
         <td>1</td>
         <td>5000</td>
         <td>10200</td>
         <td>Sample Application</td>
         <td>6/5/2015 8:23:00 AM</td>
         <td>6/5/2015 10:23:00 AM</td>
		 <td>Completed</td>
      </tr>	  
	    <tr class="info">
         <td>2</td>
         <td>5001</td>
         <td>10201</td>
         <td>SCB Application</td>
         <td>14/8/2016 11:23:00 AM</td>
         <td>14/8/2016 12:23:00 PM</td>
		 <td>Completed</td>
      </tr>	
       -->

			<c:forEach var="job" items="${jobs}" varStatus="status">

				<tr class="info">
					<td><c:out value="${status.count}" /></td>
					<td><c:out value="${job.jobId}" /></td>
					<td><c:out value="${job.projectId}" /></td>
					<td><c:out value="${job.projectName}" /></td>
					<td><c:out value="${job.createdTime}" /></td>
					<td><c:out value="${job.updatedTime}" /></td>
					<td><c:out value="${job.status}" /></td>


				</tr>

			</c:forEach>

		</tbody>
	</table>
</div>
</body>
</html>
