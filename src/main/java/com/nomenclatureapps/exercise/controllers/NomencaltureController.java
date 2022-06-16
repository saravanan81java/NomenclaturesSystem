package com.nomenclatureapps.exercise.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nomenclatureapps.exercise.model.Nomenclatures;
import com.nomenclatureapps.exercise.service.NomencaltureService;


@Controller
@RequestMapping("/nomencalture")
public class NomencaltureController {

	@Autowired
	NomencaltureService nomencaltureService;
	
	@GetMapping("/getnace-by-orderid/{orderId}")
	public String getNACEByOrderId(@PathVariable("orderId") long orderId, Model model) {
		 
		 List<Nomenclatures> list = Arrays.asList(nomencaltureService.getNaceDetailsByOrderId(orderId));
		 model.addAttribute("list", list );
		 return "index";
	} 
	
	@GetMapping("/get-all-nace-details")
	public String getAllNaceDetails(Model model) {
		List<Nomenclatures> list  =nomencaltureService.getAllNaceDetails();
		System.out.println(list);
		 model.addAttribute("list", list );
		 return "index";
	} 
}
