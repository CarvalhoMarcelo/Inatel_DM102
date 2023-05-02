package com.dm102.agenciaviagem.service.impl;

import com.dm102.agenciaviagem.entity.*;
import com.dm102.agenciaviagem.repository.AbstractBaseRepository;
import com.dm102.agenciaviagem.repository.ItineraryRepository;
import com.dm102.agenciaviagem.service.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ItineraryServiceImpl implements ItineraryService {

    @Autowired
    ItineraryRepository itineraryRepository;

    @Autowired
    AbstractBaseRepository<Country> countryRepository;

    @Autowired
    AbstractBaseRepository<State> stateRepository;

    @Autowired
    AbstractBaseRepository<City> cityRepository;

    @Autowired
    AbstractBaseRepository<TransportType> transportTypeRepository;


    @Override
    public List<TravelItinerary> getItineraryList() {
        return itineraryRepository.findAll();
    }

    @Override
    public Optional<TravelItinerary> getItinerary(Long id) {
        return itineraryRepository.findById(id);
    }

    @Override
    public TravelItinerary createAndUpdateItinerary(TravelItinerary travelItinerary, Long... idUpdate) {
        if(!ObjectUtils.isEmpty(idUpdate)){
            if(itineraryRepository.findById(idUpdate[0]).isEmpty()){
                return null;
            } else {
                travelItinerary.setId(idUpdate[0]);
            }
        } else {
            if(countryRepository.findById(travelItinerary.getIdCountry()).isEmpty()){
                System.out.println("Pais com o Id: " + travelItinerary.getIdCountry() + " nao encontrado!");
                return null;
            }
            if(stateRepository.findById(travelItinerary.getIdState()).isEmpty()) {
                System.out.println("Estado com o Id: " + travelItinerary.getIdState() + " nao encontrado!");
                return null;
            }
            if(cityRepository.findById(travelItinerary.getIdCity()).isEmpty()) {
                System.out.println("Cidade com o Id: " + travelItinerary.getIdCity() + " nao encontrado!");
                return null;
            }
            if(transportTypeRepository.findById(travelItinerary.getIdTransport()).isEmpty()) {
                System.out.println("Transporte com o Id: " + travelItinerary.getIdTransport() + " nao encontrado!");
                return null;
            }
        }
        return itineraryRepository.save(travelItinerary);
    }

    @Override
    public void deleteItinerary(Long id) {
        itineraryRepository.deleteById(id);
    }
}
