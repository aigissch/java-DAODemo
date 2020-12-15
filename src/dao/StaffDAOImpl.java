package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Staff;

public class StaffDAOImpl implements StaffDAO {

	private List<Staff> allstaff;
	private Staff staff;
		
	@Override
	public List<Staff> getAllStaff() throws Exception {
		DBConnection dBConnection = new DBConnection("anadlca", "Temp2020$$");
		allstaff = new ArrayList<Staff>();
		
		try {
			ResultSet rs = dBConnection.getStaffTable();
			while (rs.next()){
				allstaff.add(new Staff(
						rs.getInt("id"), 
						rs.getString("name"), 
						rs.getInt("idDepartment"),
						Staff.Gender.valueOf(rs.getString("gender"))));
				}	
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}			
		return allstaff;
	}
	
	@Override
	public void save(Staff staff) {
		DBConnection dBConnection = new DBConnection("anadlca", "Temp2020$$");

		try {
			dBConnection.addStaff(staff);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Staff staff) {
		DBConnection dBConnection = new DBConnection("anadlca", "Temp2020$$");
		try {
			dBConnection.editStaff(staff);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Staff searchById(int id) throws Exception {
		DBConnection dBConnection = new DBConnection("anadlca", "Temp2020$$");
		try {
			ResultSet rs = dBConnection.getById(id);			
		
			if(rs.next()){
				staff = new Staff( 
						rs.getInt("id"),
						rs.getString("name"),
						rs.getInt("idDepartment"),
						Staff.Gender.valueOf(rs.getString("gender")));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return staff;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
