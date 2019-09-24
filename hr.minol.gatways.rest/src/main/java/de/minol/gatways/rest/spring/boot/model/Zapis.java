package de.minol.gatways.rest.spring.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Zapis")
public class Zapis {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
	    @Column(name = "tekst")
		private String tekst;
	    @Column(name = "slika")
		private String slika;
		@Column(name = "geolokacija")
		private String geolokacija;
		@Column(name = "video")
		private String video;
		@Column(name = "zvuk")
		private String zvuk;
		@Column(name = "username")
		private String username;
		@Column(name = "vrijemeunosa")
		private long vrijemeunosa;
		
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getTekst() {
			return tekst;
		}
		public void setTekst(String tekst) {
			this.tekst = tekst;
		}
		public String getSlika() {
			return slika;
		}
		public void setSlika(String slika) {
			this.slika = slika;
		}
		public String getGeolokacija() {
			return geolokacija;
		}
		public void setGeolokacija(String geolokacija) {
			this.geolokacija = geolokacija;
		}
		public String getVideo() {
			return video;
		}
		public void setVideo(String video) {
			this.video = video;
		}
		public String getZvuk() {
			return zvuk;
		}
		public void setZvuk(String zvuk) {
			this.zvuk = zvuk;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public long getVrijemeunosa() {
			return vrijemeunosa;
		}
		public void setVrijemeunosa(long vrijemeunosa) {
			this.vrijemeunosa = vrijemeunosa;
		}
		
		
}
