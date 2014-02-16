<%@page import="databeans.PlanBean"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="utils.mapData"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="template-top.jsp" />


<div class="container">
	<div class="row-fluid show-grid">
		<div class="span12" align="center">
			<div class="hero-unit" align="center">
				<jsp:include page="error-list.jsp" />
				<h2>Map</h2>
				<hr>
				<%
					mapData[] cityArray = new mapData[1];
					cityArray[0] = new mapData(37.4232, -122.1697, "work");
					request.setAttribute("cityArray", cityArray);
					/* cityArray[1]=new mapData(37.6000,-122.2000,"university");
					cityArray[2]=new mapData(37.6153,-122.3900,"Airport"); */
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

						var data = new google.visualization.DataTable();

						data.addColumn({
							type : 'number',
							id : 'Lat'
						});
						data.addColumn({
							type : 'number',
							id : 'Lon'
						});
						data.addColumn({
							type : 'date',
							id : 'Description'
						});

						<c:forEach items="${cityArray}" var="city">
						data.addRow([ 37.6000, -122.1697, 'work' ]);
						</c:forEach>

						/* 	var data = google.visualization.arrayToDataTable([
										[ 'Lat', 'Lon', 'Name' ]
										<c:forEach items="${cityArray}" var="city"> 
										,[ 37.6000,-122.1697, 'work' ]
										</c:forEach>
										]); */

						var map = new google.visualization.Map(document
								.getElementById('map_div'));
						map.draw(data, {
							showTip : true
						});
					}
				</script>

				<div id="map_div" style="width: 600px; height: 500px"></div>
				<%-- </c:if> --%>

				<hr>
				<p>
					<a class="btn btn-default" href="search.do">&laquo; Back</a>

				</p>
			</div>
		</div>
	</div>

	<jsp:include page="template-bottom.jsp" />