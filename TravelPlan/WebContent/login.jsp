<jsp:include page="template-top.jsp" />

<jsp:include page="error-list.jsp" />



<div class="row">
	<div class="col-md-4"></div>
	<div class="col-md-4">
		<p>
		<form class="form-signin" method="post" action="c_login.do">
			<h4 class="form-signin-heading">Dear customer, please sign in</h4>
			<input type="text" class="form-control" name="userName"
				placeholder="Username" vale="${form.userName}" autofocus="">
			<br /> <input type="password" class="form-control" name="password"
				placeholder="Password" value=""> <br />

			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
			<p class="text-center">
				<a href="admin_login.do">Change entrance</a>
			</p>
		</form>
		</p>
	</div>
	<div class="col-md-4"></div>

</div>

<jsp:include page="template-bottom.jsp" />