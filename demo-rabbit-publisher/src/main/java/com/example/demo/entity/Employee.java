package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "EMPLOYEES", schema = "UNIVAN_SCHEMA")
@Data
@ApiModel(description = "All details about the Employee. ")
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(dataType="java.lang.Integer", notes = "The database generated employee ID", example="99")
	private Integer id;
    @ApiModelProperty(notes = "The employee first name")
    @Column(name = "first_name", nullable = false)
	private String firstName;
    
    @ApiModelProperty(notes = "The employee last name")
    @Column(name = "last_name", nullable = false)
	private String lastName;
    
    @ApiModelProperty(notes = "The employee career")
    @Column(name = "career", nullable = false)
	private String career;
}
