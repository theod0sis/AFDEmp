<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="domain.User"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="domain.Recipe"%>
<%@ page import="dao.FavDAO"%>


<%
	Recipe recipe = (Recipe) request.getAttribute("recipe");
	if (recipe == null) {
		response.sendRedirect(request.getContextPath() + "/");
		return;
	}
	FavDAO fav = new FavDAO ();
	
	
%>

<%@ include file="header.html"%>

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
				<%
					if (session.getAttribute("user") != null) {
				%>
				<a class="favicon" href="favorite"> <i class="material-icons">restaurant</i>
					Οι Συνταγές μου
				</a>
				<%
					}
				%>
				<%
					if (session.getAttribute("user") != null
							&& ((User) session.getAttribute("user")).getAdmin()==1) {
				%>
				<a class="comicon" href="comments"> <i class="material-icons">comment</i>
					Σχόλια
				</a>
				<%
					}
				%>

				<%
					if (session.getAttribute("user") == null) {
				%>
				<form class="navbar-form navbar-right" role="form" action="login"
					method="POST">
					<div class="form-group">
						<input id="loginInput" type="email" name="email"
							placeholder="Email" class="form-control" required> <label
							class="login-field-icon material-icons">perm_identity</label>
					</div>
					<div class="form-group">
						<input type="password" name="password" placeholder="Κωδικός"
							class="form-control" required> <label
							class="login-field-icon material-icons">lock</label>
					</div>
					<button type="submit" class="btn btn-secondary">Είσοδος</button>
				</form>

				<%
					} else {
				%>

				<form class="navbar-form navbar-right" role="form" method="POST"
					action="login">
					<div class="form-group hidden">
						<input type="text" name="logout" value="do" placeholder="Email"
							class="form-control" required> <label
							class="login-field-icon material-icons">perm_identity</label>
					</div>
					<p>
						<span class="welcome">Welcome &nbsp;</span><span class="redfont"><%=((User) session.getAttribute("user")).getName()%></span>
					</p>
					<button type="submit" id="btn_logout" class="btn btn-secondary">Έξοδος</button>
				</form>



				<%
					}
				%>
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

	<%
		if (session.getAttribute("user") == null) {
	%>
	<a style="position: fixed; top: 10%; right: 3%; z-index: 10;"
		class="btn btn-primary btn-lg" href="register" role="button">Εγγραφή</a>
	<%
		}
	%>

	<section class="recipe">
		<div class="container">
			<h1 class="title"><%=recipe.getName()%></h1>
			<%if(recipe.getFavs()==0){	
				if (session.getAttribute("user") != null){
				%><form action="favorite" method="POST">
				<h3>
					(Γίνε ο πρώτος που του
					<button class="title" name="recid" value="<%=recipe.getId()%>"
						type="submit">αρέσει!</button>
					)
				</h3>


				<%}else{				
				%>


				<h3>
					(Γίνε ο πρώτος που του αρέσει!) <span class="title"><a
						href="#loginInput">συνδέσου</a> ή <a class="title" href="register">γίνε
							μέλος</a></span>
				</h3>
				<%}}else if(recipe.getFavs()==1){				
				%>
				<h3>
					(Αρέσει σε
					<%=recipe.getFavs()%>
					χρήστη)
				</h3>
				<%}else{%>

				<h3>
					(Αρέσει σε
					<%=recipe.getFavs()%>
					χρήστες)
				</h3>
				<%}	%>
				<div class="row">
					<div
						class="col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-3 col-md-6">
						<img alt="<%=recipe.getName()%>" src="images/<%=recipe.getImg()%>">
					</div>
				</div>
				<div class="row">
					<div
						class="col-xs-12 col-sm-offset-1 col-sm-10 col-md-offset-2 col-md-8 rec-data">
						<div class="col-xs-4 text-center img-box">
							<h1>
								<span class="glyphicon glyphicon-time">
							</h1>
							<h2><%=recipe.getDuration()%>΄

							</h2>
							<p>Χρόνος Εκτέλεσης</p>
						</div>


						<div class="col-xs-4 text-center img-box data-center">


							<%
								if (session.getAttribute("user") == null) {
							%>
							<h1>
								<span class="glyphicon glyphicon-heart grey"></span>
							</h1>
							<h3>Προσθήκη στα Αγαπημένα</h3>
							<p style="color: red">(Πρέπει να συνδεθείτε)</p>
							<%
								}else{
									%>



							<form action="favorite" method="POST">

								<% if(!(fav.isFav(((User)session.getAttribute("user")).getId(),Integer.parseInt(request.getParameter("id")))))
							{ %>
								<button name="recid" value="<%=recipe.getId()%>" type="submit">
									<h1>
										<span class="glyphicon glyphicon-heart white"></span>
									</h1>
								</button>

								<h3>Προσθήκη στα Αγαπημένα</h3>
								<%}else{%>
								<button name="recid" value="<%=recipe.getId()%>" type="submit">
									<h1>
										<span class="glyphicon glyphicon-heart red"></span>
									</h1>
								</button>

								<h3>Διαγραφή από Αγαπημένα</h3>
								<%} %>
							</form>

							<%} %>
						</div>


						<div class="col-xs-4 text-center img-box">
							<h1>
								<span class="glyphicon glyphicon-scale"></span>
							</h1>
							<h2><%=recipe.getCalories()%><span style="font-size: 16px;">
									kcal</span>
							</h2>
							<p>Θερμίδες</p>
						</div>
					</div>
				</div>



				<div class="row">

					<div
						class="col-xs-12 col-sm-offset-1 col-sm-10 col-md-3 col-md-push-8 ing-text rec-text">
						<h1>Υλικά</h1>
						<p><%=recipe.getIngredientText()%>
						</p>
					</div>

					<div
						class="col-xs-12 col-sm-offset-1 col-sm-10 col-sm-offset-1 col-md-7 rec-text col-md-pull-5">
						<h1>Μέθοδος Εκτέλεσης</h1>
						<p><%=recipe.getDescription()%>
						</p>
					</div>
				</div>
		</div>
	</section>

	<%@ include file="footer.html"%>
</body>
</html>