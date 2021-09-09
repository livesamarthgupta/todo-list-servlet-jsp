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
</style>

<div class="text-center center" style="width:50%">

	<main class="form-signin">
		<form action="login" method="post">
			<img class="mb-4" src="content/to-do-list.png" alt="" width="72"
				height="65">
			<h1 class="h3 mb-3 fw-normal">Login to continue:</h1>

			<div class="form-floating">
				<input type="text" class="form-control" id="floatingInput" name="username"
					placeholder="username"> <label for="floatingInput">Username</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="floatingPassword" name="password"
					placeholder="Password"> <label for="floatingPassword">Password</label>
			</div>

			<div class="mb-3">
					<%if(isError) { 
						out.write("<label> An Error Occurred!</label>");
					} %>
			</div> 
			<button class="w-100 btn btn-lg btn-primary" type="submit">Log-in</button>
		</form>
	</main>

</div>


<%@ include file="footer.jsp"%>