package de.minol.gatways.rest.spring.boot.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.minol.gatways.rest.spring.boot.model.Folder;
import de.minol.gatways.rest.spring.boot.model.Users;
import de.minol.gatways.rest.spring.boot.model.Zapis;
import de.minol.gatways.rest.spring.boot.repository.FolderRepository;
import de.minol.gatways.rest.spring.boot.repository.UsersRepository;
import de.minol.gatways.rest.spring.boot.repository.ZapisRepository;

@Service
public class ZapisService {
	
	   @Autowired
	   private ZapisRepository zapisRepository;
	   @Autowired
	   private UsersRepository userRepository;
	   @Autowired
	   private FolderRepository folderRepository;
	  
	  
	  
	    @Transactional
		public boolean addZapis(Zapis zapis) {
			return zapisRepository.save(zapis) != null;
		}
	    
	    @Transactional
		public boolean addUsers(Users users) {
			return userRepository.save(users) != null;
		}
	    
	    
	    @Transactional
		public boolean addFolder(Folder folder) {
			return folderRepository.save(folder) != null;
		}
	   
		
}
