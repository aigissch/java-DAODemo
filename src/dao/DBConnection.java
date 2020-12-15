package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import models.Staff;

public class DBConnection {
	private Connection connection;
	private String user;
	private String password;

	public DBConnection(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	private Connection getConnection() throws ClassNotFoundException {

		String url = "jdbc:mysql://localhost:3306/enterprise";
		Properties info = new Properties();
		info.put("user", this.user);
		info.put("password", this.password);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, info);
			System.out.println("Successfull Connection");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// Get all data from the table
	public ResultSet getStaffTable() throws SQLException, ClassNotFoundException {
		ResultSet rs = null;
		String query = "SELECT * FROM company.staff;";
		Statement stmt;
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public ResultSet getById(int id) throws SQLException, ClassNotFoundException {
		ResultSet rs = null;
		String query = "SELECT * FROM company.staff WHERE id=?;";
		PreparedStatement stmt;

		try {
			connection = getConnection();
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public ResultSet getDepartmentTable() throws SQLException, ClassNotFoundException {
		ResultSet rs = null;
		String query = "SELECT * FROM company.department;";
		Statement stmt;
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public void addStaff(Staff staff) throws SQLException, ClassNotFoundException {
		String query1 = "INSERT INTO company.staff (name,idDepartment,gender) VALUES (?,?,?);";
		PreparedStatement stmt1;
		int queryResult;
		Long lastId = null;

		try {
			connection = getConnection();
			connection.setAutoCommit(false);

			stmt1 = connection.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
			stmt1.setString(1, staff.getName());
			stmt1.setInt(2, staff.getIdDepartment());
			stmt1.setString(3, staff.getGender().toString());
			queryResult = stmt1.executeUpdate();

			if (queryResult != 0) {
				ResultSet generatedKey = stmt1.getGeneratedKeys();
				if (generatedKey.next())
					lastId = generatedKey.getLong(1);
					System.out.println(lastId);
			}

			connection.commit();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			connection.setAutoCommit(true);
		}
	}

	public void editStaff(Staff staff) throws SQLException, ClassNotFoundException {
		String query1 = "UPDATE `company`.`staff` SET `name` = ?, `idDepartment` = ?, `gender` = ? WHERE (`id` = ?);";
		PreparedStatement stmt1;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			stmt1 = connection.prepareStatement(query1);
			stmt1.setString(1, staff.getName());
			stmt1.setInt(2, staff.getIdDepartment());
			stmt1.setString(3, staff.getGender().toString());
			stmt1.setInt(4, staff.getId());
			stmt1.executeUpdate();
						
			
			connection.commit();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			connection.setAutoCommit(true);
		}
	}

	
	public void deleteStaff(int idStaff) throws SQLException, ClassNotFoundException {
		PreparedStatement stmt2;
		String query2 = "DELETE FROM `company`.`staff` WHERE (`id` = ?);";

		try {
			connection = getConnection();
			connection.setAutoCommit(false);

			
			stmt2 = connection.prepareStatement(query2);
			stmt2.setInt(1, idStaff);
			stmt2.executeUpdate();

			connection.commit();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			connection.setAutoCommit(true);
		}
	}
	
	


}
