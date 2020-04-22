package com.tyler.account.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyler.account.data.domain.Account;
import com.tyler.account.service.AccountNumGenService;
import com.tyler.account.service.AccountPrizeService;
import com.tyler.account.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	private AccountService service;
	private AccountNumGenService numGen;
	private AccountPrizeService prize;

	public AccountController(AccountService service, AccountNumGenService numGen, AccountPrizeService prize) {
		super();
		this.service = service;
		this.numGen = numGen;
		this.prize = prize;
	}

	@PostMapping("/create")
	public Account create(@RequestBody Account account) {
		numGen.getRandomAccount(account);
		prize.decidePrize(account);
		return this.service.create(account);
	}

}
