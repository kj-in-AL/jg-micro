package net.javaguides.departmentservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String departmentName;
	private String departmentDescription;
	private String departmentCode;
	
	public Department() {
		
	}
	
	public Department(Long id, String departmentName, String departmentDescription, String departmentCode) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.departmentDescription = departmentDescription;
		this.departmentCode = departmentCode;
	}
	
	public Long getId() {
		return id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public String getDepartmentDescription() {
		return departmentDescription;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	
	
	
}
