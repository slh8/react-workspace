package com.dailycodebuffer.employeesystemapi.services;

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

}
