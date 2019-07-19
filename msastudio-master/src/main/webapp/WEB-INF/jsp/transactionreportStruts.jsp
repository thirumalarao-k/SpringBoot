<%@ include file="masheader.jsp" %>  
<%@ taglib  prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<div class="panel panel-success text-center">
	<div class="panel-heading"><Strong><a href="<c:out value='${pageContext.servletContext.contextPath}' />/transactioninfo">Transactional Boundaries Analysis Report</a></Strong></div>
</div>
<div class="tab-content tab-pane fade in active">
 <%-- <table id="example" class="display table table-hover table-striped table-responsive">
     <thead class="thead-inverse">
       <tr>
         <th width="5%">#</th>
         <th width="15%">Business Usecase</th>
         <th width="15%">Transactional Functions</th>
         <th width="15%">Referenced Functionality</th>
         <th width="15%">Call Sequence</th> 
         <th width="15%">Proposed Service</th>
         <th width="15%">Compensating Service</th>
      </tr>
 	</thead>
	<tbody>  
    	<c:forEach var="report" items="${reports}" varStatus="status">
			<c:forEach var="method" items="${report.methods}" >
				<tr>
					<td><c:out value="${status.count}" /></td>
					<td><c:out value="${report.className}" /></td>
					<td><c:out value="${method.methodName}" /></td>
					<td>
						<table class="text-centered">
							<tbody>
								<c:forEach var="hierarchy" items="${method.methodCallHierarchy}">
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
								<c:forEach var="hierarchy" items="${method.methodCallHierarchy}">
									<tr>
										<td><c:out value="${hierarchy.methodSequence}" /></td>
									</tr>
								</c:forEach>
							<tbody>
						</table>
					</td>
					<td><table class="text-centered">
							<tbody>
								<c:forEach var="hierarchy" items="${method.methodCallHierarchy}">
									<tr>
										<td><c:out value="${hierarchy.proposedMicroService}" /></td>
									</tr>
								</c:forEach>
							<tbody>
						</table>
					</td>
					<td><table class="text-centered">
							<tbody>
								<c:forEach var="hierarchy" items="${method.methodCallHierarchy}">
									<tr>
										<td><c:out value="${hierarchy.compensatingService}" /></td>
									</tr>
								</c:forEach>
							<tbody>
						</table>
					</td>
				</tr>
			</c:forEach>			
		</c:forEach>
  </tbody>   
</table>  --%>
	<div ng-controller="MainCtrl">
		<div data-my-variable="${projectId}" data-my-variable2="${technology}" id="myDiv"></div>
	    <div id="grid1" ui-grid="gridOptions" ui-grid-pagination ui-grid-pinning ui-grid-expandable  class="grid" style="width:100%;height:1200px;"></div>
	</div>
	<script src="js/transactionreport/app_struts.js"></script>
</div>
</body>
</html>
