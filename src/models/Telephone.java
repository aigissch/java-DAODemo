package models;

public class Telephone {
	private int idPhone;
	private int idStaff;
	private String number;
	
	public Telephone() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Telephone(int idPhone, int idStaff, String number) {
		super();
		this.idPhone = idPhone;
		this.idStaff = idStaff;
		this.number = number;
	}
	
	public int getIdPhone() {
		return idPhone;
	}
	
	public void setIdPhone(int idPhone) {
		this.idPhone = idPhone;
	}
	
	public int getIdStaff() {
		return idStaff;
	}
	
	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
}