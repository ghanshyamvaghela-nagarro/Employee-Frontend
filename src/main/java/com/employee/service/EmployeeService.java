package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeDto;

public interface EmployeeService {

	void addData(EmployeeDto employeeDto);
	List<EmployeeDto> getData();
}
