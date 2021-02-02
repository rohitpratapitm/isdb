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
package edu.psgv.sweng861;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.psgv.sweng861.entity.ArtistEntity;
import edu.psgv.sweng861.entity.Role;
import edu.psgv.sweng861.entity.SongEntity;
import edu.psgv.sweng861.repository.ArtistRepository;
import edu.psgv.sweng861.repository.SongRepository;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(ArtistRepository artistRepository, SongRepository songRepository) {

		return args -> {
			log.info("Preloading " + artistRepository.save(new ArtistEntity("Bob", "Marley", getDate(1945, 02, 06),
					getRoles(new Role[] { Role.SINGER, Role.COMPOSER }), null)));
			log.info("Preloading " + artistRepository.save(new ArtistEntity("Ricky", "Martin", getDate(1971, 12, 24),
					getRoles(new Role[] { Role.SINGER }), null)));
			 log.info("Preloading " + songRepository.save(new SongEntity("I Don't Care", "", getArtists(), "Life(2005)", 3.48, getDate(2005, 9, 13))));
		     log.info("Preloading " + songRepository.save(new SongEntity("I Don't Care", "", getArtists(), "Life(2005)", 3.48, getDate(2005, 9, 13))));
		};
	}

	private List<Role> getRoles(Role[] roles) {
		return new ArrayList<Role>(Arrays.asList(roles));
	}

	private Date getDate(int yyyy, int mm, int dd) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(yyyy, mm, dd);
		return calendar.getTime();
	}

private List<ArtistEntity> getArtists() {
	// TODO Auto-generated method stub
	return null;
}
}