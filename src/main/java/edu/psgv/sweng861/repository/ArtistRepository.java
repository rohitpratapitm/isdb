package edu.psgv.sweng861.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.psgv.sweng861.entity.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long>{

}
