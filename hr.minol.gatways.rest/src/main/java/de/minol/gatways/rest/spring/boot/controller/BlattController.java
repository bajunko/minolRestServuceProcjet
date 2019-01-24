package de.minol.gatways.rest.spring.boot.controller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.minol.gatways.rest.spring.boot.model.BlattZweiLtdnr;
import de.minol.gatways.rest.spring.boot.model.FormBlattEins;
import de.minol.gatways.rest.spring.boot.model.FormBlattZwei;
import de.minol.gatways.rest.spring.boot.repository.FormBlattEinsRepository;
import de.minol.gatways.rest.spring.boot.repository.FormBlattZweiRepository;
import de.minol.gatways.rest.spring.boot.service.BlattService;

@RestController
public class BlattController {
	
	@Autowired
	FormBlattEinsRepository formBlattEinsRepository;
	@Autowired
	FormBlattZweiRepository formBlattZweiRepository;
	@Autowired
	BlattService blattService;
	
	@RequestMapping("/")
	public String healthCheck()	{
		return "REST radi ok";
	}
	
	@GetMapping("/blattEins")
	public List<FormBlattEins> allBlattEins(){
		return (List<FormBlattEins>) formBlattEinsRepository.findAll();
	}
	
	@GetMapping("/blattEins/{id}")
	public FormBlattEins blattEinsbyId(@PathVariable long id){
		return  formBlattEinsRepository.findOne(id);
	}

	@RequestMapping(value = "/neuBlattEins", method = RequestMethod.POST)
	public int insertBlattEins(@RequestBody FormBlattEins blattEins) {
		return blattService.addBlattEins(blattEins) ? HttpStatus.SC_CREATED : HttpStatus.SC_BAD_REQUEST;
	}	

	@GetMapping("/blattZwei")
	public List<FormBlattZwei> allBlattZwei(){
		return (List<FormBlattZwei>) formBlattZweiRepository.findAll();
	}
	
	@GetMapping("/blattZwei/{id}")
	public FormBlattZwei blattZweibyId(@PathVariable long id){
		return  formBlattZweiRepository.findOne(id);
	}

	

	@RequestMapping(value = "/neuBlattZwei", method = RequestMethod.POST)
	public int insertBlattZwei(@RequestBody FormBlattZwei blattZwei) {
		return blattService.addBlattZwei(blattZwei) ? HttpStatus.SC_CREATED : HttpStatus.SC_BAD_REQUEST;
	}	
	
	
	@RequestMapping(value = "/neuBlattZweiLtdnr", method = RequestMethod.POST)
	public int insertBlattZweiLtdnr(@RequestBody BlattZweiLtdnr blattZweiLtdnr) {
		return blattService.addBlattZweiLtdr(blattZweiLtdnr) ? HttpStatus.SC_CREATED : HttpStatus.SC_BAD_REQUEST;
	}	

	@DeleteMapping(value = "/deleteBlattEins/{id}" )
	public void deleteBlattEins(@PathVariable long id ) {
		formBlattEinsRepository.delete(id);
	}

	@DeleteMapping(value = "/deleteBlattZwei/{id}" )
	public void deleteBlattZwei(@PathVariable long id ) {
		formBlattZweiRepository.delete(id);
	}


}
