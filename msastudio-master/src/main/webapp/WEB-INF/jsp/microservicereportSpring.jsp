<%@ include file="masheader.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.ArrayList"%>

  <script src="https://d3js.org/d3.v4.min.js"></script>  
<style>

.node {
  cursor: pointer;
}

.node:hover {
  stroke: #000;
  stroke-width: 1.5px;
}

.node--leaf {
  fill: white;
}

.label {
  font: 11px "Helvetica Neue", Helvetica, Arial, sans-serif;
  text-anchor: middle;
  text-shadow: 0 1px 0 #fff, 1px 0 0 #fff, -1px 0 0 #fff, 0 -1px 0 #fff;
}

.label,
.node--root,
.node--leaf {
  pointer-events: none;
}

</style>

 

<div class="panel panel-success" style="margin-bottom:0px;">
		<div class="panel-heading text-center">
			<Strong><a
				href="<c:out value='${pageContext.servletContext.contextPath}' />/microservice">Micro
					Service Analysis Report</a></Strong>
		</div>
	</div>
<ul class="nav nav-tabs" style="margin-top:0px;">
  <li class="pull-right"><a data-toggle="tab" href="#table1">Table</a></li>
  <li class=" active pull-right"><a data-toggle="tab" href="#chart1">Chart</a></li>
</ul>
<div class="tab-content">

<div id="table1"  class="tab-pane fade in ">
	

<%-- 	<table id="example"
		class="display  table table-hover table-striped "
		style="width: 99%; font-size: 12px;">
		<thead class="thead-inverse">

			<tr>
				<th width="3%">#</th>
				<th width="13%">Controller Name</th>
				<th width="11%">Access Points</th>
				<th width="12%">Controller Method</th>
				<th width="12%">Method Reference</th>
				<th width="21%">Sequence Flow</th>
				<th width="14%">Proposed Service</th>
				<th width="14%">Parameters</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="report" items="${reports}" varStatus="status">
				<c:forEach var="method" items="${report.methods}">
					<tr>
						<td><c:out value="${status.count}" /></td>
						<td><a href="<c:out value='${pageContext.servletContext.contextPath}' />/getSource/<c:out value="${report.projectId}" />/<c:out value="${report.className}" />"><c:out value="${report.className}" /></a></td>

						<c:choose>
							<c:when test="${fn:startsWith(method.methodSignature,'\"')}">
								<c:set var="methodSignatureQuotesRemoved"
									value="${fn:substring(method.methodSignature, 1,fn:length(method.methodSignature)-1)}" />
								<td style="word-break: break-none"><c:out
										value="${methodSignatureQuotesRemoved}" /></td>
							</c:when>
							<c:otherwise>
								<td style="word-break: break-none"><c:out
										value="${method.methodSignature}" /></td>
							</c:otherwise>
						</c:choose>

						<td><a href="<c:out value='${pageContext.servletContext.contextPath}' />/getSource/<c:out value="${report.projectId}" />/<c:out value="${report.className}" />/<c:out value="${method.methodName}" />" ><c:out value="${method.methodName}" /></a></td>
						<td>
							<table class="text-centered">
								<tbody>
									<c:forEach var="hierarchy"
										items="${method.methodCallHierarchy}">
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
										<c:choose>
											<c:when test="${hierarchy.objectRefDefineType eq 'user_defined'}">
												<c:set var = "classNames" value = "${fn:split(hierarchy.methodSequence, '->')}" />
												<td>
													<c:if test="${fn:length(classNames) gt 0}">
														<c:forEach var="className" items="${classNames}"  end="${fn:length(classNames)-2}">
															<a href="<c:out value='${pageContext.servletContext.contextPath}' />/getSource/<c:out value="${report.projectId}" />/<c:out value="${className}" />"><c:out value="${className}" /></a>->
														</c:forEach>
													</c:if>
													<a href="<c:out value='${pageContext.servletContext.contextPath}' />/getSource/<c:out value="${report.projectId}" />/<c:out value="${classNames[fn:length(classNames)-2]}" />/<c:out value="${classNames[fn:length(classNames)-1]}" />"><c:out value="${classNames[fn:length(classNames)-1]}" /></a>
												</td>
											</c:when>
											<c:otherwise>
												<td><c:out value="${hierarchy.methodSequence}" /></td>
											</c:otherwise>
										</c:choose>
										</tr>
									</c:forEach>
								<tbody>
							</table>
						</td>
						<td style="font-weight: bold; font-style: italic;">
							<table	class="text-centered">
								<tbody>
									<c:forEach var="hierarchy"
										items="${method.methodCallHierarchy}">
										<tr>
											<td><c:out value="${hierarchy.proposedMicroService}" /></td>
										</tr>
									</c:forEach>
								<tbody>
							</table></td>
						<c:set var="bracesRemoved"
							value="${fn:substring(method.methodParams, 1,fn:length(method.methodParams)-1)}" />
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
    <script src="js/microreport/app_spring.js"></script>
	</div>
	
	<div id="chart1"  class="tab-pane fade in active">
		 <svg width="700" height="700" align="center" style="margin-left:350px;"></svg>		 
	</div>
</div>

  <script>

var svg = d3.select("svg"),
    margin = 20,
    diameter = +svg.attr("width"),
    g = svg.append("g").attr("transform", "translate(" + diameter / 2 + "," + diameter / 2 + ")");

var color = d3.scaleLinear()
    .domain([-1, 5])
    .range(["hsl(152,80%,80%)", "hsl(228,30%,40%)"])
    .interpolate(d3.interpolateHcl);

var pack = d3.pack()
    .size([diameter - margin, diameter - margin])
    .padding(2);


  
d3.json("circularChartJSON?projectId=${projectId}&technology=${technology}", function(error, root) {
  if (error) throw error;

  root = d3.hierarchy(root)
      .sum(function(d) { return d.size; })
      .sort(function(a, b) { return b.value - a.value; });

  var focus = root,
      nodes = pack(root).descendants(),
      view;

  var circle = g.selectAll("circle")
    .data(nodes)
    .enter().append("circle")
      .attr("class", function(d) { return d.parent ? d.children ? "node" : "node node--leaf" : "node node--root"; })
      .style("fill", function(d) { return d.children ? color(d.depth) : null; })
      .on("click", function(d) { if (focus !== d) zoom(d), d3.event.stopPropagation(); });

  var text = g.selectAll("text")
    .data(nodes)
    .enter().append("text")
      .attr("class", "label")
      .style("fill-opacity", function(d) { return d.parent === root ? 1 : 0; })
      .style("display", function(d) { return d.parent === root ? "inline" : "none"; })
      .text(function(d) { return d.data.name; });

  var node = g.selectAll("circle,text");

  svg
      .style("background", color(-1))
      .on("click", function() { zoom(root); });

  zoomTo([root.x, root.y, root.r * 2 + margin]);

  function zoom(d) {
    var focus0 = focus; focus = d;

    var transition = d3.transition()
        .duration(d3.event.altKey ? 7500 : 750)
        .tween("zoom", function(d) {
          var i = d3.interpolateZoom(view, [focus.x, focus.y, focus.r * 2 + margin]);
          return function(t) { zoomTo(i(t)); };
        });

    transition.selectAll("text")
      .filter(function(d) { return d.parent === focus || this.style.display === "inline"; })
        .style("fill-opacity", function(d) { return d.parent === focus ? 1 : 0; })
        .on("start", function(d) { if (d.parent === focus) this.style.display = "inline"; })
        .on("end", function(d) { if (d.parent !== focus) this.style.display = "none"; });
  }

  function zoomTo(v) {
    var k = diameter / v[2]; view = v;
    node.attr("transform", function(d) { return "translate(" + (d.x - v[0]) * k + "," + (d.y - v[1]) * k + ")"; });
    circle.attr("r", function(d) { return d.r * k; });
  }
});

</script>
</body>
</html>
