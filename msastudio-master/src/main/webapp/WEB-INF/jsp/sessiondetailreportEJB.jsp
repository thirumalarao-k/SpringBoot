<%@ include file="masheader.jsp"%>

<title>Session Details Report</title>

 
<div class="tab-content tab-pane fade in active">
	<div class="panel panel-success text-center">
		<div class="panel-heading">
			<Strong><a
				href="<c:out value='${pageContext.servletContext.contextPath}' />/sessioninfo">Session
					Detail Analysis Report</a></Strong>
		</div>
	</div>
	<%-- <table id="example" class="display table table-hover table-striped table-responsive" style="font-size: 12px;">
		<thead>
			<tr>
				<th width="3%">#</th>
				<th width="27%">Business Usecase</th>
				<th width="20%">Component Type</th>
				<th width="30%">Session References</th>
				<th width="20%">Proposed Service</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="report" items="${reports}" varStatus="status">
				<c:forEach var="method" items="${report.methods}">
					<tr>
						<td><c:out value="${status.count}" /></td>
						<td><c:out value="${report.className}" /></td>
						<td> Statefull <c:out value="${report.sterioType}" /></td>
						<td><c:out value="${report.insVariables}" /></td>
						<td><table class="text-centered">
								<tbody>
									<c:forEach var="hierarchy" items="${method.methodCallHierarchy}" >
										<tr>
											<td style="word-break:break-none"><c:out value="${hierarchy.proposedMicroService}" /></td>
										</tr>
									</c:forEach>
								<tbody>
							</table>
						</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</tbody>
	</table> --%>
	<div ng-controller="MainCtrl">
		<div data-my-variable="${projectId}" data-my-variable2="${technology}" id="myDiv"></div>
	    <div id="grid1" ui-grid="gridOptions" ui-grid-pagination ui-grid-pinning ui-grid-expandable  class="grid" style="width:100%;height:1200px;"></div>
	</div>
    <script src="js/sessionreport/app_ejb.js"></script>
</div>
</body>
</html>
