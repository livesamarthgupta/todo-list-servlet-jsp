<%@include file="header.jsp" %>
<%@page import="com.todo.model.TodoItem" %>

<%
	boolean isError = request.getAttribute("error") != null;
	TodoItem todo = (TodoItem) request.getAttribute("todo");
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

.hidden {
	display: none;
}
</style>

<form action="edit" method="post" class="center">
	<div class="mb-3">
		<input type="text" class="hidden" name="id" value="<%= todo.getId() %>"/>
		<label for="desc" class="form-label">Todo:</label> 
		<input type="text" class="form-control" id="desc" name="desc" aria-describedby="desc" value="<%= todo.getTodoDesc() %>">
		<div id="descHelp" class="form-text">What do you want to achieve today?</div>
	</div>
	<div>
		<input type="checkbox" class="btn-check" id="isCompleted" name="isCompleted" autocomplete="off" <%if(todo.isCompleted()) { %> checked <% } %>> 
		<label class="btn btn-outline-success" for="isCompleted">Mark as <%if(todo.isCompleted()) { %> Not Done <% } else {%> Done <%} %></label>
		<button type="submit" class="btn btn-primary right">Edit Todo</button>
	</div>
	<%
	if (isError) {
		out.write("<label> An Error Occurred!</label>");
	}
	%>
</form>



<%@include file="footer.jsp" %>