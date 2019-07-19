<%@ include file="masheader.jsp" %>  
	<div class="panel panel-success text-center">
		<div class="panel-heading"><Strong><a href="<c:out value='${pageContext.servletContext.contextPath}' />/integrationpoint">Integration Points Analysis Report</a></Strong></div>
	</div>
   <%-- <table id="example" class="display table table-hover table-striped table-responsive text-centered">
   <thead class="thead-inverse">		
      <tr>
         <th width="5%">#</th>
         <th width="20%">Business Usecase</th>
         <th width="20%">Referenced Functionality</th>
         <th width="25%">Call Sequence</th>
         <th width="15%">Integration Component</th>
         <th width="15%">Technology</th>
      </tr>
    </thead> 
        <tbody>
      <c:forEach var="report" items="${reports}" varStatus="status">
			<c:forEach var="method" items="${report.methods}">
				<c:forEach var="hierarchy" items="${method.methodCallHierarchy}">
				<c:if test ="${not empty hierarchy.technology}">	
				  <tr>
						<td nowrap="nowrap"><c:out value="${status.count}" /></td>
						<td><c:out value="${report.className}" /></td>
						<c:if test="${not empty hierarchy.methodRef}">
						<td nowrap="nowrap"><c:out value="${hierarchy.methodRef}" /></td>
						</c:if>
						<c:if test ="${empty hierarchy.methodRef}">
						<td nowrap="nowrap"><c:out value="${method.methodName}" /></td>
						</c:if>
						<td nowrap="nowrap"><c:out value="${hierarchy.methodSequence}" /></td>
						<td nowrap="nowrap"><c:out value="${hierarchy.integrationComp}" /></td>
						<td nowrap="nowrap"><c:out value="${hierarchy.technology}" /></td>
					</tr>
					</c:if>
				</c:forEach>
			</c:forEach>
		</c:forEach>
   </tbody>
</table>  --%>

<div ng-controller="MainCtrl">
	<div data-my-variable="${projectId}" data-my-variable2="${technology}" id="myDiv"></div>
    <div id="grid1" ui-grid="gridOptions" ui-grid-pagination ui-grid-pinning ui-grid-expandable  class="grid" style="width:100%;height:1200px;"></div>
</div>
<script src="js/integrationreport/app_struts.js"></script>

</body>
</html>
