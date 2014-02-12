<jsp:include page="template-top.jsp" />

<div class="container">

	<div class="row-fluid">
		<div class="span12">
			<div class="hero-unit">
				<h2 class="text-center">Travel Plan for Pittsburgh</h2>
				<hr>
				<div class="row-fluid">
					<div class="span5">
						<ul class="thumbnails">
							<div class="row-fluid">
								<li class="span12"><a
									href="http://farm9.staticflickr.com/8160/7572579946_d3c5091482_b.jpg"
									class="thumbnail"> <img
										src="http://farm9.staticflickr.com/8160/7572579946_d3c5091482_b.jpg">
								</a></li>
							</div>
							<div class="row-fluid">
								<li class="span12"><a
									href="http://farm4.staticflickr.com/3217/2685676056_321559e444_b.jpg"
									class="thumbnail"> <img
										src="http://farm4.staticflickr.com/3217/2685676056_321559e444_b.jpg">
								</a></li>
							</div>
							<c:forEach items="${flickers}" var="flickers">
								<div class="row-fluid">
									<li class="span12"><a href="${flickers}" class="thumbnail">
											<img src="${flickers}">
									</a></li>
								</div>
							</c:forEach>
						</ul>
					</div>
					<div class="span1"></div>

					<div class="span6">
						<ul class="thumbnails">
							<div class="row-fluid">
								<li class="span12"><p class="text-left">tweet 1</p></li>
							</div>
							<div class="row-fluid">
								<li class="span12"><p class="text-left">tweet 2</p></li>
							</div>
							<c:forEach items="${tweets}" var="tweets">
								<div class="row-fluid">
									<li class="span12"><p class="text-left">${tweets}</p></li>
								</div>
							</c:forEach>
						</ul>
					</div>
				</div>
				<hr>
				<p align="center">
					<a class="btn btn-default" href="#">&laquo; Back</a> <a
						class="btn btn-primary" href="#">Share plan &raquo;</a>
				</p>
			</div>
		</div>
	</div>

	<jsp:include page="template-bottom.jsp" />