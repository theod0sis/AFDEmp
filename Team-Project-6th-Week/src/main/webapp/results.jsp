<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="dao.CommentsDao"%>
<%@ page import="domain.Comment"%>
<%@ page import="domain.User"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Calendar"%>


<%!DateFormat format = new SimpleDateFormat("yyyy-MM-dd");%>
<%Calendar cal = Calendar.getInstance();
	int i=0;
	
	Comment comment;
	CommentsDao cDao = new CommentsDao();
	String dateFrom=request.getParameter("datefrom");
	String dateTo=request.getParameter("dateto");
	String order=request.getParameter("order");
	if(dateFrom==null||dateTo==null||order==null){	
		dateFrom ="";
		dateTo ="";
		order ="";
	}	
	
	List<Comment> CList = cDao.bring(dateFrom,dateTo,order); %>

<%@ include file="header.html"%>

<%
if(session.getAttribute("user")==null){
    	response.sendRedirect(request.getContextPath()+"/");
    	return;
    }
else if(((User)session.getAttribute("user")).getAdmin()!=1){
	response.sendRedirect(request.getContextPath()+"/");
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
				<% if(session.getAttribute("user")!=null&&(((User)session.getAttribute("user")).getAdmin()==1)) {%>
				<a class="comicon" href="comments"> <i class="material-icons">comment</i>
					Σχόλια
				</a>
				<%} %>


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




			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>


	<section class="results">
		<h2>
			Βρέθηκαν
			<%=CList.size()%>
			σχόλια
		</h2>

		<div class="container-fluid">
			<div class="row">
				<div
					class="col-xs-12 col-sm-offset-1 col-sm-10 col-md-offset-2 col-md-8">
					<form class="form" role="form" method="GET" action="comments">
						<div class="form-group">
							<label>Εμφάνιση σχολίων από:</label><input type="date"
								name="datefrom" class="form-control"
								value="<% if(request.getMethod().equalsIgnoreCase("GET")){
									out.print(dateFrom);}
								else{}
								%>">
						</div>
						<div class="form-group">
							<label>Εώς:</label><input type="date" name="dateto"
								class="form-control"
								value="<% if(dateTo!=""){
									out.print(dateTo);}
								else{out.print(format.format(cal.getTime()));}
							   %>"
								max="<%=format.format(cal.getTime())%>">
						</div>
						<div class="form-group">
							<label for="sel1">Σειρά εμφάνισης:</label> <select
								class="form-control" name="order" id="sel1">
								<option>Νέα πρώτα</option>
								<%if(order.equals("Old First")){
									out.println("<option selected=\"selected\">Παλιά πρώτα</option>");}
								else{
									out.println("<option>Παλιά πρώτα</option>");
								}
								%>

							</select>
						</div>
						<button type="submit" class="btn">Αναζήτηση</button>
					</form>
				</div>
			</div>
			<%
				
				if (CList.isEmpty()) {
					out.println("<h1>No Comments matching your criteria</h1>");
				} else {
					for (i = 0; i < CList.size(); i++) {
						comment = CList.get(i);
			%>
			<form method="Post" action="comments">
				<div class="row">
					<div
						class="col-xs-12 col-sm-offset-1 col-sm-10 col-md-offset-2 col-md-8">
						<div class="card vertical">
							<div class="card-title">

								<p class="left"><%=i+1%>.
									<%=comment.getName()%>
									(<%=comment.getEmail()%>)
								</p>
								<p class="right"><%=comment.getDatetimeHtml()%></p>
								<input type="text" name="delete" value="<%=comment.getId()%>">
								<button title="Permanently delete this comment" name=""
									type="submit">
									<i class="material-icons">delete_forever</i>
								</button>
							</div>

							<p
								style="height:3px;background: linear-gradient(to left, rgba(<%=(int)(Math.random()*256)%>,<%=(int)(Math.random()*256)%>,<%=(int)(Math.random()*256)%>,<%=0.3+Math.random()*0.7%>) ,rgba(<%=(int)(Math.random()*256)%>,<%=(int)(Math.random()*256)%>,<%=(int)(Math.random()*256)%>,<%=0.3+Math.random()*0.7%>));">&nbsp;</p>
							<div class="card-content">
								<p><%=comment.getComment()%></p>
							</div>
						</div>

					</div>
				</div>
			</form>

			<%
				}
				}
			%>

		</div>
	</section>




	<%@ include file="footer.html"%>

</body>
</html>
