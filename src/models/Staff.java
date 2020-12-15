package models;

public class Staff {
	private int id;
	private String name;
	private int idDepartment;
	private Gender gender;
	
	// Clase género
	public enum Gender {
		MALE,FEMALE;
		}
	
	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", idDepartment=" + idDepartment + ", gender=" + gender + "]";
	}

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Staff(int id, String name, int idDepartment, Gender gender) {
		super();
		this.id = id;
		this.name = name;
		this.idDepartment = idDepartment;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
