<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="template-top.jsp" />


<div class="container">
	<div class="row-fluid show-grid">
		<div class="span12" align="center">
			<div class="hero-unit" align="center">
				<jsp:include page="error-list.jsp" />
				<h2>My Travel Schedule</h2>
				<hr>
				<input type="hidden">
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
									<td>from ${plan.dateFrom} to ${plan.dateTo}</td>
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

				<script type="text/javascript"
					src="https://www.google.com/jsapi?autoload={'modules':[{'name':'visualization',
       'version':'1','packages':['timeline']}]}"></script>
				<script type="text/javascript">
					google.setOnLoadCallback(drawChart);
					function drawChart() {
						var container = document.getElementById('example2.2');
						var chart = new google.visualization.Timeline(container);
						var dataTable = new google.visualization.DataTable();
						dataTable.addColumn({
							type : 'string',
							id : 'Term'
						});
						dataTable.addColumn({
							type : 'string',
							id : 'Name'
						});
						dataTable.addColumn({
							type : 'date',
							id : 'Start'
						});
						dataTable.addColumn({
							type : 'date',
							id : 'End'
						});
						
						
						
						
						var data = google.visualization.arrayToDataTable([
['Plan_id','Place',new date 'start',new date 'end']
						                   <c:forEach items="${planArray}" var="plan">
						                   ,['${plan.plan_id}','${plan.place}', ${plan.dateFrom},${plan.dateTo}]</c:forEach>
]);
						                   
						                   
								[ '1', 'George Washington',
										new Date(1789, 3, 29),
										new Date(1797, 2, 3) ],
								[ '2', 'John Adams', new Date(1797, 2, 3),
										new Date(1801, 2, 3) ],
								[ '3', 'Thomas Jefferson',
										new Date(1801, 2, 3),
										new Date(1809, 2, 3) ] ]);

						var options = {
							timeline : {
								showRowLabels : false
							}
						};

						chart.draw(data, options);
					}
				</script>

				<div id="example2.2" style="width: 900px; height: 180px;"></div>



				<hr>
				<p>
					<a class="btn btn-default" href="search.do">&laquo; Back</a>
				</p>
			</div>
		</div>
	</div>

	<jsp:include page="template-bottom.jsp" />