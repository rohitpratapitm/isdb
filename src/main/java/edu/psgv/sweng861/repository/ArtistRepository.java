package edu.psgv.sweng861.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.psgv.sweng861.entity.ArtistEntity;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Long>{

}
