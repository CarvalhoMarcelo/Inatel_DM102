package com.dm102.agenciaviagem.controller;

import com.dm102.agenciaviagem.entity.Client;
import com.dm102.agenciaviagem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    ClientService clientService;


    @GetMapping("/cliente")
    public ResponseEntity<List<Client>> listAllClient(){
        return new ResponseEntity<>(clientService.getClientList(), HttpStatus.OK);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Optional<Client>> getClient(@PathVariable("id") Long id){
        return new ResponseEntity<>(clientService.getClient(id), HttpStatus.OK);
    }

    @PostMapping("/cliente")
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        try{
            return new ResponseEntity<>(clientService.createAndUpdateClient(client), HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id, @RequestBody Client client){
        Optional<Client> optionalClient = clientService.getClient(id);
        if(optionalClient.isPresent()){
            return new ResponseEntity<>(clientService.createAndUpdateClient(client), HttpStatus.OK);
        } else  {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long id){
        try{
            clientService.deleteClient(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
