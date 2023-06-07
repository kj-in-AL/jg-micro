package net.javaguides.employeeservice.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.dto.OrganizationDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.exception.ResourceNotFoundException;
import net.javaguides.employeeservice.mapper.EmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.APIClient;
import net.javaguides.employeeservice.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

//	@Autowired
//	private ModelMapper modelMapper;
//	
//	@Autowired
//	private RestTemplate restTemplate;
//
	@Autowired
	private WebClient webClient;

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

	@Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	// @CircuitBreaker(name = "${spring.application.name}", fallbackMethod =
	// "getDefaultDepartment")
	@Override
	public APIResponseDto getEmployeeById(Long employeeId) {

		LOGGER.info("inside getEmployeeById() method");

		Optional<Employee> employee = employeeRepository.findById(employeeId);

		if (employee.isEmpty()) {
			throw new ResourceNotFoundException("Employee", "id", employeeId);
		}

		OrganizationDto organizationDto = webClient.get()
				.uri("http://localhost:8083/api/organizations/" + employee.get().getOrganizationCode()).retrieve()
				.bodyToMono(OrganizationDto.class).block();

//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.get().getDepartmentCode(), DepartmentDto.class);
//		DepartmentDto departmentDto = responseEntity.getBody();

		DepartmentDto departmentDto = webClient.get()
				.uri("http://localhost:8080/api/departments/" + employee.get().getDepartmentCode()).retrieve()
				.bodyToMono(DepartmentDto.class).block();

//		DepartmentDto departmentDto = apiClient.getDepartment(employee.get().getDepartmentCode());

		EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(employee.get());

		APIResponseDto apiResponseDto = new APIResponseDto();

		apiResponseDto.setEmployeeDto(employeeDto);
		apiResponseDto.setDepartmentDto(departmentDto);
		apiResponseDto.setOrganizationDto(organizationDto);

//		EmployeeDto employeeDto = new EmployeeDto(
//				employee.getId(),
//				employee.getFirstName(),
//				employee.getLastName(),
//				employee.getEmail()
//		);

//		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

		return apiResponseDto;
	}

	public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {

		LOGGER.info("inside getDefaultDepartment() method");

		Optional<Employee> employee = employeeRepository.findById(employeeId);

		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartmentName("R&D Department");
		departmentDto.setDepartmentCode("RD001");
		departmentDto.setDepartmentDescription("Research and Development Department");

		if (employee.isEmpty()) {
			throw new ResourceNotFoundException("Employee", "id", employeeId);
		}

		EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(employee.get());

		APIResponseDto apiResponseDto = new APIResponseDto();

		apiResponseDto.setEmployeeDto(employeeDto);
		apiResponseDto.setDepartmentDto(departmentDto);

		return apiResponseDto;
	}
}
