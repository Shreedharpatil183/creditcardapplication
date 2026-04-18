package com.example.creditcardapplication.dtos;

public class CreditCardInfo {

	private StatusEnum status;

	private CreditEnum creditEnum;

	private double creditLimit;

	private String cardNumber;

	private String pin;
	
	private int applicantID;
	
	private String comments;

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public CreditEnum getCreditEnum() {
		return creditEnum;
	}

	public void setCreditEnum(CreditEnum creditEnum) {
		this.creditEnum = creditEnum;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public int getApplicantID() {
		return applicantID;
	}

	public void setApplicantID(int applicantID) {
		this.applicantID = applicantID;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
