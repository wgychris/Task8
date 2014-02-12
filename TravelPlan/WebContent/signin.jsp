<jsp:include page="template-top.jsp" />


<div class="container" align="center">
	<div class="hero-unit">
		<div class="row-fluid">
			<div class="span12">
			<jsp:include page="error-list.jsp" />
				<div class="row-fluid">
					<h2>Sign In</h2>
					<br>
					<div class="span3"></div>
					<form class="form-horizontal" method="POST" action="signin.do">
						<div class="span6">
							<table class="table">
								<tr>
									<td><div class="text-right">Twitter</div></td>
									<td><div class="text-left">
											<input type="text" name = "userName" placeholder="Twitter">
										</div></td>
								</tr>
								<tr>
									<td align="right"><div class="text-right">Password</div></td>
									<td><div class="text-left">
											<input type="password" name = "password"
												placeholder="Password">
										</div></td>
								</tr>
							</table>
							<div>
								<button type="submit" class="btn btn-primary">Sign in</button>
							</div>
						</div>
					</form>
					<div class="span3"></div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="template-bottom.jsp" />