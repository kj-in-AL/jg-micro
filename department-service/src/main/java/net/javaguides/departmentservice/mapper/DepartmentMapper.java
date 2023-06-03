package net.javaguides.departmentservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;

@Mapper
public interface DepartmentMapper {

	DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);
	
	DepartmentDto mapToDepartmentDto(Department department);
	Department mapToDepartment(DepartmentDto departmentDto);
	
}

