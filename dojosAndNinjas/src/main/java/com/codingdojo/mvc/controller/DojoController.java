package com.codingdojo.mvc.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.mvc.models.Dojo;
import com.codingdojo.mvc.models.Ninja;
import com.codingdojo.mvc.services.DojoService;
import com.codingdojo.mvc.services.NinjaService;


@Controller
public class DojoController {

	
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	
	//create New DojO
		@RequestMapping("/dojos/new")
	    public String newDojo(@ModelAttribute("dojo") Dojo dojo ,Model model) {
			model.addAttribute("dojos",dojoService.getAllDojos());
	        return "/dojo/createDojo.jsp";
	    }
	    @RequestMapping(value="/dojos/new", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result ) {  // for Error checking i use @valid 
	        if (result.hasErrors()) {
	            return "/dojo/createDojo.jsp";
	        } else {
	        	dojoService.createDojo(dojo);
	            return "redirect:/dojos/new";
	        
	        }
	        }
	    
	    
	    
	    
	  //create New Ninja
	    @RequestMapping("/ninjas/new")
	    public String newNinja(@ModelAttribute("ninja") Ninja ninja ,Model model) {
	    	List<Dojo> dojos=dojoService.getAllDojos();
			model.addAttribute("dojos",dojos);
	        return "/ninja/createNinja.jsp";
	    }
	    @RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
	    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result ) {  // for Error checking i use @valid 
	        if (result.hasErrors()) {
	            return "/ninja/createNinja.jsp";
	        } else {
	        	ninjaService.createNinja(ninja);
	            return "redirect:/ninjas/new";
	        
	        }
	        }
	    
	    @RequestMapping(value="/dojos/{id}")
	    public String dojoMembers(Model model,@PathVariable("id") Long id) {   
	
	    	model.addAttribute("dojo",dojoService.findDojo(id));
	    	
	    	//to get all ninjas
	    	List<Ninja> ninjas=ninjaService.getAllNinjas();
	    	model.addAttribute("ninjas",ninjas);
			return "/dojo/all.jsp";
	    	
	    	
	        }
	    
	    
	    
	    
	    
	    
	    }
	

