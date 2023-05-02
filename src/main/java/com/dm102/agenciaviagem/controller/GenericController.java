package com.dm102.agenciaviagem.controller;

import com.dm102.agenciaviagem.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GenericController {

    @Autowired
    GenericService genericService;

    @GetMapping("/{path}")
    public ResponseEntity<List<?>> listAll(@PathVariable("path") String path) {
        return new ResponseEntity<>(genericService.getList(path), HttpStatus.OK);
    }

    @GetMapping("/{path}/{id}")
    public ResponseEntity<Optional<?>> getOne(@PathVariable("path") String path,
                                              @PathVariable("id") Long id) {
        return new ResponseEntity<>(genericService.getOne(path, id), HttpStatus.OK);
    }

    @PostMapping("/{path}")
    public ResponseEntity<?> createObject(@PathVariable("path") String path,
                                          @RequestBody Object object){
        try{
            Object objectReturn = genericService.createAndUpdate(path,object);
            if(Objects.isNull(objectReturn)){
                return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>(objectReturn, HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{path}/{id}")
    public ResponseEntity<?> updateObject(@PathVariable("path") String path,
                                          @PathVariable("id") Long id,
                                          @RequestBody Object object){
        Object objectReturn = genericService.createAndUpdate(path,object,id);
        if(!ObjectUtils.isEmpty(objectReturn)){
            return new ResponseEntity<>(objectReturn, HttpStatus.OK);
        } else  {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{path}/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable("path") String path,
                                       @PathVariable("id") Long id){
        try{
            genericService.deleteOne(path,id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
