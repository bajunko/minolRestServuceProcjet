package de.minol.gatways.rest.spring.boot.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.minol.gatways.rest.spring.boot.model.BlattLtdnr;
import de.minol.gatways.rest.spring.boot.model.BlattZweiLtdnr;
import de.minol.gatways.rest.spring.boot.model.FormBlatt;
import de.minol.gatways.rest.spring.boot.model.FormBlattEins;
import de.minol.gatways.rest.spring.boot.model.FormBlattZwei;
import de.minol.gatways.rest.spring.boot.model.Users;
import de.minol.gatways.rest.spring.boot.repository.BlattLtdnrRepository;
import de.minol.gatways.rest.spring.boot.repository.BlattZweiLtdnrRepository;
import de.minol.gatways.rest.spring.boot.repository.FormBlattEinsRepository;
import de.minol.gatways.rest.spring.boot.repository.FormBlattRepository;
import de.minol.gatways.rest.spring.boot.repository.FormBlattZweiRepository;
import de.minol.gatways.rest.spring.boot.repository.UsersRepository;

@Service
public class BlattService {
	
	   @Autowired
	   private FormBlattEinsRepository formBlattEinsRepository;
	   @Autowired
	   private FormBlattZweiRepository formBlattZweiRepository;
	   @Autowired
	   private BlattZweiLtdnrRepository blattZweiLtdnrRepository;
	   // Ova dva su repozitorija gdje su smo spjili blatt 1 i blatt 2
	   @Autowired
	   private FormBlattRepository formBlattRepository;
	   @Autowired
	   private BlattLtdnrRepository blattLtdnrRepository;
	   @Autowired
	   private UsersRepository usersRepository;
	  
	  
	    @Transactional
		public boolean addBlattEins(FormBlattEins blattEins) {
			return formBlattEinsRepository.save(blattEins) != null;
		}
	    
	    @Transactional
		public boolean addUsers(Users users) {
			return usersRepository.save(users) != null;
		}
	    
	    @Transactional
		public boolean addBlattZwei(FormBlattZwei blattZwei) {
	    	
	    	Set<BlattZweiLtdnr> ltdnrZaSpremiti = blattZwei.getLtdnr();
	    	blattZwei.setLtdnr(null);
	    	
	    	
	    	
	    	if(ltdnrZaSpremiti != null) {
	    		
	    		FormBlattZwei save = formBlattZweiRepository.save(blattZwei);
	    		
	    		List<BlattZweiLtdnr> listLtdnr = new ArrayList<>(ltdnrZaSpremiti);
		    	for (int i = 0; i < listLtdnr.size(); i++) {
					listLtdnr.get(i).setFormBlattZwei(save);
				}
		    		
		    	Set<BlattZweiLtdnr> ltdnrSet = new HashSet<BlattZweiLtdnr>(listLtdnr);
		    	
		    	blattZwei.setLtdnr(ltdnrSet);
		    	
				return formBlattZweiRepository.save(blattZwei) != null;
	    		
	    	} else  {
	    		
	    		return formBlattZweiRepository.save(blattZwei) != null;
	    		
	    	}
	    		
	    	
	    	
		}
	    
	    @Transactional
		public boolean addBlattZweiLtdr(BlattZweiLtdnr blattZweiLtdr) {
	    	
	    	blattZweiLtdr.setFormBlattZwei(formBlattZweiRepository.findOne(blattZweiLtdr.getFormblattzwei_id()));
			return blattZweiLtdnrRepository.save(blattZweiLtdr) != null;
		}
	    
	    // Ispod je za spojene modele
	    
	    @Transactional
		public boolean addBlattLtdr(BlattLtdnr blattLtdr) {
	    	
	    	blattLtdr.setFormBlatt(formBlattRepository.findOne(blattLtdr.getFormblatt_id()));
			return blattLtdnrRepository.save(blattLtdr) != null;
		}
	    
	    @Transactional
		public boolean addBlatt(FormBlatt blatt) {
	    	
	    	Set<BlattLtdnr> ltdnrZaSpremiti = blatt.getLtdnr();
	    	blatt.setLtdnr(null);
	    	
	    	
	    	
	    	if(ltdnrZaSpremiti != null) {
	    		
	    		FormBlatt save = formBlattRepository.save(blatt);
	    		
	    		List<BlattLtdnr> listLtdnr = new ArrayList<>(ltdnrZaSpremiti);
		    	for (int i = 0; i < listLtdnr.size(); i++) {
					listLtdnr.get(i).setFormBlatt(save);
				}
		    		
		    	Set<BlattLtdnr> ltdnrSet = new HashSet<BlattLtdnr>(listLtdnr);
		    	
		    	blatt.setLtdnr(ltdnrSet);
		    	
				return formBlattRepository.save(blatt) != null;
	    		
	    	} else  {
	    		
	    		return formBlattRepository.save(blatt) != null;
	    		
	    	}
	    		
	    	
	    	
		}
	    
}
