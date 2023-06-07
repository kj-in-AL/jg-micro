package net.javaguides.employeeservice.dto;

import java.time.LocalDateTime;

public class OrganizationDto {
	
	private Long id;
	private String organizationName;
	private String organizationDescription;
	private String organizationCode;
	private LocalDateTime createdDate;
	
	public OrganizationDto() {
		
	}
	
	public OrganizationDto(Long id, String organizationName, String organizationDescription, String organizationCode,
			LocalDateTime createdDate) {
		super();
		this.id = id;
		this.organizationName = organizationName;
		this.organizationDescription = organizationDescription;
		this.organizationCode = organizationCode;
		this.createdDate = createdDate;
	}
	
	public Long getId() {
		return id;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public String getOrganizationDescription() {
		return organizationDescription;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public void setOrganizationDescription(String organizationDescription) {
		this.organizationDescription = organizationDescription;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
}
