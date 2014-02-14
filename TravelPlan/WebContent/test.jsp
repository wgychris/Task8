<%@ page import="databeans.PopBean"%>
<jsp:include page="template-top.jsp" />
<jsp:include page="error-list.jsp" />
<html>
<head>
<script type='text/javascript' src='https://www.google.com/jsapi'></script>
<script type='text/javascript'>
     google.load('visualization', '1', {'packages': ['geochart']});
     google.setOnLoadCallback(drawRegionsMap);

      function drawRegionsMap() {
        var data = google.visualization.arrayToDataTable();
        	/* 	[
          ['City','Popularity'],
          ['Pittsburgh', 200],
          ['Beijing', 300],
          ['New York', 400],
          ['Chicago', 500],
          ['Seatle', 600],
          ['Shanghai', 100]
        ]); */
        
        var city = new Array();  
  	    var popularity = new Array();
  	  <%PopBean[] pop = (PopBean[]) request.getAttribute("popular");
			for (int i = 0; i < pop.length; i++) {%>  
	    city[<%=i%>] = '<%=pop[i].getCity()%>'; 
	    <%}%>
	    <%for (int i = 0; i < pop.length; i++) {%>  
	    popularity[<%=i%>] = '<%=pop[i].getPopularity()%>';
<%}%>
	data.addColumn('string', 'Category');
		data.addColumn('number', 'Amount');
		data.addRows([ city.length ]);
		var options = {

			region : 'world',
			displayMode : 'markers',
			colorAxis : {
				colors : [ 'pink', 'blue' ]
			}
		};

		var chart = new google.visualization.GeoChart(document
				.getElementById('chart'));
		chart.draw(data, options);
	};
</script>
</head>
<body>
	<div id="chart" style="width: 900px; height: 500px;"></div>
</body>
</html>
<jsp:include page="template-bottom.jsp" />