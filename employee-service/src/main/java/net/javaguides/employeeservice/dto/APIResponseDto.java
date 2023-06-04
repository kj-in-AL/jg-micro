package net.javaguides.employeeservice.dto;

public class APIResponseDto {
	private EmployeeDto employeeDto;
	private DepartmentDto departmentDto;
	
	public APIResponseDto() {
		
	}
	
	public APIResponseDto(EmployeeDto employeeDto, DepartmentDto departmentDto) {
		super();
		this.employeeDto = employeeDto;
		this.departmentDto = departmentDto;
	}
	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}
	public DepartmentDto getDepartmentDto() {
		return departmentDto;
	}
	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}
	public void setDepartmentDto(DepartmentDto departmentDto) {
		this.departmentDto = departmentDto;
	}
	
	
}
