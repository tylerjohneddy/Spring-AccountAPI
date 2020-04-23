package com.tyler.account;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.tyler.account.data.domain.Account;
import com.tyler.account.rest.AccountController;
import com.tyler.account.service.AccountService;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

	private Account account;
	private Account accountCreated;
	private final String firstName = "tyler";
	private final String lastName = "eddy";
	private final String accountNumber = "a12345";

	@Mock
	private AccountService service;
	@InjectMocks
	private AccountController controller;

	@Before
	public void init() {
		account = new Account(firstName, lastName);
		accountCreated = new Account(firstName, lastName);
		accountCreated.setAccountNumber(accountNumber);

	}

	@Test
	public void testCreate() {
		Mockito.when(this.service.create(account)).thenReturn(accountCreated);
		assertEquals(accountCreated, controller.create(account));

	}
}
