package com.dailycodebuffer.employeesystemapi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.employeesystemapi.entity.EmployeeEntity;
import com.dailycodebuffer.employeesystemapi.model.Employee;
import com.dailycodebuffer.employeesystemapi.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();

        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        List<Employee> employees = employeeEntities
                .stream()
                .map(
                        emp -> new Employee(emp.getId(),
                                emp.getFirstName(),
                                emp.getLastName(),
                                emp.getEmailId()))
                .collect(Collectors.toList());
        return employees;
    }

}
