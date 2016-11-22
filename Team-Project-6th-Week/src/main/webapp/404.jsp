<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="domain.User"%>
<%@ page import="java.util.ArrayList"%>

<%@ include file="header.html"%>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<input type="checkbox" id="checkbox_toggle">
			<div class="navbar-header">
				<label class="navbar-toggle icon-bar" for="checkbox_toggle"><i
					class="material-icons">menu</i></label> <a class="navbar-brand"
					href="<%=request.getContextPath()+"/"%>"> <img
					src="images/logo.png" alt="uCook">
					<p>uCook</p>
				</a>


			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<% if(session.getAttribute("user")!=null) {%>
				<a class="favicon" href="favorite"> <i class="material-icons">restaurant</i>
					Οι Συνταγές μου
				</a>
				<%} %>
				<% if(session.getAttribute("user")!=null&&((User)session.getAttribute("user")).getAdmin()==1) {%>
				<a class="comicon" href="comments"> <i class="material-icons">comment</i>
					Σχόλια
				</a>
				<%} %>

				<% if(session.getAttribute("user")==null) {%>
				<form class="navbar-form navbar-right" role="form" action="login"
					method="POST">
					<div class="form-group">
						<input type="email" name="email" placeholder="Email"
							class="form-control" required> <label
							class="login-field-icon material-icons">perm_identity</label>
					</div>
					<div class="form-group">
						<input type="password" name="password" placeholder="Κωδικός"
							class="form-control" required> <label
							class="login-field-icon material-icons">lock</label>
					</div>
					<button type="submit" class="btn btn-secondary">Είσοδος</button>
				</form>

				<%}else{ %>

				<form class="navbar-form navbar-right" role="form" method="POST"
					action="login">
					<div class="form-group hidden">
						<input type="text" name="logout" value="do" placeholder="Email"
							class="form-control" required> <label
							class="login-field-icon material-icons">perm_identity</label>
					</div>
					<p>
						<span class="welcome">Welcome &nbsp;</span><span class="redfont"><%=((User)session.getAttribute("user")).getName()%></span>
					</p>
					<button type="submit" id="btn_logout" class="btn btn-secondary">logout</button>
				</form>



				<%} %>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>

	<%if(session.getAttribute("valid")!=null){%>
	<div
		style="position: absolute; right: 7%; margin-top: 50px; background: transparent; text-align: right">
		<h4 style="margin: 10px 45px; color: red">Username or Password
			provided are not Correct!</h4>
	</div>
	<%} session.setAttribute("valid", null); %>

	<% if(session.getAttribute("user")==null) {%>
	<a style="position: fixed; top: 10%; right: 3%; z-index: 10;"
		class="btn btn-primary btn-lg" href="register" role="button">Εγγραφή</a>
	<%} %>
	<div class="jumbotron">
		<div class="container-fluid  text-center wrapper-404">
			<div class="row">
				<div
					class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-3 col-md-6 errormesage404">
					<img src="images/logo2.png">
					<h1 class="tetrako">404</h1>
					<h1>Δεν βρήκαμε τη σελίδα :(</h1>
					<a href="<%=request.getContextPath()+"/"%>"><p>Πάμε να
							ξαναδοκιμάσουμε από την αρχή;</p></a>
				</div>

			</div>
		</div>
	</div>


	<%@ include file="footer.html"%>
</body>
</html>