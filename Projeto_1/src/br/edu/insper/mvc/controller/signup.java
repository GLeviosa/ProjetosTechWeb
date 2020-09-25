package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.*;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/signup.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd"); 
		
		DAO dao = new DAO();
		List<User> users = dao.getUsers();
		boolean isUser = false;
		for (User user : users) {
			if (user.getUsername().contentEquals(username)) {
				isUser = true;
				break;
			}
		}
		
		if (isUser) {
			response.getWriter().println("Username already taken, try another one!");
		} else {
			System.out.println("cadastrou");
			System.out.println(username);
			System.out.println(pwd);
			User user = new User();
			user.setUsername(username);
			user.setPassword(pwd);
			dao.addUser(user);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/index.html");
			dispatcher.forward(request,response);
		}
;	}

}
