package com.example.creditcardapplication.dtos;

public class ResponseData {
	CreditCardInfo info;
	String message;

	public CreditCardInfo getInfo() {
		return info;
	}

	public void setInfo(CreditCardInfo info) {
		this.info = info;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
