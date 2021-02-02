package edu.psgv.sweng861.resource;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Song {

	Long songId;
	String title;
	String lyrics;
	String artistId;
	String composerId;
	String album;
	long duration;
	
}
