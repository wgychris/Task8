<jsp:include page="template-top.jsp" />
<jsp:include page="error-list.jsp" />
<html>
<head>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
			['Month',   'Pittsburgh', 'Beijing', 'Shanghai', 'New York', 'Chicago'],
			['2013/05',    165,      938,         522,             998,           450],
			['2013/06',    135,      1120,        599,             1268,          288],
			['2013/07',    157,      1167,        587,             807,           397],
			['2013/08',    139,      1110,        615,             968,           215],
			['2013/09',    136,      691,         629,             1026,          366]
			]);


        var options = {
          title: 'Popular Places',
          hAxis: {title: 'Month',  titleTextStyle: {color: '#333'}, baselineColor: {color: '#333'} },
          vAxis: {title: 'Popularity', minValue: 0, baselineColor:{color: '#333'}}
          
        };

        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
</head>
<body>
	<div id="chart_div" style="width: 900px; height: 500px;"></div>
</body>
</html>
<jsp:include page="template-bottom.jsp" />