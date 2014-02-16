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
			['Month',   'Pittsburgh', 'Beijing', 'Shanghai', 'New York', '${place}'],
			['Jan.',    165,      938,         522,             998,           450],
			['Feb.',    135,      1120,        599,             1268,          288],
			['Mar.',    157,      1167,        587,             807,           397],
			['Apr.',    139,      1110,        615,             968,           215],
			['May',    136,      691,         629,             1026,          366],
			['June',    165,      938,         522,             998,           450],
			['July',    135,      1120,        599,             1268,          288],
			['Aug.',    157,      1167,        587,             807,           397],
			['Sept.',    139,      1110,        615,             968,           215],
			['Oct.',    136,      691,         629,             1026,          366],
			['Nov.',    165,      938,         522,             998,           450],
			['Dec.',    135,      1120,        599,             1268,          288],
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
	<div>
		<form class="form-search" method="GET" action="statistics.do">
			<input type="text" name="place" class="input-medium search-query"
				placeholder="street, city, country..">
			<button type="submit" class="btn btn-primary">
				<i class="icon-search icon-white"></i> Search
			</button>
		</form>
	</div>
	<div id="chart_div" style="width: 1000px; height: 500px;"></div>
</body>
</html>
<jsp:include page="template-bottom.jsp" />