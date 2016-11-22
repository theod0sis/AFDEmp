package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);


		response.sendRedirect(request.getContextPath()+"/");


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

		HttpSession session = request.getSession(false);

		if (request.getParameter("logout") != null) {
			session.invalidate();
			response.sendRedirect(referer);
		} 

		else {
			String password = request.getParameter("password");
			String email = request.getParameter("email");

			try {
				if (email == null || email.length() == 0) {

					response.sendRedirect(request.getContextPath()+"/");
				}

				if (password == null || password.length() == 0) {

					response.sendRedirect(request.getContextPath()+"/");
				}

				UserDAO uDao = new UserDAO();

				User user = uDao.find(email);

				if (user != null && BCrypt.checkpw(password,user.getPassword())) {

					session.setAttribute("user", user);

				}

				else {

					session.setAttribute("valid", "false");

				}
				
				response.sendRedirect(referer);
			} catch (Exception e) {

				request.setAttribute("errormessage", e.getMessage());

				return;
			}

		}
	}
}
