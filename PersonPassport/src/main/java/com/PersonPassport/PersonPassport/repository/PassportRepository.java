package com.PersonPassport.PersonPassport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PersonPassport.PersonPassport.entity.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long>{

}
