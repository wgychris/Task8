<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Travel Plan</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link rel='stylesheet' href='assets/css/style.css' media='screen' />
<link href="assets/css/bootstrap.css" rel="stylesheet">
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.hero-unit1 {
	padding: 10px;
	margin-bottom: 30px;
	font-size: 18px;
	font-weight: 200;
	line-height: 30px;
	color: inherit;
	background-color: #eeeeee;
	-webkit-border-radius: 6px;
	-moz-border-radius: 6px;
	border-radius: 6px;
}
</style>


<!-- Le javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- <script src="assets/js/jquery.js"></script> -->
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
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/blocksit.js"></script>
<script>
	$(document).ready(function() {
		//blocksit define
		$('#container').width($(window).width() / 3);
		$(window).load(function() {
			$('#container').BlocksIt({
				numOfCol : 2,
				offsetX : 8,
				offsetY : 8
			});
		});

		//window resize
		var currentWidth = 1100 / 3;
		$(window).resize(function() {
			var winWidth = $(window).width();
			var conWidth;
			if (winWidth < 660) {
				conWidth = 330;
				col = 1
			} else if (winWidth < 880) {
				conWidth = 440;
				col = 1
			} else if (winWidth < 1100) {
				conWidth = 1100 / 3;
				col = 2;
			} else {
				conWidth = 1100 / 3;
				col = 2;
			}

			if (conWidth != currentWidth) {
				currentWidth = conWidth;
				$('#container').width(conWidth);
				$('#container').BlocksIt({
					numOfCol : col,
					offsetX : 8,
					offsetY : 8
				});
			}
		});
	});
</script>


<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/ico/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="assets/ico/favicon.png">
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="search.do">Travel Plan</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="search.do">Home</a></li>
						<li><a href="search.do">Search</a></li>
						<li><a href="statistics.do">Statistics</a></li>

					</ul>
					<c:if test="${!empty user}">
						<ul class="nav pull-right">
							<li class="dropdown "><a href="viewPlan.do"
								class="dropdown-toggle" data-toggle="dropdown">My Travel
									Plan<b class="caret"></b>
							</a>
								<ul class="dropdown-menu pull-right">
									<li class="pull-right"><a href="search.do">Make a Plan</a></li>
									<li class="pull-right"><a href="viewPlan.do">View My
											Plan</a></li>
									<li class="pull-right"><a href="makeSchedule.do">Make
											schedule</a></li>
									<li class="pull-right"><a href="logout.do">Log out</a></li>
								</ul></li>
						</ul>
					</c:if>
					<c:if test="${empty user}">
						<ul class="nav pull-right">
							<li><button class="btn">
									<a href="signin.do">Sign in</a>
								</button></li>
							<li><button class="btn">
									<a href="signup.do">Sign up</a>
								</button></li>
						</ul>
					</c:if>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>



	<div class="container">
		<form method="POST" action="result.do">
			<div class="row">
				<jsp:include page="error-list.jsp" />
				<h2 class="text-center">Choose pictures and tweets you like</h2>
				<div class="span6">
					<div class="hero-unit1" align="center">
						<section id="wrapper">
							<h4>Choose Pictures</h4>
							<hr>
							<div id="container">
								<c:if test="${empty flickrs}">
									<p>No result found. Please try another key word.</p>
								</c:if>
								<c:if test="${!empty flickrs}">
									<c:forEach items="${flickrs}" var="flickr">
										<div class="grid">
											<div class="imgholder">
												<a href="${flickr.url}"> <img src="${flickr.url}"></a>
											</div>
											<p>
												<input type="checkbox" name="flickrbox"
													value="${flickr.url}">
											</p>
										</div>
									</c:forEach>
								</c:if>
							</div>
						</section>
					</div>
				</div>

				<div class="span6">
					<div class="hero-unit">
						<h4 class="text-center">Choose Tweets</h4>
						<hr>
						<c:if test="${empty tweets}">
							<p>No result found. Please try another key word.</p>
						</c:if>
						<c:if test="${!empty tweets}">
							<ul class="thumbnails">
								<c:forEach items="${tweets}" var="tweet">
									<div>
										<li><div class="grid">
												${tweet.text}
												<p>
													<input type="checkbox" name="tweetbox"
														value="${tweet.text}">
												</p>
											</div></li>
									</div>
								</c:forEach>
							</ul>
						</c:if>
					</div>
				</div>



			</div>
			<div align="center">
				<button type="submit" class="btn btn-primary">Share &raquo;</button>
			</div>
		</form>

		<br>
		<hr>
		<br>
		<footer>
			<div class="container">
				<p class="muted credit">Copyright &copy; 2014 Team Alliance.</p>
			</div>
		</footer>

	</div>
	<!-- /container -->

</body>
</html>