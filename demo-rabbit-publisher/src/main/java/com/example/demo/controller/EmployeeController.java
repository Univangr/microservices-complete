package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
@Api(value="Employee Management System", description="Operations pertaining to employee in Employee Management System")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	@ApiOperation(value = "View a list of available employees")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
		    @ApiResponse(code = 500, message = "Internal server error gettin all employees")
		})
	public List<Employee> getAllEmployess(){
		log.debug("--> start getAllEmployees");
		return employeeService.getAllEmployees();
	}
	

    @ApiOperation(value = "Get an employee by Id")
    @GetMapping("/employees/{id}")
    public ResponseEntity < Employee > getEmployeeById(
    		@ApiParam(example="1", allowEmptyValue= false, value ="Employee id from which employee object will retrieve", required = true) @PathVariable(value = "id") Integer employeeId)
    throws ResourceNotFoundException {
        Employee employee = employeeService.getEmploye(employeeId);
        if(employee==null) {
        	throw new ResourceNotFoundException("Employee not found for this id :: " + employeeId);
        }
        return ResponseEntity.ok().body(employee);
    }
	
    @ApiOperation(value = "Add an employee")
    @PostMapping("/employees")
    public Employee createEmployee(
        @ApiParam(value = "Employee object store in database table", required = true) @Valid @RequestBody Employee employee) {
        return employeeService.saveOrUpdate(employee);
    }
    
    @ApiOperation(value = "Update an employee")
    @PutMapping("/employees/{id}")
    public ResponseEntity <Employee> updateEmployee(
        @ApiParam(example = "1", value = "Employee Id to update employee object", required = true) @PathVariable(value = "id") Integer employeeId,
        @ApiParam(value = "Update employee object", required = true) @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeService.getEmploye(employeeId);
        if(employee==null){
        	throw new ResourceNotFoundException("Employee not found for this id :: " + employeeId);
        }
        employeeDetails.setId(employeeId);
        final Employee updatedEmployee = employeeService.saveOrUpdate(employeeDetails);
        return ResponseEntity.ok(updatedEmployee);
    }
    
    @ApiOperation(value = "Delete an employee")
    @DeleteMapping("/employees/{id}")
    public Map < String, Boolean > deleteEmployee(
        @ApiParam(example = "1", value = "Employee Id from which employee object will delete from database table", required = true) @PathVariable(value = "id") Integer employeeId)
    throws ResourceNotFoundException {
        Employee employee = employeeService.getEmploye(employeeId);
        if(employee==null) {
        	throw new ResourceNotFoundException("Employee not found for this id :: " + employeeId);
        }
            
        employeeService.delete(employeeId);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
