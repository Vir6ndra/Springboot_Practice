package com.PersonPassport.PersonPassport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.PersonPassport.PersonPassport.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("from Person p where p.name=:name")
    List<Person> findByName(String name);


    @Query("from Person p where p.name=:name")
    List<Person> findByEmail(String email);
}
