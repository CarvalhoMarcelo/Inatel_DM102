package com.dm102.agenciaviagem.controller;

import com.dm102.agenciaviagem.entity.TravelPackage;
import com.dm102.agenciaviagem.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PackageController {

    @Autowired
    PackageService packageService;


    @GetMapping("/pacote")
    public ResponseEntity<List<TravelPackage>> listAllPackage(){
        return new ResponseEntity<>(packageService.getPackageList(), HttpStatus.OK);
    }

    @GetMapping("/pacote/{id}")
    public ResponseEntity<Optional<TravelPackage>> getPackage(@PathVariable("id") Long id){
        return new ResponseEntity<>(packageService.getPackage(id), HttpStatus.OK);
    }

    @PostMapping("/pacote")
    public ResponseEntity<TravelPackage> createPackage(@RequestBody TravelPackage travelPackage){
        try{
            return new ResponseEntity<>(packageService.createAndUpdatePackage(travelPackage), HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pacote/{id}")
    public ResponseEntity<TravelPackage> updatePackage(@PathVariable("id") Long id, @RequestBody TravelPackage travelPackage){
        Optional<TravelPackage> optionalPackage = packageService.getPackage(id);
        if(optionalPackage.isPresent()){
            return new ResponseEntity<>(packageService.createAndUpdatePackage(travelPackage), HttpStatus.OK);
        } else  {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/pacote/{id}")
    public ResponseEntity<?> deletePackage(@PathVariable("id") Long id){
        try{
            packageService.deletePackage(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
