package com.nomenclatureapps.exercise.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nomenclatureapps.exercise.model.Nomenclatures;
import com.nomenclatureapps.exercise.service.NomencaltureService;



@RestController
@RequestMapping("/nomencaltureapi")
public class NomencaltureRestController {

	@Autowired
	NomencaltureService nomencaltureService;
	
	 
	@GetMapping("/getnace-by-orderid/{orderId}")
	public Nomenclatures getNACEByOrderId(@PathVariable("orderId") long orderId) {
		return nomencaltureService.getNaceDetailsByOrderId(orderId);
	} 
	
	@GetMapping("/get-all-nace-details")
	public List<Nomenclatures> getAllNaceDetails(Model model) {
		return nomencaltureService.getAllNaceDetails();
	} 
	 
}
