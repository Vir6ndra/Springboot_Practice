// GET - "/person/search/name?name={name}" - Returns response status 200 with a List<Person> 
// objects matching the search criteria, or 404 if no persons are found.

// GET - "/person/search/email?email={email}" - Returns response status 200 with a List<Person> 
// objects matching the search criteria, or 404 if no persons are found.

// POST - "/person/passport/{passportId}" - Returns response status 201 with person 
// object on successfully mapping the person to the passportId or else 400.

// GET - "/person/{personId}" - Returns response status 200 with person object, 
// which includes details of the passport on successful retrieval or else 404.


package com.PersonPassport.PersonPassport.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PersonPassport.PersonPassport.entity.Passport;
import com.PersonPassport.PersonPassport.entity.Person;
import com.PersonPassport.PersonPassport.repository.PassportRepository;
import com.PersonPassport.PersonPassport.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository persRepo;

    @Autowired
    private PassportRepository passRepo;


    // POST - "/person/passport/{passportId}" - Returns response status 201 with person 
// object on successfully mapping the person to the passportId or else 400.

    public Person mapPersonToPassportId(long passportId, Person person){
        if(passRepo.existsById(passportId)){
            Passport pass = passRepo.findById(passportId).get();
            person.setPassport(pass);
            return persRepo.save(person);
        }else{
            return null;
        }
    }

    // GET - "/person/{personId}" - Returns response status 200 with person object, 
// which includes details of the passport on successful retrieval or else 404.


    public Person getPersonById(long personId){
        if(persRepo.existsById(personId)){
            return persRepo.findById(personId).get();
        }else{
            return null;
        }
    }

// GET - "/person/search/name?name={name}" - Returns response status 200 with a List<Person> 
// objects matching the search criteria, or 404 if no persons are found.


    public List<Person> findPersonByName(String name){
        return persRepo.findByName(name);
    }


    public List<Person> findPersonByEmail(String email){
        return persRepo.findByEmail(email);
    }












}
