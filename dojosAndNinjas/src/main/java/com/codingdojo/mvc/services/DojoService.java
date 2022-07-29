package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.codingdojo.mvc.models.Dojo;
import com.codingdojo.mvc.repositories.DojoRepository;

@Service
public class DojoService {
 
	public final DojoRepository dojoRepository;

	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	//Create 
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo); 
	}
	
	//all dojos
	public List<Dojo> getAllDojos(){
		List<Dojo> dojos=dojoRepository.findAll();
		return dojos;
		
	} 
		
	 //get dojo  by id 
    public Optional<Dojo> getDojoById(Long id) {
    	return dojoRepository.findById(id);
    }
	
 // retrieves a dojo 
    public Dojo findDojo(Long id) {
       Optional<Dojo> optional = dojoRepository.findById(id);
        if(optional.isPresent()) {
           return optional.get();
        } else {
            return null;
        }
    }
	
}
