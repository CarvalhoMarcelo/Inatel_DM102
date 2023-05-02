package com.dm102.agenciaviagem.service;

import com.dm102.agenciaviagem.entity.TravelItinerary;

import java.util.List;
import java.util.Optional;

public interface ItineraryService {

    List<TravelItinerary> getItineraryList();
    Optional<TravelItinerary> getItinerary(Long id);
    TravelItinerary createAndUpdateItinerary(TravelItinerary travelItinerary, Long... idUpdate);
    void deleteItinerary(Long id);

}
