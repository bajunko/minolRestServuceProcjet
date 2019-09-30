package de.minol.gatways.rest.spring.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "News")
public class News {
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
	    @Column(name = "title")
		private String title;
	    @Column(name = "body")
		private String body;
		@Column(name = "category")
		private String category;
		@Column(name = "gpscoordinates")
		private String gpscoordinates;
		@Column(name = "photolinks")
		private String photolinks;
		@Column(name = "videolinks")
		private String videolinks;
		@Column(name = "audiolinks")
		private long audiolinks;
		@Column(name = "ishidden")
		private boolean isHidden;
		@Column(name = "date")
		private long date;
		
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getGpscoordinates() {
			return gpscoordinates;
		}
		public void setGpscoordinates(String gpscoordinates) {
			this.gpscoordinates = gpscoordinates;
		}
		public String getPhotolinks() {
			return photolinks;
		}
		public void setPhotolinks(String photolinks) {
			this.photolinks = photolinks;
		}
		public String getVideolinks() {
			return videolinks;
		}
		public void setVideolinks(String videolinks) {
			this.videolinks = videolinks;
		}
		public long getAudiolinks() {
			return audiolinks;
		}
		public void setAudiolinks(long audiolinks) {
			this.audiolinks = audiolinks;
		}
		public boolean isHidden() {
			return isHidden;
		}
		public void setHidden(boolean isHidden) {
			this.isHidden = isHidden;
		}
		public long getDate() {
			return date;
		}
		public void setDate(long date) {
			this.date = date;
		}
		
		
		
		
}
