package com.nomenclatureapps.exercise.service;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nomenclatureapps.exercise.model.Nomenclatures;
import com.nomenclatureapps.exercise.repository.NomenclaturesRepository;

@Component
public class NomencaltureServiceImpl implements NomencaltureService, Serializable {

	private static final long serialVersionUID = 1L;

	Logger logger = LoggerFactory.getLogger(NomencaltureServiceImpl.class);
	
	@Autowired
	NomenclaturesRepository nomenclaturesRepository;
	
	@Override
	public void putNaceDetails(List<Nomenclatures> listOfNomenclatures) {
		
		logger.info("Added new NomenCaltures using PutNaceDetails(list)");
		
		// TODO Auto-generated method stub
		listOfNomenclatures.stream().forEach(nomencal -> {
			List<Nomenclatures> list = nomenclaturesRepository.findByOrderId( nomencal.getOrderId());
			if(list.isEmpty())
			{
				nomenclaturesRepository.save(nomencal);
			}
		});
		
		if(listOfNomenclatures.isEmpty()) {
			Nomenclatures nomenclatures = nomenclaturesRepository.save(new Nomenclatures(1,398481,1,"code 123","parent cal","desc of clature","Item include","Also item include","rulings of clature","Item excludes","Reference To ISIC"));
			System.out.println(nomenclatures);
			logger.info("Added new NomenCaltures : " + nomenclatures );
		}
	}

	@Override
	public Nomenclatures getNaceDetailsByOrderId(long orderId) {
		
		logger.info("Featch NomenCaltures by Order Id using - getNaceDetailsByOrderId : " + orderId);
		// TODO Auto-generated method stub
		List<Nomenclatures> listOfNomenclatures= nomenclaturesRepository.findByOrderId(orderId);
		Nomenclatures nomenclatures = null ;
		if(listOfNomenclatures.size() > 0) {
			nomenclatures = listOfNomenclatures.get(0);
		}
		logger.info("Get NomenCaltures : " + nomenclatures );
		return nomenclatures;
	}

	@Override
	public List<Nomenclatures> getAllNaceDetails() {
		List<Nomenclatures> listOfValues = nomenclaturesRepository.findAll();
		logger.info("GetAllNaceDetails: " + listOfValues );
		// TODO Auto-generated method stub
		return listOfValues;
	}

}
