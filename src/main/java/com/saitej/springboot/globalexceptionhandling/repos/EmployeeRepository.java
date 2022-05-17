package com.saitej.springboot.globalexceptionhandling.repos;

import com.saitej.springboot.globalexceptionhandling.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
