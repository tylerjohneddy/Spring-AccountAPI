package com.tyler.account.data.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Prize {

	@Id
	@GeneratedValue
	private Long Id;
	private int PrizeValue;

	public Prize(Long id, int prizeValue) {
		super();
		Id = id;
		PrizeValue = prizeValue;
	}

	public Prize() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public int getPrizeValue() {
		return PrizeValue;
	}

	public void setPrizeValue(int prizeValue) {
		PrizeValue = prizeValue;
	}

}
