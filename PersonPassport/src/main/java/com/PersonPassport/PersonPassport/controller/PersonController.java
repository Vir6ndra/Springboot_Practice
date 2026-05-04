package com.PersonPassport.PersonPassport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PersonPassport.PersonPassport.entity.Person;
import com.PersonPassport.PersonPassport.service.PassportService;
import com.PersonPassport.PersonPassport.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService perService;

    @Autowired
    private PassportService passService;

    // POST - "/person/passport/{passportId}" - Returns response status 201 with 
    // person object on successfully mapping the person to the passportId or else 400.

    @PostMapping("/passport/{passportId}")
    public ResponseEntity<Person> getPersonByPassportId(@PathVariable long passportId, @RequestBody Person person){
        Person per = perService.mapPersonToPassportId(passportId, person);
        if(per != null){
            return new ResponseEntity<>(per, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // GET - "/person/{personId}" - Returns response status 200 with person object, 
    // which includes details of the passport on successful retrieval or else 404.

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getPassportDetailOfPerson(@PathVariable long personId){
        Person per = perService.getPersonById(personId);
        if(per != null){
            return new ResponseEntity<>(per, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // GET - "/person/search/name?name={name}" - Returns response status 200 with 
    // a List<Person> objects matching the search criteria, or 404 if no persons are found.

    @GetMapping("/search/name")
    public ResponseEntity<List<Person>> getByName(@RequestParam String name){
        List<Person> list = perService.findPersonByName(name);
        if(list.size()>0){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/email")
    public ResponseEntity <List<Person>> findByEmail(@RequestParam String email){
        List<Person> li = perService.findPersonByEmail(email);
        if(li.size()>0){
            return new ResponseEntity<>(li, HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

    }



}
