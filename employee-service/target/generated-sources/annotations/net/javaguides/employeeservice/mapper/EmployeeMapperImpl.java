package net.javaguides.employeeservice.mapper;

import javax.annotation.processing.Generated;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-06T20:20:30-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDto mapToEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId( employee.getId() );
        employeeDto.setFirstName( employee.getFirstName() );
        employeeDto.setLastName( employee.getLastName() );
        employeeDto.setEmail( employee.getEmail() );
        employeeDto.setDepartmentCode( employee.getDepartmentCode() );
        employeeDto.setOrganizationCode( employee.getOrganizationCode() );

        return employeeDto;
    }

    @Override
    public Employee mapToEmployee(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeDto.getId() );
        employee.setFirstName( employeeDto.getFirstName() );
        employee.setLastName( employeeDto.getLastName() );
        employee.setEmail( employeeDto.getEmail() );
        employee.setDepartmentCode( employeeDto.getDepartmentCode() );
        employee.setOrganizationCode( employeeDto.getOrganizationCode() );

        return employee;
    }
}
