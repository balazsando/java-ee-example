package com.example;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_no")
	private Integer employeeNo;

	@Column(name = "first_name", length = 50)
	private String firstName;

	@Column(name = "last_name", length = 50)
	private String lastName;

	@Column(name = "birth_date")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Column(name = "hire_date")
	@Temporal(TemporalType.DATE)
	private Date hireDate;
}