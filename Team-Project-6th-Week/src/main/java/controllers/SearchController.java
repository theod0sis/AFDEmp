package controllers;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.*;
import domain.SymbolMaps;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/search")
public class SearchController extends HttpServlet {
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
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		if ((request.getParameter("search")==null) && (request.getParameter("catid")==null)){
			request.getRequestDispatcher("/search.jsp").forward(request, response);
			return;
		}

		HttpSession session = request.getSession(true);


		try{

			if (request.getParameter("search")!=null){
				String search = request.getParameter("search");
				if (search == null || search.length() == 0) {

					response.sendRedirect(request.getRequestURI());
					return;
				}
							
				String [] ing=search.replaceAll("[^\\p{L}]", " ").replaceAll("^\\s+", "").split("\\s+");
				
				for(int i=0;i<ing.length;i++){
					ing[i]=SymbolMaps.changeLetters((SymbolMaps.changeExpr(ing[i])));
					if(ing[i].equalsIgnoreCase("καβλα")){ing[i]="Είσαι!!";}  //!!!!
				}
				
				
				RecipeDAO recipes=new RecipeDAO();
				request.setAttribute("recipes", recipes.findByIng(ing));
				request.setAttribute("search", String.join(", ", ing));
				
				request.getRequestDispatcher("/search.jsp").forward(request, response);
				
				// TWRA NA PERASOUME TA RECIPES ME REQUEST?? EGW ETSI LEW OXI ME SESSION GIANNI PERIMENW APANTISI
				
				
				
				
			}else{//  EDW KANEI SEARCH ME KATIGORIES AMA EXEI PERASEI PARAMETRO CATEGORY ID
				
				
				// PREPEI NA DOUME LIGO ME TS KARTES. THA EINAI BUTTONS FORMAS H THA EINAI <a> URLS KAI THA PERNAME SAN GET TO ID TS KATIOGRIAS PANW STO URL KAI AMA TO KANOUME STO URL PREPEI AFTO NA PAEI STO GET GT TO EXW STO POST
				if(request.getParameter("catid")!=null&&request.getParameter("catid").matches("^[0-9]")){
				RecipeDAO recipes=new RecipeDAO();
				
			
				int categoryId=Integer.parseInt(request.getParameter("catid"));
				
				request.setAttribute("recipes", recipes.findByCat(categoryId));
				request.getRequestDispatcher("/search.jsp").forward(request, response);
				}else{
					response.sendRedirect(request.getRequestURI());
					return;
				}
				
		
				
			}
		} catch (Exception e) {

			request.setAttribute("errormessage", e.getMessage());
			System.out.println(e.getMessage());
			return;
		}
		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(true);
	

		request.getRequestDispatcher("/search.jsp").forward(request, response);
		return;
		


	}
}

