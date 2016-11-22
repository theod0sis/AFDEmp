package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RecipeDAO;
import domain.Recipe;

/**
 * Servlet implementation class RecipeController
 */
@WebServlet("/recipe")
public class RecipeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeController() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(true);
		
		if(!(request.getParameter("id")==null)&&request.getParameter("id").matches("[0-9]+")){
			
			int recipeId = Integer.parseInt(request.getParameter("id"));
			
			RecipeDAO rec = new RecipeDAO();

			try {
				Recipe recipe = rec.findById(recipeId);
				request.setAttribute("recipe", recipe);
				request.getRequestDispatcher("/recipe.jsp").forward(request, response);
				
				
			} catch (Exception e) {
				
				request.setAttribute("errormessage", e.getMessage());
				
				return;
			}
					
		}else{
			response.sendRedirect(request.getContextPath()+"/");
		}
					
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
		HttpSession session = request.getSession(true);


		response.sendRedirect(request.getContextPath()+"/");
			
	}

}
