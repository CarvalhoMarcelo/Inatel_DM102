package com.dm102.agenciaviagem.repository;

import com.dm102.agenciaviagem.entity.TravelItinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItineraryRepository extends JpaRepository<TravelItinerary, Long> {

}
