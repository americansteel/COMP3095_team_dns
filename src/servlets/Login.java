package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import classes.User;
import utilities.DatabaseAccess;

/**
 * Servlet implementation class Login
 */
@WebServlet(name="Login", urlPatterns= {"/Login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String redirectURL = "";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Boolean rememberMe = Boolean.parseBoolean(request.getParameter("remember"));
		
		
	    if (DatabaseAccess.userCredentialCheck(username, password))
	    {	    	
			redirectURL = "home.jsp";
			
			if (rememberMe == false) {
				User user = DatabaseAccess.getUser(username, password);
				user.setToken();
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
			}
			else {
				User user = DatabaseAccess.getUser(username, password);
				user.setToken();
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
				Cookie c = new Cookie("userToken", user.getToken());
				c.setMaxAge(60*60*24*30);
				response.addCookie(c);
			}
			
			
		}
		 	else { redirectURL = "login.jsp"; // TODO figure out error logic http://www.studytonight.com/servlet/login-system-example-in-servlet.php
		}
		 response.sendRedirect(redirectURL);
		
		
		
		
		
	}

}