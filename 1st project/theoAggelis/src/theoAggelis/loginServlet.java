package theoAggelis;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=ISO-8859-7");

	    
	    
	    sqlConect conn = new sqlConect();
	    
	    try{
	    	

	    	if ((request.getParameter("email") ==null) || (request.getParameter("password")==null)) {
	    		 response.sendRedirect("/theoAggelis/index.jsp");
	    	      return;
	    	    }
	    	String email = request.getParameter("email");
		    String password = request.getParameter("password");
		    email=new String(email.getBytes("ISO-8859-1"), "ISO-8859-7");
	    	password=new String(password.getBytes("ISO-8859-1"), "ISO-8859-7");
	    	
	    	conn.open();
	    	if(conn.findUser(email, password)){
	    	conn.close();
	        HttpSession session = request.getSession(false);
	        session.setAttribute("email", email);
	        response.sendRedirect("/theoAggelis/index.jsp");
	        return;
	    	}
	    	conn.close();
	    	response.sendRedirect("/theoAggelis/index.jsp");
	    	return;
	    }catch (Exception ex) {
	      ex.printStackTrace();
	        }
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
