package com.dm102.agenciaviagem.controller;

import com.dm102.agenciaviagem.entity.TravelItinerary;
import com.dm102.agenciaviagem.service.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ItineraryController {

    @Autowired
    ItineraryService itineraryService;


    @GetMapping("/roteiro")
    public ResponseEntity<List<TravelItinerary>> listAllItinerary(){
        return new ResponseEntity<>(itineraryService.getItineraryList(), HttpStatus.OK);
    }

    @GetMapping("/roteiro/{id}")
    public ResponseEntity<Optional<TravelItinerary>> getItinerary(@PathVariable("id") Long id){
        return new ResponseEntity<>(itineraryService.getItinerary(id), HttpStatus.OK);
    }

    @PostMapping("/roteiro")
    public ResponseEntity<TravelItinerary> createItinerary(@RequestBody TravelItinerary travelItinerary){
        try{
            return new ResponseEntity<>(itineraryService.createAndUpdateItinerary(travelItinerary), HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/roteiro/{id}")
    public ResponseEntity<TravelItinerary> updateItinerary(@PathVariable("id") Long id, @RequestBody TravelItinerary travelItinerary){
        Optional<TravelItinerary> optionalItinarary = itineraryService.getItinerary(id);
        if(optionalItinarary.isPresent()){
            return new ResponseEntity<>(itineraryService.createAndUpdateItinerary(travelItinerary), HttpStatus.OK);
        } else  {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/roteiro/{id}")
    public ResponseEntity<?> deleteItinerary(@PathVariable("id") Long id){
        try{
            itineraryService.deleteItinerary(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
