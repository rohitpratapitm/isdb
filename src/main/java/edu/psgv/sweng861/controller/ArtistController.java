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

import edu.psgv.sweng861.resource.Artist;
import edu.psgv.sweng861.service.ArtistService;

@RestController
@RequestMapping("/artists")
public class ArtistController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArtistController.class);

	private ArtistService artistService;

	public ArtistController(ArtistService artistService) {
		this.artistService = artistService;
	}

	@GetMapping
	public CollectionModel<EntityModel<Artist>> all() {
		List<EntityModel<Artist>> artists = this.artistService.getArtists()
				.stream()
				.map(artist -> EntityModel.of(artist, 
						linkTo(methodOn(ArtistController.class).one(artist.getArtistId())).withSelfRel(),
						linkTo(methodOn(ArtistController.class).all()).withSelfRel())).collect(Collectors.toList());
		return CollectionModel.of(artists);
	}

	@GetMapping(value = "/{id}")
	public EntityModel<Artist> one(@PathVariable final Long id) {
		Artist artist = this.artistService.getArtistById(id);
		return EntityModel.of(artist, 
				linkTo(methodOn(ArtistController.class).one(id)).withSelfRel(),
				linkTo(methodOn(ArtistController.class).all()).withRel("artists")
				);
	}

}
