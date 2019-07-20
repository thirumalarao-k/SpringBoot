<%@ include file="masheader.jsp" %>  
  <div class="panel panel-success text-center">
	<div class="panel-heading">
		<Strong><a href="<c:out value='${pageContext.servletContext.contextPath}' />/dependency">Dependency Analysis Report</a></Strong>
	</div>
 </div>
<%-- <table id="example" class="display  table table-hover table-striped table-responsive">
	 <thead class="thead-inverse">
		
		 <tr>
         <th width="5%">S.No</th>
         <th width="35%">Dependency Name</th>
         <th width="30%">Dependency Library</th>
         <th width="30%">Dependency Version</th>
        </tr>
       </thead> 
        <tbody>
		<c:forEach var="report" items="${reports}" varStatus="row">
			<tr>
				<td><c:out value="${row.index+1}" /></td>
				<td><c:out value="${report.dependencyNm}" /></td>
				<td><c:out value="${report.dependencyLib}" /></td>
				<td><c:out value="${report.dependencyVersion}" /></td>
			 </tr>
		</c:forEach>
	</tbody>

</table> --%>

<div ng-controller="MainCtrl">
	<div data-my-variable="${projectId}" data-my-variable2="${technology}" id="myDiv"></div>
    <div id="grid1" ui-grid="gridOptions" ui-grid-pagination ui-grid-pinning ui-grid-expandable  class="grid" style="width:100%;height:1200px;"></div>
</div>
<script src="js/dependencyreport/app_struts.js"></script>
</body>
</html>
