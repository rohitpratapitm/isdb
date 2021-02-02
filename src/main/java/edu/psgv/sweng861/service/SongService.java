package edu.psgv.sweng861.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import edu.psgv.sweng861.entity.SongEntity;
import edu.psgv.sweng861.exception.SongNotFoundException;
import edu.psgv.sweng861.mapper.ObjectMapper;
import edu.psgv.sweng861.repository.SongRepository;
import edu.psgv.sweng861.resource.Song;

@Service
public class SongService {

	private final ObjectMapper objectMapper;
	private final SongRepository songRepository;
	
	public SongService(final SongRepository songRepository, final ObjectMapper objectMapper) {
		this.songRepository = songRepository;
		this.objectMapper = objectMapper;
	}
	
	public Song getSongById(Long id) {
		
		SongEntity songEntity = this.songRepository.findById(id).orElseThrow(() -> new SongNotFoundException(id));
		return this.objectMapper.getSongResource(songEntity);
	}

	public List<Song> getSongs() {
		List<SongEntity> songEntities = this.songRepository.findAll();
		return songEntities.stream().map(songEntity -> this.objectMapper.getSongResource(songEntity)).collect(Collectors.toList());
	}


}
