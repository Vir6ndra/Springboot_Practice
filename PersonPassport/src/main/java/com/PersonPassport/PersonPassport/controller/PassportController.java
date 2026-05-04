package com.PersonPassport.PersonPassport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PersonPassport.PersonPassport.entity.Passport;
import com.PersonPassport.PersonPassport.entity.Person;
import com.PersonPassport.PersonPassport.service.PassportService;
import com.PersonPassport.PersonPassport.service.PersonService;

@RestController
@RequestMapping("/passport")
public class PassportController {

    @Autowired
    private PassportService passService;

    @PostMapping
    public ResponseEntity<Passport> addPassport(@RequestBody Passport passport){
        Passport pass = passService.createPassport(passport);
        if(pass != null){
            return new ResponseEntity<>(pass, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Passport>> ShowAllPassport(){
        List<Passport> list = passService.allPassport();

        if(list != null){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
