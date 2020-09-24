package br.edu.insper.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

public class DAO {
	private Connection connection = null;
	
	public DAO(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/dados_p1","root","azir1q2w3");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Task> getTasks() {
		List<Task> tasks = new ArrayList<Task>();
		
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Tasks");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setUser(rs.getNString("user"));
				task.setTask(rs.getNString("task"));
				task.setTag(rs.getNString("tag"));
				task.setCreDate(rs.getTimestamp("creDate"));
				tasks.add(task);
			}
			
			rs.close();
			stmt.close();

			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		return tasks;
	}
	
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT * FROM Users");
		
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getNString("username"));
				user.setPassword(rs.getNString("pwd"));
				users.add(user);
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	public void addTask(Task task){
		String sql ="INSERT INTO Tasks"
					+"(user, task, tag, creDate) values(?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1,task.getUser());
			stmt.setString(2, task.getTask());
			stmt.setString(3,task.getTag());
			stmt.setTimestamp(4,task.getCreDate());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void addUser(User user) {
		String sql = "INSERT INTO Users (user, pwd) values(?,?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setNString(1, user.getUsername());
			stmt.setNString(2, user.getPassword());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void removeTask(Integer id){
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(
					"DELETE FROM Tasks WHERE id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	public void updateTask(Task task) throws SQLException{
		String sql ="UPDATE Tasks SET " +
				"user=?, task=?, tag=?, creDate=? WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, task.getUser());
		stmt.setString(2, task.getTask());
		stmt.setString(3, task.getTag());
		stmt.setTimestamp(4, task.getCreDate());
		stmt.setInt(5, task.getId());
		stmt.execute();
		stmt.close();
		
	}
	
	public void close() throws SQLException {
		connection.close();
		
	}
}
