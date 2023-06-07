package net.javaguides.employeeservice.dto;

public class APIResponseDto {
	private EmployeeDto employeeDto;
	private DepartmentDto departmentDto;
	private OrganizationDto organizationDto;
	
	public APIResponseDto() {
		
	}
	
	public APIResponseDto(EmployeeDto employeeDto, DepartmentDto departmentDto, OrganizationDto organizationDto) {
		super();
		this.employeeDto = employeeDto;
		this.departmentDto = departmentDto;
		this.organizationDto = organizationDto;
	}
	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}
	public DepartmentDto getDepartmentDto() {
		return departmentDto;
	}
	public OrganizationDto getOrganizationDto() {
		return organizationDto;
	}
	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}
	public void setDepartmentDto(DepartmentDto departmentDto) {
		this.departmentDto = departmentDto;
	}
	public void setOrganizationDto(OrganizationDto organizationDto) {
		this.organizationDto = organizationDto;
	}
	
}
