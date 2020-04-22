package com.tyler.account.service;

import org.springframework.stereotype.Service;

import com.tyler.account.data.domain.Account;
import com.tyler.account.data.domain.Prize;

@Service
public class AccountPrizeService {

	public AccountPrizeService() {
		super();
	}

	public Account decidePrize(Account account) {
		int accountNumberLength = account.getAccountNumber().length();
		if (account.getAccountNumber().startsWith("a")) {
			account.setPrize(new Prize(null, 0));
		}

		else if (accountNumberLength == 6) {

			if (account.getAccountNumber().startsWith("b")) {
				account.setPrize(new Prize(null, 50));
			} else if (account.getAccountNumber().startsWith("c")) {
				account.setPrize(new Prize(null, 100));
			}

		} else if (accountNumberLength == 8) {
			if (account.getAccountNumber().startsWith("b")) {
				account.setPrize(new Prize(null, 500));
			} else if (account.getAccountNumber().startsWith("c")) {
				account.setPrize(new Prize(null, 750));
			}

		} else if ((accountNumberLength == 10)) {
			if (account.getAccountNumber().startsWith("b")) {
				account.setPrize(new Prize(null, 5000));
			} else if (account.getAccountNumber().startsWith("c")) {
				account.setPrize(new Prize(null, 10000));
			}

		}
		return account;

	}
}
