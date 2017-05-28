package com.example.ui;

import com.example.Employee;
import com.example.EmployeeRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class EditEmployeeController {

	@Inject
	EmployeeForm employeeForm;

	@Inject
	EmployeeRepository employeeRepository;

	public void save() {
		employeeRepository.merge(employeeForm.getEmployee());
	}

	public void preRenderViewEvent() {
		if (employeeForm.getEmployee() == null) initializeEmployee();
	}

	private void initializeEmployee() {
		Integer employeeId = employeeForm.getEmployeeId();
		employeeForm.setEmployee(employeeId == null ? new Employee() : employeeRepository.find(employeeId));
	}
}