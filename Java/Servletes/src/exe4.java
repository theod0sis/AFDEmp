

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
/**
 * Servlet implementation class exe4
 */
@WebServlet("/exe4")
public class exe4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public exe4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		handleRequest(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		handleRequest(request, response);
	}
	
	public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
		         PrintWriter out = res.getWriter();
		 
		         res.setContentType("text/plain");
		 
		  
		 
		         Enumeration<String> parameterNames = req.getParameterNames();
		 
		  
		 
		         while (parameterNames.hasMoreElements()) {
		 
		             String paramName = parameterNames.nextElement();
		 
		             out.write(paramName);
		 
		             out.write("n");
		 
		  
		
		             String[] paramValues = req.getParameterValues(paramName);
		 
		             for (int i = 0; i < paramValues.length; i++) {
		 
		                 String paramValue = paramValues[i];
		 
		                 out.write("t" + paramValue);
		 
		                 out.write("n");
		 
		             }
		 
		  
		 
		         }
		 
		  
		 
		         out.close();
		 
		  
		 
		     }


}
