package com.PersonPassport.PersonPassport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PersonPassport.PersonPassport.entity.Passport;
import com.PersonPassport.PersonPassport.repository.PassportRepository;
import com.PersonPassport.PersonPassport.repository.PersonRepository;

@Service
public class PassportService {

    @Autowired
    private PassportRepository pasRepo;

    @Autowired
    private PersonRepository perRepo;

    // POST - "/passport" - Returns response status 201 with passport object on successful creation or else 400.
    // GET - "/passport" -  Returns response status 200 with List<Passport> object on successful retrieval or else 404.

    public Passport createPassport(Passport passport){
        return pasRepo.save(passport);
    }

    public List<Passport> allPassport(){
        return pasRepo.findAll();
    }

}
