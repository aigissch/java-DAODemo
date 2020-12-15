package models;

public class Department {
	private int idDepartment;
	private String nameDepartment;
	
		// Antes nos convenía poner los departamentos como enumerable, al igual que pasa con el género
		//	private DepartmentEnum departmentEnum;
		//	
		//	public enum DepartmentEnum {
		//		RRHH,LOGISTICA, CONTABILIDAD, INFORMATICA;
		//		}

	public Department(int idDepartment, String nameDepartment) {
		super();
		this.idDepartment = idDepartment;
		this.nameDepartment = nameDepartment;
	}
	
	public int getIdDepartment() {
		return idDepartment;
	}
	
	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}
	
	public String getNameDepartment() {
		return nameDepartment;
	}
	
	public void setNameDepartment(String nameDepartment) {
		this.nameDepartment = nameDepartment;
	}
}
