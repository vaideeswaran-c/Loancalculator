package com.calculator.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="LoanCalulator")
public class CalcModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int ssn;
	private String dob;
	private long principal;
	private double rate;
	private int term;
	private String type;
	private double arp;
	
}
