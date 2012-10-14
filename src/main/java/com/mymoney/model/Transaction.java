package com.mymoney.model;

import java.util.Calendar;
import java.util.Date;

import com.domainlanguage.money.Money;

public class Transaction {

	private Long id;
	
	//Date
	private Account account;
	private Date date;	
	private String category; //maybe this will not be a String in future?
	private String subCategory; //maybe this will not be a String in future?
	private String description;
	private String payee;
	private Money amount;

	/**
	 * Future Fields...
	 * type		maybe of type Type? e.g. deposit, withdrawal, transfer
	 * transferAccount (to or from) and so maybe a toOrFrom boolean
	 * String 	number (as could be A888, may not be a straight number)
	 * boolean	flagged
	 * String	flagNote
	 */ 
	
	public Transaction() {
		//default date is creation time
		date = Calendar.getInstance().getTime();
	}
    public Long getId() {
        return id;
    }

    @SuppressWarnings("unused")
	private void setId(Long id) {
        this.id = id;
    }
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	public Money getAmount() {
		return amount;
	}
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
}
