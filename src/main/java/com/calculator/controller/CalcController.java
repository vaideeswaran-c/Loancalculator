package com.calculator.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.calculator.model.CalcModel;
import com.calculator.repository.CalcRepo;


@RestController
@CrossOrigin
public class CalcController {

	@Autowired
	CalcRepo calcRepo;
	
	@PostMapping("/loancalculation")
	public String saveLoan(@Validated @RequestBody CalcModel calData) {

		//Calculating interest
		float interest=(calData.getPrincipal() * calData.getRate() * calData.getTerm()) / 100;
		
		//calculating APR
		float aprValue=((((calData.getType().label + interest )/ calData.getPrincipal())/ calData.getTerm())
				 * 365 ) * 100;

		calData.setApr(aprValue);
		calcRepo.save(calData);
		return "Saved Successfully";
	}
	
	@GetMapping("/loancalculation")
	public List<CalcModel> getAll() {
		return calcRepo.findAll();
	}

	@GetMapping("/loancalculation/{id}")
	public CalcModel get(@PathVariable int id) {
		Optional<CalcModel> calcModelOptional = calcRepo.findById(id);
		return calcModelOptional.orElseGet(CalcModel::new);
	}
	
}
