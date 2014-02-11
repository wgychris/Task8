
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Travel Plan</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<script src="https://code.jquery.com/jquery.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<!-- Le styles -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
</style>
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="assets/js/html5shiv.js"></script>
    <![endif]-->

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
				<a class="brand" href="#">Travel Plan</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#about">Search</a></li>
						<li><a href="#contact">Statistics</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">My Travel Plan<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">Make a Plan</a></li>
								<li><a href="#">View My Plan</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li class="nav-header">Nav header</li>
								<li><a href="#">Separated link</a></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
					</ul>
					<form class="navbar-form pull-right">
						<input class="span2" type="text" placeholder="Email"> <input
							class="span2" type="password" placeholder="Password">
						<button type="submit" class="btn">Sign in</button>
					</form>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

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
										<li class="span12"><a href="${flickers}"
											class="thumbnail"> <img src="${flickers}">
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

		<hr>

		<footer>
			<p>&copy; Team Alliance 2014</p>
		</footer>

	</div>
	<!-- /container -->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery.js"></script>
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
