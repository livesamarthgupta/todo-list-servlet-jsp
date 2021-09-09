<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
boolean isLoggedIn = request.getSession().getAttribute("username") != null;
%>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<title>Todo App</title>
<style>
.font-white {
	color: white;
}
</style>
</head>
<body>

	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Todoist</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
				aria-controls="offcanvasNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="offcanvas offcanvas-end bg-dark font-white" tabindex="-1"
				id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
				<div class="offcanvas-header">
					<h5 class="offcanvas-title" id="offcanvasNavbarLabel">Todoist</h5>
					<button type="button" class="btn-close text-reset"
						data-bs-dismiss="offcanvas" aria-label="Close"></button>
				</div>
				<div class="offcanvas-body">
					<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
						<%
						if (!isLoggedIn) {
						%>
						<li class="nav-item"><a class="nav-link" aria-current="page" href="login">Login</a></li>
						<li class="nav-item"><a class="nav-link" href="signup">SignUp</a></li>
						<%
						} else {
						%>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="todos">Todos</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="logout">Logout</a></li>
						<%
						}
						%>
					</ul>
				</div>
			</div>
		</div>
	</nav>

	<div class="container">