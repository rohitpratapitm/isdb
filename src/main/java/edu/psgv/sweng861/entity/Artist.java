package edu.psgv.sweng861.entity;

import javax.persistence.Entity;

@Entity
public class Artist {

	Long artistId;
	String name;
	
	public Artist(Long artistId, String name) {
		this.artistId = artistId;
		this.name = name;
	}
	public Long getArtistId() {
		return artistId;
	}
	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
