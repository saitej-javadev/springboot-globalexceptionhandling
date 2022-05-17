package com.saitej.springboot.globalexceptionhandling.service;

import com.saitej.springboot.globalexceptionhandling.entity.Employee;
import com.saitej.springboot.globalexceptionhandling.exceptions.InputEmptyException;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee) throws InputEmptyException;
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(Long id);
    public void deleteById(Long id);
}
