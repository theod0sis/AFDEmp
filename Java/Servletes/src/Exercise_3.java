

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exercise_3
 */
@WebServlet("/Exercise_3")
public class Exercise_3 extends HttpServlet {
	 private Counter mCnt = new Counter();
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercise_3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		mCnt.increment();
		if (!(mCnt.ifprime(mCnt))){
		response.getWriter().append("Success");
		}
		else{
			response.sendRedirect("/Servlets/Exercise_2");
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
