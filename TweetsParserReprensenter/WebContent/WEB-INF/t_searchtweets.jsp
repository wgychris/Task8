<!-- Yusi Zhang Jan.16 Version 1.0 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="template-top.jsp" />
<%@ page import="databeans.*"%>
<jsp:include page="error-list.jsp" />

<div style="position: relative;">
	<div class="page-header">
		<h1>Search Tweets</h1>
	</div>
	<style type="text/css">
#tfheader {
	background-color: #c3dfef;
}

#tfheader2 {
	background-color: #F5F5DC;
}

#tfnewsearch {
	float: right;
	padding: 20px;
}

.tftextinput {
	margin: 0;
	padding: 5px 15px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	border: 1px solid #0076a3;
	border-right: 0px;
	border-top-left-radius: 5px 5px;
	border-bottom-left-radius: 5px 5px;
}

.tfbutton {
	margin: 0;
	padding: 5px 15px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	outline: none;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	color: #ffffff;
	border: solid 1px #0076a3;
	border-right: 0px;
	background: #0095cd;
	background: -webkit-gradient(linear, left top, left bottom, from(#00adee),
		to(#0078a5));
	background: -moz-linear-gradient(top, #00adee, #0078a5);
	border-top-right-radius: 1px 1px;
	border-bottom-right-radius: 1px 1px;
}

.tfbutton:hover {
	text-decoration: none;
	background: #007ead;
	background: -webkit-gradient(linear, left top, left bottom, from(#0095cc),
		to(#00678e));
	background: -moz-linear-gradient(top, #0095cc, #00678e);
}
/* Fixes submit button height problem in Firefox */
.tfbutton::-moz-focus-inner {
	border: 0;
}

.tfclear {
	clear: both;
}
</style>
	<div id="tfheader">
		<form id="tfnewsearch" method="post" action="c_researchFund.do">
			Search Tweets : <input type="text" class="tftextinput" name="search"
				size="21" maxlength="120"><input type="submit"
				value="search" class="tfbutton">
		</form>
		<div class="tfclear"></div>
		<table class="table table-hover">
		<%
			if (request.getAttribute("tweets") != null) {
		%>
		
		<tr>
			<td>Tweet</td>
		</tr>
		<%
			for (TweetBean f : (TweetBean[]) request.getAttribute("tweets")) {
		%>
		<tr>
			<td><%=f.getText()%></td>
		</tr>
		<%
			}
		%>

		</table>
		<%
			}
		%>
	</div>

</div>


<jsp:include page="template-bottom.jsp" />
