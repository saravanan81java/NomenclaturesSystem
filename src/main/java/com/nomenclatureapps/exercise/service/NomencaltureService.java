package com.nomenclatureapps.exercise.service;

import java.util.List;

import com.nomenclatureapps.exercise.model.Nomenclatures;

public interface NomencaltureService {

	void putNaceDetails( List<Nomenclatures> listOfNomenclatures);
	 Nomenclatures getNaceDetailsByOrderId(long orderId);
	 List<Nomenclatures> getAllNaceDetails();
}
