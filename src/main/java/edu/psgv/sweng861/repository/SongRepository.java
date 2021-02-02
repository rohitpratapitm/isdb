package edu.psgv.sweng861.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.psgv.sweng861.entity.SongEntity;

public interface SongRepository extends JpaRepository<SongEntity, Long>{

}
