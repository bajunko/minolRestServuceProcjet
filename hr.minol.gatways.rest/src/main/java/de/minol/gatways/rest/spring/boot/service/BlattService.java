package de.minol.gatways.rest.spring.boot.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.minol.gatways.rest.spring.boot.model.BlattZweiLtdnr;
import de.minol.gatways.rest.spring.boot.model.FormBlattEins;
import de.minol.gatways.rest.spring.boot.model.FormBlattZwei;
import de.minol.gatways.rest.spring.boot.repository.BlattZweiLtdnrRepository;
import de.minol.gatways.rest.spring.boot.repository.FormBlattEinsRepository;
import de.minol.gatways.rest.spring.boot.repository.FormBlattZweiRepository;

@Service
public class BlattService {
	
	   @Autowired
	   private FormBlattEinsRepository formBlattEinsRepository;
	   @Autowired
	   private FormBlattZweiRepository formBlattZweiRepository;
	   @Autowired
	   private BlattZweiLtdnrRepository blattZweiLtdnrRepository;
	  
	  
	    @Transactional
		public boolean addBlattEins(FormBlattEins blattEins) {
			return formBlattEinsRepository.save(blattEins) != null;
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
	    
}
