package com.tyler.account.service;

import org.springframework.stereotype.Service;

import com.tyler.account.data.domain.Account;
import com.tyler.account.data.repo.AccountRepo;

@Service
public class AccountService {

	private AccountRepo repo;
	private AccountNumGenService numGen;
	private AccountPrizeService prize;

	public AccountService(AccountRepo repo, AccountNumGenService numGen, AccountPrizeService prize) {
		super();
		this.repo = repo;
		this.numGen = numGen;
		this.prize = prize;
	}

	public Account create(Account account) {
		account = numGen.getRandomAccount(account);
		account = prize.decidePrize(account);
		return this.repo.save(account);
	}

}
