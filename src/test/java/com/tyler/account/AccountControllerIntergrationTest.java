package com.tyler.account;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tyler.account.data.domain.Account;
import com.tyler.account.data.domain.Prize;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerIntergrationTest {

	@Autowired
	private MockMvc mvc;
	private ObjectMapper mapper = new ObjectMapper();
	private final String firstName = "Tyler";
	private final String lastName = "Eddy";
	private Account account;
	private Account accountReturned;

	@Before
	public void init() {
		account = new Account(firstName, lastName);
		accountReturned = new Account(firstName, lastName);
		accountReturned.setId(1l);
		accountReturned.setAccountNumber("c12345789");
		accountReturned.setPrize(new Prize(2l, 0));

	}

	@Test
	public void testCreate() throws UnsupportedEncodingException, Exception {

		RequestBuilder request = MockMvcRequestBuilders.request(HttpMethod.POST, "/account/create")
				.content(mapper.writeValueAsString(account)).contentType(MediaType.APPLICATION_JSON);

		String responseBody = this.mvc.perform(request).andExpect(status().is(200)).andReturn().getResponse()
				.getContentAsString();
		Account createdAccount = this.mapper.readValue(responseBody, Account.class);

		assertEquals(createdAccount.getPrize().getId(), accountReturned.getPrize().getId());

	}

}
