<jsp:include page="template-top.jsp" />
<jsp:include page="error-list.jsp" />
<%@page import="utils.mapData"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%
					mapData[] cityArray = (mapData[])request.getAttribute("maps");
//mapData[] cityArray = new mapData[3];
//cityArray[0] = new mapData(37.4232, -122.1697);
//request.setAttribute("cityArray", cityArray);
//cityArray[1] = new mapData(37.6000, -122.2000);
//cityArray[2] = new mapData(37.6153, -122.3900);
					//for(mapData m:cityArray){
						//System.out.println(m.getLon());
						//System.out.println(m.getLat());
					//}
				%>
				<%-- <c:if test="${empty cityArray}">
					<p>No statistics made yet.</p>
				</c:if>
				<c:if test="${!empty cityArray}"> --%>
				<script type="text/javascript" src="https://www.google.com/jsapi"></script>
				<script type="text/javascript">
					google.load("visualization", "1", {
						packages : [ "map" ]
					});
					google.setOnLoadCallback(drawMap);
					function drawMap() {

			
						var data = google.visualization.arrayToDataTable([
										[ 'Lat', 'Lon' ]
										<c:forEach items="${cityArray}" var="city"> 
										,[ ${city.lat}, ${city.lon}]
										</c:forEach>
										]);

						var map = new google.visualization.Map(document
								.getElementById('map_div'));
						map.draw(data, {
							showTip : true
						});
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
	<div id="map_div" style="width: 600px; height: 500px"></div>
	<div id="chart_div" style="width: 1000px; height: 500px;"></div>
	<div>
		<img border="0" src="${url }" >
	</div>
</body>
</html>
<jsp:include page="template-bottom.jsp" />