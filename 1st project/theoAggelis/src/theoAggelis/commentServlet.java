package theoAggelis;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class commentServlet
 */
@WebServlet("/commentServlet")
public class commentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html; charset=ISO-8859-7");
		
	    
	    
	    
	    
	    try{
	    	
	    	
	    	if ((request.getParameter("name") ==null) || (request.getParameter("email")==null)
	    			|| (request.getParameter("comment")==null)) {
	    		// response.sendRedirect("/theoAggelis/index.jsp");
	    	      return;
	    	    }
	    	String email = request.getParameter("email");
		    String name = request.getParameter("name");
		    String comment = request.getParameter("comment");
		    email=new String(email.getBytes("ISO-8859-1"), "ISO-8859-7");
	    	name=new String(name.getBytes("ISO-8859-1"), "ISO-8859-7");
	    	comment=new String(comment.getBytes("ISO-8859-1"), "ISO-8859-7");
	    	
	    	
	    	sqlConect conn = new sqlConect();
	    	conn.open();
	    	conn.commentIns(email, name, comment);
	    	conn.close();
	    	response.sendRedirect("/theoAggelis/index.jsp");
	    	
	    }catch (Exception ex) {
	        ex.getMessage();
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
