<%@include file="header.jsp" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.todo.model.TodoItem" %>

<%
boolean isError = request.getAttribute("error") != null;
%>

<style>
.small {
	width: 75%;
}

.center {
  text-align: center;
}
</style>

	<h1 class="center">Welcome to Your Todo List!</h1>
	<% ArrayList<TodoItem> todos = (ArrayList<TodoItem>)request.getAttribute("todos"); %>
	
	
<div class="container-sm ">	
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Todo</th>
      <th scope="col">Status</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  <%
  	 for(TodoItem todo : todos) {
  %>
    <tr>
      <th scope="row"><%= todo.getId()%></th>
      <td><%= todo.getTodoDesc() %></td>
      <td>
      	<input type="checkbox" class="btn-check" id="<%= todo.getId() %>" autocomplete="off" <%if(todo.isCompleted()) {%> checked <%} %> onchange="toggleTodo(this.id)">
  		<label class="btn btn-outline-success btn-sm" id="<%= todo.getId() %>-label" for="<%= todo.getId() %>"><%if(todo.isCompleted()) {%> Done <%} else { %> Not Done <%} %></label>
      </td>
      <td>
      	<a class="btn btn-secondary btn-sm" href="edit?id=<%=todo.getId() %>" role="button">Edit</a>
      	<a class="btn btn-danger btn-sm" href="delete?id=<%=todo.getId() %>" role="button">Delete</a>
      </td>
    </tr>
    <%
     }
    %>
  </tbody>
</table>
<a class="btn btn-primary btn-lg" href="create" role="button">Add Todo</a>
</div>

<%
	if (isError) {
		out.write("<label> An Error Occurred!</label>");
	}
%>

<script>
function toggleTodo(id) {
	var element = document.getElementById(id + "-label")
	if(element.innerHTML == "Done")
		element.innerHTML = "Not Done";
	else 
		element.innerHTML = "Done";
	var http = new XMLHttpRequest();
	var url = window.location.href;
	url = url.substring(0, url.lastIndexOf('/'));
	url = url + "/toggle?id=" + id;
	http.open("GET", url);
	http.send();
}
</script>
	
<%@include file="footer.jsp" %>