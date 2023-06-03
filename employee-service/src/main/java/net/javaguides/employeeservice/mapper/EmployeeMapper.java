package net.javaguides.employeeservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;

@Mapper
public interface EmployeeMapper {

	EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);
	
	EmployeeDto mapToEmployeeDto(Employee employee);
	Employee mapToEmployee(EmployeeDto employeeDto);
}
