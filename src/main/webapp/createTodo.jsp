<%@ include file="header.jsp"%>

<%
boolean isError = request.getAttribute("error") != null;
%>

<style>
.center {
	margin: auto;
	width: 50%;
	padding: 10px;
}

.right {
	float: right;
}
</style>

<form action="create" method="post" class="center">
	<div class="mb-3">
		<label for="desc" class="form-label">Todo:</label> 
		<input type="text" class="form-control" id="desc" name="desc" aria-describedby="desc">
		<div id="descHelp" class="form-text">What do you want to achieve today?</div>
	</div>
	<div>
		<input type="checkbox" class="btn-check" id="isCompleted" autocomplete="off" name="isCompleted"> 
		<label class="btn btn-outline-success" for="isCompleted">Done</label>
		<button type="submit" class="btn btn-primary right">Add Todo</button>
	</div>
	<%
	if (isError) {
		out.write("<label> An Error Occurred!</label>");
	}
	%>
</form>

<%@ include file="footer.jsp"%>