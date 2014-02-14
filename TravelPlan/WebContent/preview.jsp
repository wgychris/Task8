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
					<a class="btn btn-default" href="viewPlan.do">&laquo; Back</a>
				</p>
			</div>
		</div>
	</div>

	<jsp:include page="template-bottom.jsp" />