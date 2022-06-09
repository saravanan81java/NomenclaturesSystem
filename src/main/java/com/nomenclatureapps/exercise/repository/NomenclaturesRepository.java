package com.nomenclatureapps.exercise.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.nomenclatureapps.exercise.model.Nomenclatures;

public interface NomenclaturesRepository extends Repository<Nomenclatures, Long>{

	List<Nomenclatures> findByOrderId(long orderId);

	Nomenclatures save(Nomenclatures nomenclatures);
	
	List<Nomenclatures> findAll();
}
