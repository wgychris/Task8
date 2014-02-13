<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="databeans.PhotoBean"%>
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
								<c:if test="${empty flickers}">
									<p>No result found. Please try another key word.</p>
								</c:if>
								<c:if test="${!empty flickers}">
									<ul class="thumbnails">
										<c:forEach items="${flickers}" var="flicker">
											<div class="row-fuild">
												<li class="span12"><div class="thumbnail">
														<a href="${flicker.url}"> <img src="${flicker.url}"></a>
														<p>
															<input type="checkbox" name="flickerbox"
																value="${flicker.url}">
														</p>
													</div></li>
										</c:forEach>
									</ul>
								</c:if>
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
												<input type="checkbox" name="tweets"> tweet 1
											</p>
										</li>
									</div>
									<div class="row-fuild">
										<li class="span12">
											<p>
												<input type="checkbox" name="tweets"> tweet 1
											</p>
										</li>
									</div>
								</ul>
								<table align="center">
									<c:forEach items="${tweets}" var="tweets">
										<tr align="center">
											<td><p>${tweets}</p>
												<p>
													<input type="checkbox" name="tweets">
												</p></td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
				</div>
				<%if(request.getSession().getAttribute("user")!=null){ %>
				<div align="center">
				<a href="#myModal" role="button" class="btn" data-toggle="modal">login
					first</a>
					</div>
				<%}else{%>

				<div align="center">
					<button type="submit" class="btn btn-primary">Share
						&raquo;</button>
				</div>
				<%} %>
			</form>
		</div>
		<!-- Modal -->
		<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h3 id="myModalLabel">Modal header</h3>
			</div>
			<div class="modal-body">
				<p>cool body</p>
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">close</button>
				<button class="btn btn-primary">save</button>
			</div>
		</div>


		<jsp:include page="template-bottom.jsp" />