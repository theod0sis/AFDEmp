

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import theoAggelis.sqlConect;

/**
 * Servlet implementation class validateEmail
 */
@WebServlet("/validateEmail")
public class validateEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validateEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("email") ==null) {
   		 response.sendRedirect("/theoAggelis/index.jsp");
   	      return;
   	    }
		
		String targetId = request.getParameter("email");
		   
		   if ((targetId != null) )
		   {
			   response.setContentType("text/html; charset=ISO-8859-7");	    			   
			    try{
			    	targetId=new String(targetId.getBytes("ISO-8859-1"), "ISO-8859-7");
				    sqlConect conn = new sqlConect();
			    	conn.open();
			    	
			    	if (conn.emailExist(targetId)){
				     response.setHeader("valid", "false");
			    	}else{
			    		response.setHeader("valid", "true");
			    		
			    	}
			    	conn.close();
			    }catch (Exception ex) {
			        ex.getMessage();
			        }
		      
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
