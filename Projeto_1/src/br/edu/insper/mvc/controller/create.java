package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.*;


/**
 * Servlet implementation class create
 */
@WebServlet("/create")
public class create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public create() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/formCreate.html");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			DAO dao = new DAO();
			Task task = new Task();
			
			task.setUser(request.getParameter("user"));
			task.setTask(request.getParameter("task"));
			task.setTag(request.getParameter("tag"));
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			task.setCreDate(timestamp);

			dao.addTask(task);
			dao.close();
			RequestDispatcher dispatcher = request.getRequestDispatcher("list");
			dispatcher.forward(request,response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

}
