/*
 * Copyright 2021-2022 Rohit Sikarwar https://github.com/rohitpratapitm
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.psgv.sweng861.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import edu.psgv.sweng861.entity.ArtistEntity;
import edu.psgv.sweng861.exception.ArtistNotFoundException;
import edu.psgv.sweng861.mapper.ObjectMapper;
import edu.psgv.sweng861.repository.ArtistRepository;
import edu.psgv.sweng861.resource.Artist;

@Service
public class ArtistService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArtistService.class);
	
	private final ArtistRepository artistRepository;
	private final ObjectMapper objectMapper;
	
	public ArtistService(final ArtistRepository artistRepository, ObjectMapper objectMapper) {
		this.artistRepository = artistRepository;
		this.objectMapper = objectMapper;
	}
	
	public Artist getArtistById(Long id) {
		ArtistEntity artistEntity = this.artistRepository.findById(id).orElseThrow(() -> new ArtistNotFoundException(id));
		return this.objectMapper.getArtistResource(artistEntity);
	}
	
	public List<Artist> getArtists() {
		List<ArtistEntity> artistEntities = this.artistRepository.findAll();
		return artistEntities.stream().map(artistEntity -> this.objectMapper.getArtistResource(artistEntity)).collect(Collectors.toList());
	}
}
