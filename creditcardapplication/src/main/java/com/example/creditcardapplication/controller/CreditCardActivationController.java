package com.example.creditcardapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.creditcardapplication.dtos.CreditCardInfo;
import com.example.creditcardapplication.dtos.ResponseData;
import com.example.creditcardapplication.service.CreditCardService;

import io.micrometer.common.util.StringUtils;

@RestController
public class CreditCardActivationController {

	@Autowired
	CreditCardService service;

	@PutMapping("/activateCreditCard")
	public ResponseEntity<ResponseData> activateCreditCard(@RequestParam String userID, @RequestParam int creditScore) {
		ResponseEntity<ResponseData> response = null;
		ResponseData data = new ResponseData();
		try {
			if (StringUtils.isNotEmpty(userID) && creditScore > 0) {
				CreditCardInfo info = service.activateCreditCard(userID, creditScore);
				data.setInfo(info);
				data.setMessage("Card Generated");
				response = new ResponseEntity<ResponseData>(data, HttpStatus.OK);
			} else {
				data.setMessage("Either userID or creditScore is not valid");
				response = new ResponseEntity<ResponseData>(data, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception exe) {
			data.setMessage(exe.getMessage());
			response = new ResponseEntity<ResponseData>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
