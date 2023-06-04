package net.javaguides.departmentservice.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.exception.ResourceNotFoundException;
import net.javaguides.departmentservice.mapper.DepartmentMapper;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		// convert department dto to department jpa entity
//		Department department = new Department(
//				departmentDto.getId(),
//				departmentDto.getDepartmentName(),
//				departmentDto.getDepartmentDescription(),
//				departmentDto.getDepartmentCode()
//		);

//		Department department = modelMapper.map(departmentDto, Department.class);

		Department department = DepartmentMapper.MAPPER.mapToDepartment(departmentDto);

		Department savedDepartment = departmentRepository.save(department);

//		DepartmentDto savedDepartmentDto = new DepartmentDto(
//				savedDepartment.getId(),
//				savedDepartment.getDepartmentName(),
//				savedDepartment.getDepartmentDescription(),
//				savedDepartment.getDepartmentCode()
//		);

//		DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);

		DepartmentDto savedDepartmentDto = DepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String code) {

		Optional<Department> department = departmentRepository.findByDepartmentCode(code);
//		DepartmentDto departmentDto = new DepartmentDto(
//				department.getId(),
//				department.getDepartmentName(),
//				department.getDepartmentDescription(),
//				department.getDepartmentCode()
//		);
//		DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
		if (department.isEmpty()) {
			throw new ResourceNotFoundException("Department", "code", code);
		}
		DepartmentDto departmentDto = DepartmentMapper.MAPPER.mapToDepartmentDto(department.get());
		return departmentDto;
	}
}
