package dao;
import java.util.List;
import models.Staff;


public interface StaffDAO {
	
	public List<Staff> getAllStaff() throws Exception;
	
	public void save(Staff staff);
	
	public void update(Staff staff);
	
	public Staff searchById(int id) throws Exception;
	
	public void delete(int id);

}
