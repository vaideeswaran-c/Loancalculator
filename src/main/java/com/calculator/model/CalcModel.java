package com.calculator.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name="LoanCalulator")
public class CalcModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank
	private String name;

	@NotNull
	private int ssn;

	@NotBlank
	private String dob;

	@NotNull
	private long principal;

	@NotNull
	private float rate;

	@NotNull
	private int term;

	@NotNull
	private Type type;

	@NotNull
	private float apr;
	
}
