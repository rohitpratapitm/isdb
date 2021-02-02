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
package edu.psgv.sweng861.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.psgv.sweng861.resource.Song;
import edu.psgv.sweng861.service.SongService;
 

@RestController
@RequestMapping("/songs")
public class SongController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SongController.class);
	
	private final SongService songService;
	
	
	public SongController(SongService songService) {
		this.songService = songService;
	}
	
	@GetMapping(value="/{id}")
	public EntityModel<Song> one(@PathVariable final Long id) {
		Song song = this.songService.getSongById(id);
		 return EntityModel.of(song, //
			      linkTo(methodOn(SongController.class).one(id)).withSelfRel(),
			      linkTo(methodOn(SongController.class).all()).withRel("songs"));
	}
	
	@GetMapping
	public CollectionModel<EntityModel<Song>> all() {
		
		List<EntityModel<Song>> songs = this.songService.getSongs().stream()
			      .map(song -> EntityModel.of(song,
			          linkTo(methodOn(SongController.class).one(song.getSongId())).withSelfRel(),
			          linkTo(methodOn(SongController.class).all()).withRel("songs")))
			      .collect(Collectors.toList());

			  return CollectionModel.of(songs, linkTo(methodOn(SongController.class).all()).withSelfRel());
	}
	
//	@GetMapping(value="/search")
//	public Song searchSongInformationByTitle(@RequestParam final String songTitle) {
//		
//	}
}
