package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;
import br.edu.insper.mvc.model.User;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		User udyr = null;
		boolean isUser = false;
		
		for (User user : users) {
			if (user.getUsername().contentEquals(username) && user.getPassword().contentEquals(pwd)) {
				udyr = user;
				isUser = true;
				
				break;
			}
		}
		
		if (isUser) {
			request.setAttribute("user", udyr);
			RequestDispatcher dispatcher = request.getRequestDispatcher("list");
			dispatcher.forward(request, response);
		}
		else {
			response.getWriter().println("Username or password incorrect");
		}
	}

}
