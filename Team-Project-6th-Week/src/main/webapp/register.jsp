<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>

<%@ include file="header.html"%>

<%
	if (session.getAttribute("user") != null) {
		response.sendRedirect(request.getContextPath() + "/");
		return;
	}
%>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<input type="checkbox" id="checkbox_toggle">
			<div class="navbar-header">
				<label class="navbar-toggle icon-bar" for="checkbox_toggle"><i
					class="material-icons">menu</i></label> <a class="navbar-brand"
					href="<%=request.getContextPath() + "/"%>"> <img
					src="images/logo.png" alt="uCook">
					<p>uCook</p>
				</a>


			</div>
			<div id="navbar" class="navbar-collapse collapse">



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


			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>
	<%
		if (session.getAttribute("valid") != null) {
	%>
	<div
		style="position: absolute; right: 7%; margin-top: 50px; background: transparent; text-align: right">
		<h4 style="margin: 10px 45px; color: red">To e-mail ή ο κωδικός
			πρόσβασης είναι λάθος!</h4>
	</div>
	<%
		}
		session.setAttribute("valid", null);
	%>
	<section id="teo">
		<div class="jumbotron">
			<div class="container">
				<div class="row">
					<form role="form" class='form-horizontal' action="register"
						method="POST">
						<div
							class="col-xs-12 col-sm-offset-3 col-sm-6 col-md-offset-4 col-md-4">
							<div class="card">
								<h1>Εγγραφή Χρήστη</h1>
								<div class='form-group'>
									<div class='col-md-12'>
										<div class='form-group internal'>
											<input class='form-control' id='id_first_name'
												name="username" placeholder='Επιθυμητό όνομα χρήστη'
												required="" type='text'>
										</div>
									</div>
								</div>
								<div class='form-group'>
									<div class='col-md-12'>
										<div class='form-group internal'>
											<input class='form-control' id='id_first_name' name="email"
												placeholder='Το Email σας' required="" type='email'>
										</div>
									</div>
								</div>
								<div class='form-group'>
									<div class='col-md-12'>
										<div class='form-group internal'>
											<input class='form-control' id='id_first_name' name="pass1"
												placeholder='Κωδικός πρόσβασης' required="" type='Password'>
										</div>
									</div>
								</div>
								<div class='form-group'>
									<div class='col-md-12'>
										<div class='form-group internal'>
											<input class='form-control' id='id_first_name' name="pass2"
												placeholder='Επαναλάβατε τον κωδικό πρόσβασης' required=""
												type='Password'>
										</div>
									</div>
								</div>
								<div class='form-group'>
									<div class='col-md-12'>
										<button class='btn btn-success btn-lg' type='submit'>Υποβολή</button>
									</div>
								</div>
								<%
									if (request.getAttribute("exists") == "true") {
								%>

								<div style="background: transparent; text-align: center">
									<h4 style="color: red">Το e-mail υπάρχει ήδη.</h4>
								</div>
								<%
									} else if (request.getAttribute("register") == "pass") {
								%>
								<div style="background: transparent; text-align: center">
									<h4 style="color: red">Οι κωδικοί δεν είναι ίδιοι.</h4>
								</div>

								<%
									}
								%>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</section>
	<%@ include file="footer.html"%>
</body>
</html>