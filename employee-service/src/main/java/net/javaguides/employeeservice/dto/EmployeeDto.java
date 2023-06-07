package net.javaguides.employeeservice.dto;

public class EmployeeDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String departmentCode;
	private String organizationCode;

	public EmployeeDto() {
		
	}
	
	public EmployeeDto(Long id, String firstName, String lastName, String email, String departmentCode, String organizationCode) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.departmentCode = departmentCode;
		this.organizationCode = organizationCode;
	}
	public Long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
}
