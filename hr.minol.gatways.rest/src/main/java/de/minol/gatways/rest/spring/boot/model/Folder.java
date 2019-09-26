package de.minol.gatways.rest.spring.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Folder")
public class Folder {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
	    @Column(name = "naziv")
		private String naziv;
	    
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getNaziv() {
			return naziv;
		}
		public void setNaziv(String naziv) {
			this.naziv = naziv;
		}

}
