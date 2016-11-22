package controllers;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import domain.BCrypt;
import domain.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
	
		
		request.getRequestDispatcher("/register.jsp").forward(request, response);
			
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String referer = request.getHeader("Referer");
		
		HttpSession session = request.getSession(true);
 
		 if(session.getAttribute("user")!=null)	{
			 response.sendRedirect(request.getContextPath()+"/");
				
				return; 
		 }
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		try{
		if (email == null || email.length() == 0) {
			
			response.sendRedirect(request.getRequestURI());
			return;
		}

		if ((pass1 == null || pass1.length() == 0)||(pass2 == null || pass2.length() == 0)||(!pass1.equals(pass2))) {
			request.setAttribute("register", "pass");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		
         if (username == null || username.length() == 0) {
			
			response.sendRedirect(request.getRequestURI());
			return;
		}		
		
         UserDAO uDao = new UserDAO();
			
			
			if(uDao.register(new User(username, email, BCrypt.hashpw(pass1, BCrypt.gensalt())))){
				session.setAttribute("user", uDao.find(email));
				
				response.sendRedirect(request.getContextPath()+"/");
				return;				
			}
			else{
				request.setAttribute("exists", "true");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
         
	
	
			} catch (Exception e) {

				request.setAttribute("errormessage", e.getMessage());

				return;
			}

		}
	}

