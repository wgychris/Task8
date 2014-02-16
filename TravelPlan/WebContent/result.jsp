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
		
		
		$(window).load( function() {
			$('#picContainer').BlocksIt({
				numOfCol : 3,
				offsetX : 8,
				offsetY : 8
			});
		});
		
		var currentWidth = 1100/3;
		$(window).resize(function() {
			var winWidth = $(window).width()/3;
			var conWidth;
			if(winWidth <220) {
				conWidth = 440;
				col = 2;
			} else if(winWidth <440) {
				conWidth = 660;
				col = 2;
			} else if(winWidth < 660) {
				conWidth = 880;
				col = 3;
			} else {
				conWidth = 1100;
				col = 4;
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
								<c:if test="${empty tweets}">
									<p>No result found. Please try another key word.</p>
								</c:if>
								<c:if test="${!empty tweets}">
									<ul class="thumbnails">
										<c:forEach items="${tweets}" var="tweet">
											<div class="row-fuild">
												<li class="span12"><div class="grid">
														<h6>${tweet.text}</h6>
														<p>
															<input type="checkbox" name="tweetbox"
															value="${tweet.text}"
															>
														</p>
													</div></li>
										</c:forEach>
									</ul>
								</c:if>
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