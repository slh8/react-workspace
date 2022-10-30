package com.dailycodebuffer.employeesystemapi.services;

import java.util.List;

import com.dailycodebuffer.employeesystemapi.model.Employee;

public interface EmployeeService {
    public Employee createEmployee(Employee employee);

    public List<Employee> getAllEmployees();
}
