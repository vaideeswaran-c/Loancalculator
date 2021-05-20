package com.calculator.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.calculator.model.CalcModel;
import com.calculator.repository.CalcRepo;


@RestController
@CrossOrigin
public class CalcController {

	@Autowired
	CalcRepo calrepo;
	
	@PostMapping("/loancalculation")
	public String saveLoan(@RequestBody CalcModel calData) {
		
		double arpValue;
		long principal=calData.getPrincipal();
		double rate=calData.getRate();
		int term=calData.getTerm();
		double interest;
		double fees;
		
		//calculating the interest
		interest=(principal*rate*term)/100;
		
		//calculating fees based on type
		switch(calData.getType()) {
		case "student":
			fees=0.00;
			break;
		case "auto":
			fees=500;
			break;
		case "personal":
			fees=750;
			break;
		case "mortgage":
			fees=1500;
			break;
		default:
			fees=0.00;
			break;
		}
		
		//calculating ARP
		arpValue=((((fees+interest)/principal)/term)*365)*100;
		String sValue = (String) String.format("%.2f", arpValue);
		Double arp = Double.parseDouble(sValue);
		 
		//updating the ARP value in the object 
		calData.setArp(arp);
		
		//saving the data 
		if(calrepo.save(calData)!=null)
			return "Saved Successfully";
		else
			return "Error while saving";
	}
	
	@GetMapping("/loancalculation")
	public List<CalcModel> getLoan() {
		
		return calrepo.findAll();
	}

	@GetMapping("/loancalculation/{id}")
	public CalcModel get(@PathVariable int id) {
		Optional<CalcModel> calcModelOptional = calrepo.findById(id);
		if(calcModelOptional.isPresent()) {
			return calcModelOptional.get();
		}
		return new CalcModel();
	}
	
}
