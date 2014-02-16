<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="template-top.jsp" />


<div class="container">

	<div class="row-fluid show-grid">
		<div class="span12" align="center">
			<div class="hero-unit" align="center">
				<jsp:include page="error-list.jsp" />
				<h3>${message}</h3>
				<hr>
				<p>
					<a class="btn btn-default" href="search.do"> &laquo; Homepage</a>
					<c:if test="${!empty user}">
						<a class="btn btn-primary" href="viewPlan.do">View your plan
							&raquo;</a>
					</c:if>
				</p>
			</div>
		</div>
	</div>

	<jsp:include page="template-bottom.jsp" />