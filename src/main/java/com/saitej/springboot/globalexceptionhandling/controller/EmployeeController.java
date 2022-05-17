package com.saitej.springboot.globalexceptionhandling.controller;


import com.saitej.springboot.globalexceptionhandling.entity.Employee;
import com.saitej.springboot.globalexceptionhandling.exceptions.InputEmptyException;
import com.saitej.springboot.globalexceptionhandling.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) throws InputEmptyException {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        //  return ResponseEntity.ok(savedEmployee);
        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);

    }

    @GetMapping("/emp/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee retrievedEmployee = employeeService.getEmployeeById(id);
        // return ResponseEntity.ok(employeeService.getEmployeeById(id));
        return new ResponseEntity<Employee>(retrievedEmployee, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {

        List<Employee> listOfAllEmps = employeeService.getAllEmployees();
        return new ResponseEntity<List<Employee>>(listOfAllEmps, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) throws InputEmptyException {
        Employee employeeSaved = employeeService.saveEmployee(employee);
        return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmpById(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}
