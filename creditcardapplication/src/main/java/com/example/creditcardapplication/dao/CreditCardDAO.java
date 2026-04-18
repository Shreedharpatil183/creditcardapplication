package com.example.creditcardapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.creditcardapplication.dtos.CreditCardInfo;

@Repository
public interface CreditCardDAO extends JpaRepository<CreditCardInfo, Integer> {

}
