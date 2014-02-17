<jsp:include page="template-top.jsp" />

<div class="container" align="center">
	<div class="hero-unit">
		<div class="row-fluid">
			<div class="span12">
				<div class="row-fluid">
					<jsp:include page="error-list.jsp" />
					<h2>Sign Up</h2>
					<br>
					<div class="span3"></div>
					<form class="form-horizontal" method="POST" action="signup.do">
						<div class="span6">
							<table class="table">
								<tr>
									<td><div class="text-right">Username</div></td>
									<td><div class="text-left">
											<input type="text" name="userName" placeholder="Username">
										</div></td>
								</tr>
								<tr>
									<td align="right"><div class="text-right">Password</div></td>
									<td><div class="text-left">
											<input type="password" name="password" placeholder="Password">
										</div></td>
								</tr>
								<tr>
									<td align="right"><div class="text-right">Confirm
											Password</div></td>
									<td><div class="text-left">
											<input type="password" name="confirmPassword"
												placeholder="Confirm password">
										</div></td>
								</tr>
							</table>
							<div>
								<button type="submit" class="btn btn-primary">Sign up</button>
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