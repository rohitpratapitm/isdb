package edu.psgv.sweng861.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SongEntity {
	@Id 
	@GeneratedValue
	Long songId;
	
	@Column(nullable=false)
	String title;
	
	@Column(nullable=false)
	String lyrics;
	
	@OneToMany
	List<ArtistEntity> artists;
	
	@Column(nullable=false)
	String album;
	
	@Column(nullable=false)
	double duration;
	
	@Column(nullable=false)
	Date releaseYear;
	
	public SongEntity() {}

	public SongEntity(String title, String lyrics, List<ArtistEntity> artists, String album, double duration,
			Date releaseYear) {
		super();
		this.title = title;
		this.lyrics = lyrics;
		this.artists = artists;
		this.album = album;
		this.duration = duration;
		this.releaseYear = releaseYear;
	}
}
