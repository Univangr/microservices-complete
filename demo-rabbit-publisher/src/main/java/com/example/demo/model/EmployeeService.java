package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		List<Employee> allEmployees = new ArrayList<>();
		employeeRepository.findAll().forEach(employee-> allEmployees.add(employee));
		log.debug("--> response allEmployes {}", allEmployees);
		return allEmployees;
	}
	
	public Employee getEmploye(int id){
		return employeeRepository.findById(id).orElse(null);
	}
	
	public Employee saveOrUpdate(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}

}
