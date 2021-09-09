<%@ include file="header.jsp" %>

	<%
		if(request.getAttribute("error") != null) {
			out.write("<h2>Error Loggin In!</h2>");
		}
		
	%>
	<form method="post" action="login">
		<label>Enter Username:</label>
		<input type="text" name="username" />
		<br />
		<br />
		<label>Enter Password:</label>
		<input type="password" name="password" />
		<button type="submit" class="btn btn-primary">Login</button> 
	</form>

<%@ include file="footer.jsp" %>