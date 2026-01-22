package com.employee.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;
import com.employee.util.EmployeeUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeUtil employeeUtil;
	
	
	public EmployeeServiceImpl(EmployeeUtil employeeUtil) {
		this.employeeUtil = employeeUtil;
	}

	@Override
	public void addData(EmployeeDto employeeDto) {
		employeeUtil.addEmployee(employeeDto);
	}

	@Override
	public List<EmployeeDto> getData() {
		return employeeUtil.getEmployees();
	}

}
