<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="template-top.jsp" />

<div class="container">

	<div class="row-fluid">
		<div class="span12">
			<div class="hero-unit">
				<h2 class="text-center">Travel Plan for Pittsburgh</h2>
				<hr>
				<jsp:include page="error-list.jsp" />
				<div class="row-fluid">
					<div class="span6">
						<ul class="thumbnails">
							<c:forEach items="${pfBeans}" var="pfBean">
								<div class="row-fuild">
									<li class="span12"><a href="${pfBean.url}"
										class="thumbnail"> <img src="${pfBean.url}">
									</a></li>
							</c:forEach>
						</ul>
					</div>
					<div class="span1"></div>

					<div class="span5">
						<ul class="thumbnails">
							<div class="row-fluid">

								<c:if test="${!empty ptBeans}">
									<ul class="thumbnails">
										<c:forEach items="${ptBeans}" var="ptBean">
											<div class="row-fuild">
												<li class="span12"><div class="thumbnail">
														<p class="text-left">${ptBean.tweet}</p>
													</div></li>
										</c:forEach>
									</ul>
								</c:if>
						</ul>
					</div>
				</div>
				<hr>
				<p align="center">
					<a class="btn btn-default" href="viewPlan.do">&laquo; Back</a>
				</p>
				
				<div> <!--Twitter Share Button  -->
				
					<a href="https://twitter.com/share" class="twitter-share-button"
						data-lang="en" data-via="TeamAllience"
						data-url="http://127.0.0.1:8080/TravelPlan/viewPlan.do?userid=${user.user_id}"  data-hashtags="task8"
						data-text="MyTravelPlan" data-size="large">Tweet</a>
					<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="https://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>

				</div>
				
			</div>
		</div>
	</div>

	<jsp:include page="template-bottom.jsp" />