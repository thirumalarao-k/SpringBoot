<%@ include file="masheader.jsp" %>  
<%@ taglib  prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>

 <div class="tab-content tab-pane fade in active">          
<div class="panel panel-success">
		<div class="panel-heading text-center"><Strong><a href="<c:out value='${pageContext.servletContext.contextPath}' />/objectreference">Object References  Analysis Report</a></Strong></div>
	</div>
   <%-- <table id="example" class="display table table-hover table-striped table-responsive text-centered">
      <thead class="thead-inverse">
       <tr>	
         <th width="5%">#</th>
         <th width="20%">Business Usecase</th>
         <th width="20%">Business Functionality</th>
         <th width="55%">Parameter</th>
      </tr>
      </thead>
    <tbody>
     <c:forEach var="report" items="${reports}" varStatus="status">
		<c:forEach var="method" items="${report.methods}">
				<tr>
					<td><c:out value="${status.count}" /></td>
					<td><c:out value="${report.className}" /></td>
					<td><c:out value="${method.methodName}" /></td>
					<c:set var = "bracesRemoved" value = "${fn:substring(method.methodParams, 1,fn:length(method.methodParams)-1)}" />
					<td><c:out value="${bracesRemoved}" /></td>
				</tr>
		</c:forEach>
	 </c:forEach>
   </tbody>
   
</table> --%> 
	<div ng-controller="MainCtrl">
		<div data-my-variable="${projectId}" data-my-variable2="${technology}" id="myDiv"></div>
	    <div id="grid1" ui-grid="gridOptions" ui-grid-pagination ui-grid-pinning ui-grid-expandable  class="grid" style="width:100%;height:1200px;"></div>
	</div>
    <script src="js/objectreport/app_spring.js"></script>
</div>
</body>
</html>
