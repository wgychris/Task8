<jsp:include page="template-top.jsp" />
<jsp:include page="error-list.jsp" />
<%@page import="utils.mapData"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="container">
	<div class="row-fluid show-grid">
		<div class="span12" align="center">
			<jsp:include page="error-list.jsp" />
			<div>
				<c:if test="${empty maps}">
					<h3>Enter name of place to see more details on map and its
						tweets cloud.</h3>
				</c:if>
				<form class="form-search" method="GET" action="statistics.do">
					<input type="text" name="place" class="input-medium search-query"
						placeholder="street, city, country..">
					<button type="submit" class="btn btn-primary">
						<i class="icon-search icon-white"></i> Search
					</button>
				</form>
			</div>
			<script type="text/javascript" src="https://www.google.com/jsapi"></script>
			<script type="text/javascript">
					google.load("visualization", "1", {
						packages : [ "map" ]
					});
					google.setOnLoadCallback(drawMap);
					function drawMap() {
						var data = google.visualization.arrayToDataTable([
										[ 'Lat', 'Lon' ]
										<c:forEach items="${maps}" var="city"> 
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
			<c:if test="${!empty maps}">
				<div id="map_div" style="width: 600px; height: 500px"></div>
			</c:if>
			<div id="chart_div" style="width: 1000px; height: 500px;"></div>
			<div>
				<img border="0" src="${url}">
			</div>

		</div>
	</div>

	<jsp:include page="template-bottom.jsp" />