<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="domain.User"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="domain.*"%>

<%
    ArrayList<Recipe> list=(ArrayList<Recipe>)request.getAttribute("recipes");
      Recipe recipe;
%>



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
					<button type="submit" id="btn_logout" class="btn btn-secondary">Έξοδος</button>
				</form>



				<%} %>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>

	<%if(session.getAttribute("valid")!=null){%>
	<div
		style="position: absolute; right: 7%; margin-top: 50px; background: transparent; text-align: right">
		<h4 style="margin: 10px 45px; color: red">To e-mail ή ο κωδικός
			πρόσβασης είναι λάθος.</h4>
	</div>
	<%} session.setAttribute("valid", null); %>

	<% if(session.getAttribute("user")==null) {%>
	<a style="position: fixed; top: 10%; right: 3%; z-index: 10;"
		class="btn btn-primary btn-lg" href="register" role="button">Εγγραφή</a>
	<%} %>
	<section class="search"
		<%if(request.getParameter("search")!=null||request.getParameter("catid")!=null){%>
		style="height: 40%;" <%} %>>
		<div class="jumbotron">

			<div class="container">
				<%if(request.getParameter("search")==null&&request.getParameter("catid")==null){%><div
					class="row">
					<h1>Τι θα φάτε σήμερα;</h1>
				</div>
				<%} %>

				<div class="row">
					<div class="col-xs-12 col-sm-offset-3 col-sm-6">
						<form role="form" action="search" method="GET">
							<input id="search" name="search"
								<%if(request.getParameter("search")!=null){%>
								value="<%=(String)request.getAttribute("search")%>" <%} %>
								placeholder="Tα υλικά σας, π.χ. ντομάτα, κρέας ...">
							<button id="submit" type="submit" class="material-icons">search</button>
						</form>
					</div>

				</div>
			</div>
		</div>
	</section>
	<!-- Main jumbotron for a primary marketing message or call to action -->

	<%if(request.getParameter("search")!=null ||request.getParameter("catid")!=null) {%>
	<section id="results">
		<div class="container">
			<div class="row">
				<%  if (list==null || list.isEmpty()) {
					out.println("<h1 style=\"text-align: center;margin-top:25px;\">Δεν βρέθηκαν Συνταγές</h1>");
				} else {
					if(list.size()==1){
					out.println("<h1 style=\"text-align: center;margin-top:35px;\">Bρέθηκε "+list.size()+" συνταγή</h1>");
					}else{
						out.println("<h1 style=\"text-align: center;margin-top:35px;\">Bρέθηκαν "+list.size()+" συνταγές</h1>");
					}for (int i = 0; i < list.size(); i++) {
						recipe = list.get(i);
			%>

				<div
					class=" col-xs-offset-1 col-xs-10 col-sm-offset-0 col-sm-6 col-md-4 col-lg-4">
					<a href="recipe?id=<%=recipe.getId()%>">
						<div class="card">
							<div class="card-image">
								<span class=recinfo><%=recipe.getFavs() %></span><span
									id="heart" class="glyphicon glyphicon-heart"></span> <img
									src="images\<%=recipe.getImg()%>">
							</div>
							<div class="card-content">
								<h2><%=recipe.getName()%></h2>
							</div>
							<div class="row">
								<div class="col-xs-6 text-center img-box">
									<h3>
										<span class="glyphicon glyphicon-time"></span>
									</h3>
									<h3 class=recinfo><%=recipe.getDuration()%></h3>
									<h4>Λεπτά</h4>
								</div>


								<div class="col-xs-6 text-center img-box">
									<h3>
										<span class="glyphicon glyphicon-scale"></span>
									</h3>
									<h3 class="recinfo"><%=recipe.getCalories()%></h3>
									<h4>Θερμίδες</h4>
								</div>
							</div>
						</div>
					</a>
				</div>

				<% }} %>

			</div>
		</div>

	</section>
	<%} %>


	<section id="categories">
		<div class="container text-center">
			<h1>Επιλέξτε κατηγορία συνταγής</h1>
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-4 test">
					<a href="search?catid=1">
						<div class="image-round">
							<img src="images/kreatika.jpg" alt="Random Name"><br>
						</div>
						<h2>Κρεατικά</h2>
					</a>

				</div>
				<div class="col-xs-12 col-sm-6 col-md-4 test">
					<a href="search?catid=2">
						<div class="image-round">
							<img src="images/psariakaithalassina.jpg" alt="Random Name"><br>
						</div>
						<h2>Θαλασσινά & Ψάρια</h2>
					</a>

				</div>
				<div class="col-xs-12 col-sm-6 col-md-4 test">
					<a href="search?catid=3">
						<div class="image-round">
							<img src="images/zymarika.jpg" alt="Random Name"><br>
						</div>
						<h2>Ζυμαρικά</h2>
					</a>

				</div>
				<div class="col-xs-12 col-sm-6 col-md-4 test">
					<a href="search?catid=4">
						<div class="image-round">
							<img src="images/ospria.jpg" alt="Random Name"><br>
						</div>
						<h2>Όσπρια</h2>
					</a>

				</div>
				<div class="col-xs-12 col-sm-6 col-md-4 test">
					<a href="search?catid=5">
						<div class="image-round">
							<img src="images/salates.jpg" alt="Random Name"><br>
						</div>
						<h2>Σαλάτες</h2>
					</a>

				</div>
				<div class="col-xs-12 col-sm-6 col-md-4 test">
					<a href="search?catid=6">
						<div class="image-round">
							<img src="images/gluka.jpg" alt="Random Name"><br>
						</div>
						<h2>Γλυκά</h2>
					</a>

				</div>
			</div>
		</div>
	</section>

	<%@ include file="footer.html"%>
</body>
</html>
