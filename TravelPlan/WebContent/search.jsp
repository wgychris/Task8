<jsp:include page="template-top.jsp" />


<div class="container">

	<!-- Main hero unit for a primary marketing message or call to action -->
	<div class="hero-unit" align="center">
		<jsp:include page="error-list.jsp" />
		<h1>Welcome to Travel Plan!</h1>
		<br>
		<h3>Simple 3 steps to start with</h3>
		<p>· entering places you would like to visit</p>
		<p>· select pictures and tweets</p>
		<p>· share your own travel plan on twitter</p>
		<p>
		<form class="form-search" method="POST" action="search.do">
			<input type="text" name="place" class="input-medium search-query"
				placeholder="street, city, country..">
			<button type="submit" class="btn btn-primary">
				<i class="icon-search icon-white"></i> Search
			</button>
		</form>
		</p>
	</div>

	<jsp:include page="template-bottom.jsp" />