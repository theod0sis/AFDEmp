package controllers;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.*;
import domain.User;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/favorite")
public class FavController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			String referer = request.getHeader("Referer");
			HttpSession session = request.getSession(true);

			if(session.getAttribute("user")==null){

				response.sendRedirect(request.getContextPath()+"/");
				return;

			}else{ 
				FavDAO fav = new FavDAO ();
				User user= ((User)session.getAttribute("user"));
				if(!(fav.isFav(user.getId(),Integer.parseInt(request.getParameter("recid"))))){
					fav.makeFav(user.getId(),Integer.parseInt(request.getParameter("recid")));
				}else{
					fav.deleteFav(user.getId(),Integer.parseInt(request.getParameter("recid")));
				}
				response.sendRedirect( referer);
				return;
			}

		}catch (Exception e) {

			request.setAttribute("errormessage", e.getMessage());
			response.sendRedirect(request.getContextPath()+"/");
			return;
		}



	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		try{
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");

			HttpSession session = request.getSession(true);
			if(session.getAttribute("user")== null){
				
				response.sendRedirect(request.getContextPath()+"/");
				return;
			}else{
				FavDAO fav = new FavDAO ();
				User user= ((User)session.getAttribute("user"));
				
				request.setAttribute("recipes",fav.findFav(user.getId()));
				request.getRequestDispatcher("/favorite.jsp").forward(request, response);		
			}


		}catch (Exception e) {

			request.setAttribute("errormessage", e.getMessage());

			return;
		}


	}
}

