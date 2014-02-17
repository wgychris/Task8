<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="template-top.jsp" />

<style>
.grid {
	width: 90%;
	padding: 15px;
	background: #fff;
	margin: 8px;
	font-size: 12px;
	box-shadow: 0 1px 3px rgba(34, 25, 25, 0.4);
	-moz-box-shadow: 0 1px 3px rgba(34, 25, 25, 0.4);
	-webkit-box-shadow: 0 1px 3px rgba(34, 25, 25, 0.4);
	-webkit-transition: top 1s ease, left 1s ease;
	-moz-transition: top 1s ease, left 1s ease;
	-o-transition: top 1s ease, left 1s ease;
	-ms-transition: top 1s ease, left 1s ease;
}
</style>

<div class="container">

	<div class="row-fluid">
		<div class="span12">
			<div class="hero-unit">
				<p>
					<!--Twitter Share Button  -->
					<a href="https://twitter.com/share" class="twitter-share-button"
						data-lang="en" data-via="TeamAllience"
						data-url="http://127.0.0.1:8080/TravelPlan/viewPlan.do?id=${id}"
						data-hashtags="task8" data-text="MyTravelPlan" data-size="large">Tweet</a>
					<script>
						!function(d, s, id) {
							var js, fjs = d.getElementsByTagName(s)[0];
							if (!d.getElementById(id)) {
								js = d.createElement(s);
								js.id = id;
								js.src = "https://platform.twitter.com/widgets.js";
								fjs.parentNode.insertBefore(js, fjs);
							}
						}(document, "script", "twitter-wjs");
					</script>
				</p>
				<h2 class="text-center">Travel Plan for Pittsburgh</h2>

				<hr>
				<jsp:include page="error-list.jsp" />
				<div class="row-fluid">
					<div class="span6">
						<ul class="thumbnails">
							<c:forEach items="${pfBeans}" var="pfBean">
								<li class="thumbnails"><a href="${pfBean.url}"><div
											class="grid">
											<img src="${pfBean.url}"></a>
									<div class="text-center"></li>
							</c:forEach>
						</ul>
					</div>

					<div class="span6">
						<ul class="thumbnails">
							<div class="row-fluid">
								<c:if test="${empty ptBeans}">
									<p>No tweets.</p>
								</c:if>
								<c:if test="${!empty ptBeans}">
									<div>
										<c:forEach items="${ptBeans}" var="ptBean">
											<div class="row-fuild">
												<div class="span12">
													<div class="grid">
														<p class="text-left">${ptBean.tweet}</p>
													</div>
												</div>
										</c:forEach>
									</div>
								</c:if>
						</ul>
					</div>
				</div>
				<hr>
				<p align="center">
					<a class="btn btn-default" href="viewPlan.do">&laquo; Back</a>
				</p>
				<p>

					<!--Twitter Share Button  -->
					<a href="https://twitter.com/share" class="twitter-share-button"
						data-lang="en" data-via="TeamAllience"
						data-url="http://127.0.0.1:8080/TravelPlan/viewPlan.do?id=${id}"
						data-hashtags="task8" data-text="MyTravelPlan" data-size="large">Tweet</a>
					<script>
						!function(d, s, id) {
							var js, fjs = d.getElementsByTagName(s)[0];
							if (!d.getElementById(id)) {
								js = d.createElement(s);
								js.id = id;
								js.src = "https://platform.twitter.com/widgets.js";
								fjs.parentNode.insertBefore(js, fjs);
							}
						}(document, "script", "twitter-wjs");
					</script>
				</p>

				<div></div>

			</div>
		</div>
	</div>

	<jsp:include page="template-bottom.jsp" />