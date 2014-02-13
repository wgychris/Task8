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