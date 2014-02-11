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
						<li><a href="#about">About</a></li>
						<li><a href="#contact">Contact</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Dropdown <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
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
				<h2 class="text-center">Choose pictures and tweets you like</h2>
				<div class="row-fluid ">
					<div class="span6">
						<div class="hero-unit" align="center">
							<h4>Choose Pictures</h4>
							<hr>
							<div class="row-fluid">
								<ul class="thumbnails">
									<div class="row-fuild">
										<li class="span6">
											<div class="thumbnail">
												<img
													src="http://farm9.staticflickr.com/8160/7572579946_d3c5091482_b.jpg">
												<p>
													<input type="checkbox" var="checkbox">
												</p>
											</div>
										</li>
									</div>
									<div class="row-fuild">
										<li class="span6">
											<div class="thumbnail">
												<img
													src="http://farm4.staticflickr.com/3217/2685676056_321559e444_b.jpg">
												<div class="caption">
													<p>
														<input type="checkbox" var="checkbox">
													</p>
												</div>
											</div>
										</li>
									</div>
									<div class="row-fuild">
										<li class="span6">
											<div class="thumbnail">
												<img
													src="http://farm9.staticflickr.com/8393/8629407513_8c7479645f.jpg">
												<div class="caption">
													<p>
														<input type="checkbox" var="checkbox">
													</p>
												</div>
											</div>
										</li>
									</div>
									<div class="row-fuild">
										<li class="span6">
											<div class="thumbnail">
												<img
													src="http://farm4.staticflickr.com/3659/5820179578_322e783f2a_b.jpg">
												<div class="caption">
													<p>
														<input type="checkbox" var="checkbox">
													</p>
												</div>
											</div>
										</li>
									</div>
									<c:forEach items="${flickers}" var="flickers">
										<div class="row-fuild">
											<li class="span6">
												<div class="thumbnail">
													<img src="${flickers}">
													<div class="caption">
														<p>
															<input type="checkbox" var="checkbox" name="${flickers}">
														</p>
													</div>
												</div>
											</li>
										</div>
									</c:forEach>
								</ul>
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
												<input type="checkbox"> tweet 1
											</p>
										</li>
									</div>
									<div class="row-fuild">
										<li class="span12">
											<p>
												<input type="checkbox"> tweet 1
											</p>
										</li>
									</div>
								</ul>
								<table align="center">
									<c:forEach items="${tweets}" var="tweets">
										<tr align="center">
											<td><p>${tweets}</p>
												<p>
													<input type="checkbox">
												</p></td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div align="center">
					<a class="btn btn-primary" href="#">Preview &raquo;</a>
				</div>
			</div>
			<br>
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
