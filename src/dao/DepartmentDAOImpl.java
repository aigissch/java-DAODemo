package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import models.Department;

public class DepartmentDAOImpl implements DepartmentDAO {
	private List<Department> departments;
	
	@Override
	public List<Department> getDepartments() {
		DBConnection dBConnection = new DBConnection("anadlca", "Temp2020$$");
		departments = new ArrayList<Department>();

		try {
			ResultSet rs = dBConnection.getDepartmentTable();
			
			while (rs.next()){
				departments.add(new Department(rs.getInt("idDepartment"), rs.getString("nameDepartment")));
				//,Department.DepartmentEnum.valueOf(rs.getString("name"))));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return departments;
	}

	@Override
	public void save(Department department) {

		
	}

	@Override
	public void update(Department department) {

		
	}

	@Override
	public Department seachById(int id) {

		
		return null;
	}

	@Override
	public void delete(int id) {

		
	}

}
