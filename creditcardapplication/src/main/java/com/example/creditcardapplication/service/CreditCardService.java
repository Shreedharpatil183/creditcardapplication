package com.example.creditcardapplication.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.creditcardapplication.dao.CreditCardDAO;
import com.example.creditcardapplication.dtos.CreditCardInfo;
import com.example.creditcardapplication.dtos.CreditEnum;
import com.example.creditcardapplication.dtos.StatusEnum;

@Service
public class CreditCardService {

	@Autowired
	CreditCardDAO dao;

	public CreditCardInfo activateCreditCard(String userID, int creditScore) {
		CreditCardInfo creditCardInfo = getCreditCard(creditScore);
		creditCardInfo.setApplicantID(123);
		if (creditCardInfo.getStatus() == StatusEnum.APPROVED) {
			String creditCardNumber = generateCreditCardNumber(creditCardInfo.getCreditEnum());
			creditCardInfo.setCardNumber(creditCardNumber);
		}
		if (creditCardInfo.getCardNumber() != null) {
			String firstPIN = generateFirstPIN(creditCardInfo.getCardNumber());
			creditCardInfo.setPin(firstPIN);
		}
		dao.save(creditCardInfo);
		return creditCardInfo;
	}

	private String generateFirstPIN(String creditCardNumber) {
		return UUID.fromString(creditCardNumber).toString();
	}

	private String generateCreditCardNumber(CreditEnum creditEnum) {
		String creditCardNumber = "";
		if (CreditEnum.PLATINUM == creditEnum) {
			creditCardNumber = "1000-1001-2001";
		} else if (CreditEnum.GOLD == creditEnum) {
			creditCardNumber = "2000-1001-2001";
		} else {
			creditCardNumber = "3000-1001-2001";
		}
		return creditCardNumber;
	}

	private CreditCardInfo getCreditCard(int creditScore) {
		CreditCardInfo creditCardInfo = new CreditCardInfo();
		if (creditScore >= 500) {
			creditCardInfo.setStatus(StatusEnum.APPROVED);
			creditCardInfo.setCreditEnum(CreditEnum.PLATINUM);
		} else if (creditScore >= 300 && creditScore < 500) {
			creditCardInfo.setStatus(StatusEnum.APPROVED);
			creditCardInfo.setCreditEnum(CreditEnum.GOLD);
		} else if (creditScore >= 150 && creditScore < 300) {
			creditCardInfo.setStatus(StatusEnum.APPROVED);
			creditCardInfo.setCreditEnum(CreditEnum.VISA);
		} else if (creditScore >= 50 && creditScore < 150) {
			creditCardInfo.setStatus(StatusEnum.PENDING);
			creditCardInfo.setComments("Additional docuemnts are requested.");
		} else {
			creditCardInfo.setStatus(StatusEnum.REJECTED);
		}

		return creditCardInfo;
	}

}
