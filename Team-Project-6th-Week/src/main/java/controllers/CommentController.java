package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import dao.CommentsDao;
import domain.User;
import domain.Comment;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/comments")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentController() {
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
		if(session.getAttribute("user")!=null&&((User)session.getAttribute("user")).getAdmin()==1)  {

			request.getRequestDispatcher("/results.jsp").forward(request, response);
			return;
		} else {


			response.sendRedirect(request.getContextPath()+"/");
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

		RequestDispatcher succdis = request.getRequestDispatcher("/results.jsp");
		HttpSession session = request.getSession(false);

		// PrintWriter out = new PrintWriter(response.getWriter(), true);
		if (request.getParameter("delete") != null) {

			int id = Integer.parseInt(request.getParameter("delete"));
			CommentsDao cDao = new CommentsDao();
			try {
				cDao.delete(id);
				succdis.forward(request, response);
			} catch (Exception e) {
				request.setAttribute("errormessage", e.getMessage());

				return;
			}


		}
		else{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String comments = request.getParameter("comments");

		// define RequestDispatcher object to forward any errors

		// define RequestDispatcher object to forward if data are correct and
		// successfully stored in database


		try {

			if (name == null || name.length() == 0) {
				response.sendRedirect(request.getContextPath()+"/");
				return;

			}

			if (email == null || email.length() == 0) {
				response.sendRedirect(request.getContextPath()+"/");
				return;

			}

			if (comments == null || comments.length() == 0) {
				response.sendRedirect(request.getContextPath()+"/");
				return;

			}

			Comment comment = new Comment(name, email, comments);

			CommentsDao cDao = new CommentsDao();

			cDao.post(comment); // open connection






			session.setAttribute("subm", "true");
			response.sendRedirect(request.getContextPath()+"/");

			//send mail with delay 5 seconds
			final String subject = "uCook";
			final String body = "You have an new comment from: "+name+" ("+email+") \r\n\r\n" + comments;
			new java.util.Timer().schedule(
			        new java.util.TimerTask() {
			            @Override
			            public void run() {


			    			sendFromGMail(subject, body);
			            }
			        },
			        5000
			);





		} catch (Exception e) {

			request.setAttribute("errormessage", e.getMessage());

			return;
		}

		}
	}

	private static void sendFromGMail(String subject, String body) {


	    String PASSWORD = "@@@@@@"; // GMail password
	    String RECIPIENT="uCookafdemp@gmail.com";
		String RECIPIENT1 = "theodsis.aggelis@gmail.com";
		String RECIPIENT2 = "mitropoui@windowslive.com";
		String RECIPIENT3 = "omhroszymarakhs@gmail.com";
		String from = "comment@ucook.com";
		String pass = PASSWORD;
		String[] to = { RECIPIENT,RECIPIENT1,RECIPIENT2,RECIPIENT3 }; // list of recipient email addresses

		Properties props = System.getProperties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");




		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication("uCookafdemp", "uCook2016");
		    }
		});
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(from));
			InternetAddress[] toAddress = new InternetAddress[to.length];

			// To get the array of addresses
			for( int i = 0; i < to.length; i++ ) {
				toAddress[i] = new InternetAddress(to[i]);
			}

			for( int i = 0; i < toAddress.length; i++) {
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}

			message.setSubject(subject);
			message.setText(body);

			Transport.send(message, message.getAllRecipients());

		}
		catch (AddressException ae) {
			ae.printStackTrace();
		}
		catch (MessagingException me) {
			me.printStackTrace();
		}
	}
}




