package net.javaguides.employeeservice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.exception.ResourceNotFoundException;
import net.javaguides.employeeservice.mapper.EmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.APIClient;
import net.javaguides.employeeservice.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

//	@Autowired
//	private ModelMapper modelMapper;
//	
//	@Autowired
//	private RestTemplate restTemplate;
//
//	@Autowired
//	private WebClient webClient;

	@Autowired
	private APIClient apiClient;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
//		Employee employee = new Employee(
//				employeeDto.getId(),
//				employeeDto.getFirstName(),
//				employeeDto.getLastName(),
//				employeeDto.getEmail()
//		);

//		Employee employee = modelMapper.map(employeeDto, Employee.class);

		Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);

		Employee savedEmployee = employeeRepository.save(employee);

//		EmployeeDto savedEmployeeDto = new EmployeeDto(
//				savedEmployee.getId(),
//				savedEmployee.getFirstName(),
//				savedEmployee.getLastName(),
//				savedEmployee.getEmail()
//		);

//		EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);
		EmployeeDto savedEmployeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
		return savedEmployeeDto;
	}

	@Override
	public APIResponseDto getEmployeeById(Long employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);

		if (employee.isEmpty()) {
			throw new ResourceNotFoundException("Employee", "id", employeeId);
		}

//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.get().getDepartmentCode(), DepartmentDto.class);
//		DepartmentDto departmentDto = responseEntity.getBody();

//		DepartmentDto departmentDto = webClient.get()
//				.uri("http://localhost:8080/api/departments/" + employee.get().getDepartmentCode()).retrieve()
//				.bodyToMono(DepartmentDto.class).block();

		DepartmentDto departmentDto = apiClient.getDepartment(employee.get().getDepartmentCode());
		
		EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(employee.get());

		APIResponseDto apiResponseDto = new APIResponseDto();

		apiResponseDto.setEmployeeDto(employeeDto);
		apiResponseDto.setDepartmentDto(departmentDto);

//		EmployeeDto employeeDto = new EmployeeDto(
//				employee.getId(),
//				employee.getFirstName(),
//				employee.getLastName(),
//				employee.getEmail()
//		);

//		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

		return apiResponseDto;
	}
}
