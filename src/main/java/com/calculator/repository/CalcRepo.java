package com.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calculator.model.CalcModel;

public interface CalcRepo  extends JpaRepository<CalcModel, Integer>{

}
