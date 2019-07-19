<%@ include file="masheader.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.ArrayList"%>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
    	  var jsonData = $.ajax({
              url: "microserviceReportJSON?projectId=PROJ100",
              dataType: "json",
              async: false
              }).responseText;
    	  var data1=JSON.parse(jsonData);
        	
        	
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Controller');
        data.addColumn('number', 'Method count');
            
          for (i = 0; i < data1.length; i++) {
        	  d = data1[i];
        	  data.addRow([d.className,  parseInt(d.noOfMethods)]);
        	}
        
        var options = {
        	'legend':'right',
          	'title': 'Controllers Size',
        	  'is3D':true,
        	  'width':400,
        	  'height':320,
        	  'chartArea': {'width': '96%', 'height': '80%'}
        };

        var chart = new google.visualization.PieChart(document.getElementById('controllerSize'));

        chart.draw(data, options);
        var chart1 = new google.visualization.PieChart(document.getElementById('controllerSize1'));

        chart1.draw(data, options);
        var chart2 = new google.visualization.PieChart(document.getElementById('controllerSize2'));

        chart2.draw(data, options);
      }
    </script>
  </head>
  <body>
  
  <table class="columns">
      <tr>
        <td><div id="controllerSize" style="border: 1px solid #ccc"></div></td>
        <td><div id="controllerSize1" style="border: 1px solid #ccc"></div></td>
         <td><div id="controllerSize2" style="border: 1px solid #ccc"></div></td>
      </tr>
      
    </table>
 
  </body>
</html>