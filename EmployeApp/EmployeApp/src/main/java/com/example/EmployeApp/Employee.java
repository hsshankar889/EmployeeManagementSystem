package com.example.EmployeApp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int EmployeeID;
private String EmployeeName;
private String EmployeeEmail;
private long EmployeePhone;
private String EmployeeGender;
private double EmployeeSalary;
private String EmployeeRole;
private String EmployeePassword;
}
