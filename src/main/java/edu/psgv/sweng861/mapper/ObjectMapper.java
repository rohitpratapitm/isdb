package edu.psgv.sweng861.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.psgv.sweng861.entity.ArtistEntity;
import edu.psgv.sweng861.entity.SongEntity;
import edu.psgv.sweng861.resource.Artist;
import edu.psgv.sweng861.resource.Song;

@Configuration
public class ObjectMapper {


	private ModelMapper modelMapper;
	
	@Bean
	public void modelMapper() {
		this.modelMapper = new ModelMapper();
	}
	
	public Song getSongResource(SongEntity songEntity) {
		Song song = this.modelMapper.map(songEntity, Song.class);
		return song;
	}
	
	public SongEntity getSongEntity(Song song) {
		SongEntity songEntity = this.modelMapper.map(song, SongEntity.class);
		return songEntity;
	}
	
	public Artist getArtistResource(ArtistEntity artistEntity) {
		Artist artist = this.modelMapper.map(artistEntity, Artist.class);
		return artist;
	}
	
	public ArtistEntity getArtistResource(Artist artist) {
		ArtistEntity artistEntity = this.modelMapper.map(artist, ArtistEntity.class);
		return artistEntity;
	}

}
