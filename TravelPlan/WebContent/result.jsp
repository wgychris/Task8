<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="databeans.PhotoBean"%>
<link rel='stylesheet' href='assets/css/style.css' media='screen' />
<jsp:include page="template-top.jsp" />

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<!--[if lt IE 9]>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<script src="assets/js/blocksit.min.js"></script>
<script>
		$(document).ready(function() {
		//vendor script
		$('#picContainer').BlocksIt({
			numOfCol : 3,
			offsetX : 8,
			offsetY : 8
		});
		
		var currentWidth = 1100;
		$(window).resize(function() {
			var winWidth = $(window).width();
			var conWidth;
			if(winWidth < 660) {
				conWidth = 440;
				col = 2
			} else if(winWidth < 880) {
				conWidth = 660;
				col = 3
			} else if(winWidth < 1100) {
				conWidth = 880;
				col = 4;
			} else {
				conWidth = 1100;
				col = 5;
			}
			
			if(conWidth != currentWidth) {
				currentWidth = conWidth;
				$('#picContainer').width(conWidth);
				$('#picContainer').BlocksIt({
					numOfCol: col,
					offsetX: 8,
					offsetY: 8
				});
			}
		});
		
		$(window).load( function() {
			$('#picContainer').BlocksIt({
				numOfCol : 3,
				offsetX : 8,
				offsetY : 8
			});
		});
	});
</script>

<div class="container">


	<div class="span12" >
		<form method="POST" action="result.do">
			<jsp:include page="error-list.jsp" />

			<div class="row-fluid " >
				<div class="span12" >
					<hr />
					<div class="span8" >
					<div class="hero-unit" >
						<h4 class="text-center">Choose Pictures</h4>
						<hr>
						<div class="row-fluid" >
							<c:if test="${empty flickrs}">
								<p>No result found. Please try another key word.</p>
							</c:if>
							<c:if test="${!empty flickrs}">
								<div id="picContainer" >
									<c:forEach items="${flickrs}" var="flickr">
										<div class="block">
											<div class="imageholder">
												<a href="${flickr.url}"> <img src="${flickr.url}"></a></div>
												<p align="center">
												<input type="checkbox" name="flickrbox"
													value="${flickr.url}">
												</p>
											
										</div>
									</c:forEach>
								</div>
							</c:if>
						</div>
					</div>
					</div>
					<div class="span3">
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
				<div align="center">
					<button type="submit" class="btn btn-primary">Share
						&raquo;</button>
				</div>
		</form>
	</div>
</div>
<br>
<hr>
<br>
<footer>
	<div class="container">
		<p class="muted credit" align="center">Copyright &copy; 2014 Team Alliance.</p>
	</div>
</footer>

</div>
<!-- /container -->

<!-- Le javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

<script src="assets/js/bootstrap-transition.js"></script>
<script src="assets/js/bootstrap-alert.js"></script>
<script src="assets/js/bootstrap-modal.js"></script>
<script src="assets/js/bootstrap-dropdown.js"></script>
<script src="assets/js/bootstrap-scrollspy.js"></script>
<script src="assets/js/bootstrap-tab.js"></script>
<script src="assets/js/bootstrap-tooltip.js"></script>
<script src="assets/js/bootstrap-popover.js"></script>
<script src="assets/js/bootstrap-button.js"></script>
<script src="assets/js/bootstrap-collapse.js"></script>
<script src="assets/js/bootstrap-carousel.js"></script>
<script src="assets/js/bootstrap-typeahead.js"></script>

</body>
</html>