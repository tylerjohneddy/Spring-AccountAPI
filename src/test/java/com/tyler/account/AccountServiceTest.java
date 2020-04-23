package com.tyler.account;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.tyler.account.data.domain.Account;
import com.tyler.account.data.domain.Prize;
import com.tyler.account.data.repo.AccountRepo;
import com.tyler.account.service.AccountNumGenService;
import com.tyler.account.service.AccountPrizeService;
import com.tyler.account.service.AccountService;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

	@Mock
	private AccountRepo repo;
	@Mock
	private AccountNumGenService numGen;
	@Mock
	private AccountPrizeService prizeService;
	@InjectMocks
	private AccountService service;

	private Account account;
	private Account accountWithAccountID;
	private Account accountWithPrize;
	private Account accountSaved;
	private Prize prize;
	private final String firstName = "tyler";
	private final String lastName = "eddy";
	private final String accountNumber = "c123456789";

	@Before
	public void init() {
		account = new Account(firstName, lastName);
		accountWithAccountID = new Account(firstName, lastName);
		accountWithAccountID.setAccountNumber(accountNumber);
		accountWithPrize = new Account(firstName, lastName);
		accountWithPrize.setAccountNumber(accountNumber);
		prize = new Prize(1l, 0);
		accountWithPrize.setPrize(prize);

		accountSaved = new Account(firstName, lastName);
		accountSaved.setAccountNumber(accountNumber);
		accountSaved.setPrize(prize);
		accountSaved.setId(1l);

	}

	@Test
	public void testCreate() {
		Mockito.when(numGen.getRandomAccount(account)).thenReturn(accountWithAccountID);

		Mockito.when(prizeService.decidePrize(accountWithAccountID)).thenReturn(accountWithPrize);

		Mockito.when(repo.save(accountWithPrize)).thenReturn(accountSaved);

		assertEquals(accountSaved, service.create(account));

		Mockito.verify(this.repo, times(1)).save(accountWithPrize);
	}
}
