package edu.psgv.sweng861.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ArtistEntity {

	@Id 
	@GeneratedValue
	Long artistId;
	
	@Column(name="first_name", nullable=false)
	String firstName;

	@Column(name="last_name", nullable=false)
	String lastName;

	@Column(name="date_of_birth")
	Date dateOfBirth;

	@Column
	@ElementCollection(targetClass=Role.class)
	List<Role> roles;
	
	@OneToMany
	List<SongEntity> songs; // list of songs he sang/composed

	public ArtistEntity(String firstName, String lastName, Date dateOfBirth, List<Role> roles, List<SongEntity> songs) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.roles = roles;
		this.songs = songs;
	}

	public ArtistEntity() {
		super();
	}
}
