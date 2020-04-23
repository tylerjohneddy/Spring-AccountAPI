package com.tyler.account.data.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Account {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String AccountNumber;
	@OneToOne(cascade = CascadeType.ALL)
	private Prize prize;

	public Account() {
	}

	public Account(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public Prize getPrize() {
		return prize;
	}

	public void setPrize(Prize prize) {
		this.prize = prize;
	}

}
