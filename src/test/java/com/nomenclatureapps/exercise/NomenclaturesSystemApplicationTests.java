package com.nomenclatureapps.exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nomenclatureapps.exercise.model.Nomenclatures;
import com.nomenclatureapps.exercise.service.NomencaltureService;

@SpringBootTest
class NomenclaturesSystemApplicationTests {

	@Autowired
	NomencaltureService nomencaltureService;
	
	@Test
	void contextLoads() {
	}
	
	@BeforeEach
	void beforeAllOperation() {
		// Nomencaltural.xlsx
		List<Nomenclatures> listOfNomenCaltures = Arrays.asList(
				new Nomenclatures(0,398481,1,"code 123","parent cal1","desc of clature 1","Item include 1","Also item include 9","rulings of clature","Item excludes 2","Reference To ISIC 7"),
				new Nomenclatures(0,398482,2,"code 456","parent cal2","desc of clature 2","Item include 2","Also item include 8","rulings of clature","Item excludes 3","Reference To ISIC 6"),
				new Nomenclatures(0,398483,3,"code 789","parent cal3","desc of clature 3","Item include 3","Also item include 7","rulings of clature","Item excludes 4","Reference To ISIC 8"),
				new Nomenclatures(0,398484,4,"code 987","parent cal4","desc of clature 4","Item include 4","Also item include 6","rulings of clature","Item excludes 5","Reference To ISIC 9"),
				new Nomenclatures(0,398481,1,"code 123","parent cal","desc of clature","Item include","Also item include","rulings of clature","Item excludes","Reference To ISIC")
		);
		nomencaltureService.putNaceDetails(listOfNomenCaltures);
	}
	
	@Test
	void load() {
		System.out.println("Welcome Nomenclatures System");
	}
	@Test
	void nomenclaturesSystemEquals() {
		long orderId =  398481 ;
	    Nomenclatures nomenclatures = nomencaltureService.getNaceDetailsByOrderId(new Long(orderId));
	    System.out.println("Order Ids :" + orderId + " - OrderId;" + nomenclatures.getOrderId() +", Code :"+ nomenclatures.getCode());
		assertEquals(orderId, nomenclatures.getOrderId());
	}
	
	@Test
	void nomenclaturesSystemNotEquals() {
		long count = nomencaltureService.getAllNaceDetails().stream().count();
		System.out.println(count);
		assertNotEquals(6, count);
	}
	
	

}
