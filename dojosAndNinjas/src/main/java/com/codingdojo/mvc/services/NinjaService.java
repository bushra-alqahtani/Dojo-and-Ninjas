package com.codingdojo.mvc.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Ninja;
import com.codingdojo.mvc.repositories.NinjaRepository;



@Service
public class NinjaService {

	public final NinjaRepository ninjaRepository;

	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	//Create 
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja); 
	}
	
	//all ninjas
	public List<Ninja> getAllNinjas(){
		List<Ninja> ninjas=ninjaRepository.findAll();
		return ninjas;
		
	} 
		
	 //get ninja  by id 
    public Optional<Ninja> getNinjaById(Long id) {
    	return ninjaRepository.findById(id);
    }
		

}
