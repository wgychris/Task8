<%@page import="databeans.PlanBean"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="template-top.jsp" />


<div class="container">
	<div class="row-fluid show-grid">
		<div class="span12" align="center">
			<div class="hero-unit" align="center">
				<jsp:include page="error-list.jsp" />
				<h2>My Travel Plan</h2>
				<hr>
				<c:if test="${empty planArray}">
					<p>
						You don't have any plan. Start making a plan from <a
							href="search.do">here</a>.
					</p>
				</c:if>
				<c:if test="${!empty planArray}">
					<table align="center" class="table table-hover">
						<thead>
							<th>Place</th>
							<th>Schedule date</th>
							<th>Operation</th>
						</thead>
						<c:forEach items="${planArray}" var="plan">
							<tr>
								<td><a herf="#">${plan.place}</a></td>
								<c:if test="${!empty plan.dateFrom}">
									<td><fmt:formatDate value="${plan.dateFrom}" type="date" />
										- <fmt:formatDate value="${plan.dateTo}" type="date" /></td>
								</c:if>
								<c:if test="${empty plan.dateFrom}">
									<td>No schedule yet</td>
								</c:if>
								<td><a type="button" class="btn btn-default"
									href="preview.do?id=${plan.plan_id}">Preview Plan</a><a
									type="button" class="btn btn-default"
									href="makeSchedule.do?id=${plan.plan_id}">Make schedule</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
				<c:if test="${empty schedules}">
					<p>No schedule made yet.</p>
				</c:if>
				<c:if test="${!empty schedules}">
					<script type="text/javascript"
						src="https://www.google.com/jsapi?autoload={'modules':[{'name':'visualization',
       'version':'1','packages':['timeline']}]}"></script>
					<script type="text/javascript">
						google.setOnLoadCallback(drawChart);
						function drawChart() {
							var container = document
									.getElementById('example2.2');
							var chart = new google.visualization.Timeline(
									container);
							var data = new google.visualization.DataTable();

							data.addColumn({
								type : 'string',
								id : 'Place'
							});
							data.addColumn({
								type : 'date',
								id : 'Start'
							});
							data.addColumn({
								type : 'date',
								id : 'End'
							});
							
							<c:forEach items="${schedules}" var="schedule"> 
							data.addRow(
									['${schedule.place}',
									new Date(${schedule.fy}, ${schedule.fm}, ${schedule.fd}), 
									new Date(${schedule.ty}, ${schedule.tm}, ${schedule.td})]);
							</c:forEach> 
							chart.draw(data);
						}
					</script>

					<div id="example2.2"
						style="width: 900px; height: ${100*scheduleSize}px;"></div>
				</c:if>



				<hr>
				<p>
					<a class="btn btn-default" href="search.do">&laquo; Back</a>
				<div>
					<!--Twitter Share Button  -->

					<a href="https://twitter.com/share" class="twitter-share-button"
						data-lang="en" data-via="TeamAllience"
						data-url="http://127.0.0.1:8080/TravelPlan/viewPlan.do?userid=${user.user_id}"
						data-hashtags="task8" data-text="MyTravelPlan" data-size="large">Tweet</a>
					<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="https://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>

				</div>
				</p>
			</div>
		</div>
	</div>

	<jsp:include page="template-bottom.jsp" />