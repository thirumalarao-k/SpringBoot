<%@ include file="masheader.jsp"%>
<head> <meta http-equiv="refresh" content="120" /> </head>
<div class="table-responsive">
	<div class="panel panel-success text-center">
		<div class="panel-heading">
			<Strong>Scheduled Jobs</Strong>
		</div>
	</div>
	<table id="example" class="display  table table-hover table-striped table-responsive">

		<thead>
			<tr>
				<th width="5%">S.No</th>
<!-- 				<th width="10%">Job Id</th> -->
				<th width="20%">Project Id</th>
				<th width="35%">Project Name</th>
				<th width="15%">Start Time</th>
				<th width="15%">End Time</th>
				<th width="10%">Job Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="job" items="${jobs}" varStatus="status">

				<tr>
					<td><c:out value="${status.count}" /></td>
<%-- 					<td><c:out value="${job.jobId}" /></td> --%>
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
