<jsp:include page="template-top.jsp" />


<div class="container" align="center">
	<div class="hero-unit">
		<div class="row-fluid">
			<div class="span12">
				<jsp:include page="error-list.jsp" />
				<div class="row-fluid">
					<h2>Make Schedule for</h2>
					<br>
					<div class="span3"></div>
					<form class="form-horizontal" method="POST"
						action="makeSchedule.do">
						<input type="hidden" name="id" value="${id}" />
						<div class="span6">
							<table class="table">
								<tr>
									<td><div class="text-right">Departure</div></td>
									<td><div class="text-left">
											<input type="date" name="dateFrom" placeholder="yyyy-mm-dd">
										</div></td>
								</tr>
								<tr>
									<td align="right"><div class="text-right">return</div></td>
									<td><div class="text-left">
											<input type="date" name="dateTo" placeholder="yyyy-mm-dd">
										</div></td>
								</tr>
							</table>
							<%-- <c:if test="${empty schedules}">
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

								<div id="example2.2" style="width: 900px; height: 180px;"></div>
							</c:if> --%>


							<div>
								<button type="submit" class="btn btn-primary">Make
									schedule</button>
							</div>
						</div>
					</form>
					<div class="span3"></div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="template-bottom.jsp" />