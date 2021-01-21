package edu.psgv.sweng861.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Song {
	@Id @GeneratedValue
	String songId;
	String title;
	String artistId;
	String composerId;
	String album;
	long duration;
	
	public final String getSongId() {
		return songId;
	}
	public final void setSongId(String songId) {
		this.songId = songId;
	}
	public final String getTitle() {
		return title;
	}
	public final void setTitle(String title) {
		this.title = title;
	}
	public final String getArtistId() {
		return artistId;
	}
	public final void setArtistId(String artistId) {
		this.artistId = artistId;
	}
	public final String getComposerId() {
		return composerId;
	}
	public final void setComposerId(String composerId) {
		this.composerId = composerId;
	}
	public final String getAlbum() {
		return album;
	}
	public final void setAlbum(String album) {
		this.album = album;
	}
	public final long getDuration() {
		return duration;
	}
	public final void setDuration(long duration) {
		this.duration = duration;
	}
}
