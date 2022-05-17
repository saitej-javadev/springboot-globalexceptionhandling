package com.saitej.springboot.globalexceptionhandling.service;

import com.saitej.springboot.globalexceptionhandling.entity.Employee;
import com.saitej.springboot.globalexceptionhandling.exceptions.InputEmptyException;
import com.saitej.springboot.globalexceptionhandling.repos.EmployeeRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) throws InputEmptyException {

        if (StringUtils.isBlank(employee.getName()) || StringUtils.isEmpty(employee.getName())) {
            throw new InputEmptyException("Pass required fields employee name cannot be empty");
        }
        Employee savedEmployee  = employeeRepository.save(employee);
        return savedEmployee;
    }


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);

    }
}
