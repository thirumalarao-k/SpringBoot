<%@ include file="masheader.jsp"%>

<title>Session Details Report</title>

<div class="panel panel-success text-center">
	<div class="panel-heading">
		<Strong><a
			href="<c:out value='${pageContext.servletContext.contextPath}' />/sessioninfo">Session
				Detail Analysis Report</a></Strong>
	</div>
</div>
	<%-- <table id="example" class="display table table-striped table-responsive" style="font-size: 12px;">
		<thead>
			
			<tr>
			<th width="3%">#</th>
				<th width="10%">Business Usecase</th>
				<th width="10%">Business Functionality</th>
				<th width="10%">Referenced Functionality</th>
				<th width="19%">Call Sequence</th>
				<th width="10%">Session References</th>
<!-- 				<th width="15%">Input Parameter</th> -->
				<th width="25%">Regrouped Parameters</th>
				<th width="13%">Proposed Service</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="report" items="${reports}" varStatus="status">
				<c:forEach var="method" items="${report.methods}">
					<c:if test="${not empty method.sessionAttributes}">
						<tr>
							<td><c:out value="${status.count}" /></td>
							<td><c:out value="${report.className}" /></td>
							<td><c:out value="${method.methodName}" /></td>
							<td>
								<table class="text-centered">
									<tbody>
										<c:forEach var="hierarchy" items="${method.methodCallHierarchy}" >
											<tr>
												<td><c:out value="${hierarchy.methodRef}" /></td>											
											</tr>
										</c:forEach>
									<tbody>
								</table>
							</td>
							<td>
								<table class="text-centered">
									<tbody>
										<c:forEach var="hierarchy" items="${method.methodCallHierarchy}" >
											<tr>
												<td style="word-break:break-none"><c:out value="${hierarchy.methodSequence}" /></td>
											</tr>
										</c:forEach>
									<tbody>
								</table>
							</td>
							<td><c:out value="${method.sessionAttributes}" /></td>
							<td><c:out value="${method.methodParams}" /></td>
								<c:set var = "sessionRemoved" value = "${fn:replace(method.methodParams,', SessionStatus sessionStatus','')}" />
								<c:set var = "sessionRemoved2" value = "${fn:replace(sessionRemoved,', HttpSession session','')}" />
							<td><c:out value="${sessionRemoved2}" /> + <c:out value="${method.sessionAttributes}" /></td>
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
					</c:if>
				</c:forEach>
			</c:forEach>
		</tbody>
	</table> --%>
	<div ng-controller="MainCtrl">
		<div data-my-variable="${projectId}" data-my-variable2="${technology}" id="myDiv"></div>
	    <div id="grid1" ui-grid="gridOptions" ui-grid-pagination ui-grid-pinning ui-grid-expandable  class="grid" style="width:100%;height:1200px;"></div>
	</div>
    <script src="js/sessionreport/app_struts.js"></script>
</div>
</body>
</html>
