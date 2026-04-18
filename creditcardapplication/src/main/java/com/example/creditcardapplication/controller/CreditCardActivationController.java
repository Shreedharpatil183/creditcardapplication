package com.example.creditcardapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.creditcardapplication.dtos.CreditCardInfo;
import com.example.creditcardapplication.service.CreditCardService;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;

@RestController
public class CreditCardActivationController {

	@Autowired
	CreditCardService service;

	@PutMapping
	public ResponseEntity activateCreditCard(String userID, int creditScore) {
		ResponseEntity<Object> response = null;
		try {
			if (StringUtils.isNotEmpty(userID) && creditScore > 0) {
				CreditCardInfo info = service.activateCreditCard(userID, creditScore);
				response = new ResponseEntity(info, HttpStatus.OK);
			} else {
				response = new ResponseEntity("Either userID or creditScore is not valid", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception exe) {
			response = new ResponseEntity("Exception occured", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
