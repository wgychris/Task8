<jsp:include page="template-top.jsp" />

<div class="container">

	<div class="row-fluid">
		<div class="span12">
			<form method="POST" action="result.do">
			<jsp:include page="error-list.jsp" />
				<h2 class="text-center">Choose pictures and tweets you like</h2>
				<div class="row-fluid ">
					<div class="span6">
						<div class="hero-unit" align="center">
							<h4>Choose Pictures</h4>
							<hr>
							<div class="row-fluid">
								<ul class="thumbnails">
									<div class="row-fuild">
										<li class="span6">
											<div class="thumbnail">
												<img
													src="http://farm9.staticflickr.com/8160/7572579946_d3c5091482_b.jpg">
												<p>
													<input type="checkbox" name = "flickers" var="checkbox">
												</p>
											</div>
										</li>
									</div>
									<div class="row-fuild">
										<li class="span6">
											<div class="thumbnail">
												<img
													src="http://farm4.staticflickr.com/3217/2685676056_321559e444_b.jpg">
												<div class="caption">
													<p>
														<input type="checkbox"  name = "flickers" var="checkbox">
													</p>
												</div>
											</div>
										</li>
									</div>
									<div class="row-fuild">
										<li class="span6">
											<div class="thumbnail">
												<img
													src="http://farm9.staticflickr.com/8393/8629407513_8c7479645f.jpg">
												<div class="caption">
													<p>
														<input type="checkbox"  name = "flickers" var="checkbox">
													</p>
												</div>
											</div>
										</li>
									</div>
									<div class="row-fuild">
										<li class="span6">
											<div class="thumbnail">
												<img
													src="http://farm4.staticflickr.com/3659/5820179578_322e783f2a_b.jpg">
												<div class="caption">
													<p>
														<input type="checkbox"  name = "flickers" var="checkbox">
													</p>
												</div>
											</div>
										</li>
									</div>
									<c:forEach items="${flickers}" var="flickers">
										<div class="row-fuild">
											<li class="span6">
												<div class="thumbnail">
													<img src="${flickers}">
													<div class="caption">
														<p>
															<input type="checkbox"  name = "flickers" var="checkbox" name="${flickers}">
														</p>
													</div>
												</div>
											</li>
										</div>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>

					<div class="span6">
						<div class="hero-unit">
							<h4 class="text-center">Choose Tweets</h4>
							<hr>
							<div class="row-fluid">
								<ul>
									<div class="row-fuild">
										<li class="span12">
											<p>
												<input type="checkbox"  name = "tweets"> tweet 1
											</p>
										</li>
									</div>
									<div class="row-fuild">
										<li class="span12">
											<p>
												<input type="checkbox" name = "tweets"> tweet 1
											</p>
										</li>
									</div>
								</ul>
								<table align="center">
									<c:forEach items="${tweets}" var="tweets">
										<tr align="center">
											<td><p>${tweets}</p>
												<p>
													<input type="checkbox" name = "tweets">
												</p></td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div align="center">
					<button type="submit" class="btn btn-primary">Preview
						&raquo;</button>
				</div>
			</form>
		</div>
		<jsp:include page="template-bottom.jsp" />