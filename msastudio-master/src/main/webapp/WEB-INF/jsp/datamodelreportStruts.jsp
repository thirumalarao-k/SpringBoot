<%@ include file="masheader.jsp" %>  
 	<div class="panel panel-success text-center">
		<div class="panel-heading"><Strong><a href="<c:out value='${pageContext.servletContext.contextPath}' />/datamodel">Data Model Analysis Report</a></Strong></div>
	</div>
  <%--  <table id="example" class="display  table table-hover table-striped table-responsive">
      <thead class="thead-inverse">
      <tr>
          <th width="3%">#</th>
         <th width="25%">Database Service</th>
         <th width="25%">Functionality</th>
<!--          <th width="12%">Method Reference</th> -->
<!--          <th width="20%">Method Sequence</th> -->        
         <th width="25%">Referred Entities</th>
          <th width="22%">Proposed Service</th>
    
      </tr>
      </thead>
     <tbody>
		<c:forEach var="report" items="${reports}" varStatus="status">
			<c:forEach var="method" items="${report.methods}">
				<c:forEach var="hierarchy" items="${method.methodCallHierarchy}">
				<c:if test ="${hierarchy.methodRef!='setString' && hierarchy.methodRef!='get' 
				&& hierarchy.methodRef!='set'
				&& hierarchy.methodRef!='setLong'
				&& hierarchy.methodRef!='setInt'
				&& hierarchy.methodRef!='setString'
				&& hierarchy.methodRef!='setDate'
				&& hierarchy.methodRef!='setBigDecimal' 
				&& hierarchy.methodRef!='getBean'
				&& hierarchy.methodRef!='put'
				&& hierarchy.methodRef!='println'}">	
					<tr >
						<td><c:out value="${status.count}" /></td>
						<td><a href="<c:out value='${pageContext.servletContext.contextPath}' />/getSource/<c:out value="${report.projectId}" />/<c:out value="${report.className}" />"><c:out value="${report.className}" /></a></td>
						<td><c:out value="${method.methodName}" /></td>
						<td><c:out value="${hierarchy.methodRef}" /></td>
						<td><c:out value="${hierarchy.methodSequence}" /></td>
						<td><c:out value="${hierarchy.tableNms}" /></td>
						<td><c:out value="${hierarchy.proposedMicroService}" /></td>
						
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
<script src="js/datareport/app_struts.js"></script>
</body>
</html>
