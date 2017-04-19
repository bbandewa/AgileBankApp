package com.cg.test;

import org.junit.Before;
import org.junit.Test;

import com.cg.beans.Account;
import com.cg.exception.DuplicateAccountException;
import com.cg.exception.InsufficientInitialAmountException;
import com.cg.service.AccountService;
import com.cg.service.AccountServiceImpl;
import static org.junit.Assert.assertEquals;
public class AccountServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	AccountService accService = new AccountServiceImpl();
	
	@Test
	public void ifAllInputsAreValidThenCreateAccount() throws Exception{
		Account account = new Account();		
		account.setAmount(5000);
		account.setAccHolderName("xyz");
		account.setAccNO(101);		
		//accService.createAccount(account);			
		
		assertEquals(account, accService.createAccount(101,"xyz", 5000)) ;
	}
	
	@Test(expected=com.cg.exception.InsufficientInitialAmountException.class)
	public void whenAmountLessThanFiveHundredThrowException() throws Exception{		
		accService.createAccount(102, "abc", 300);		
	}
	
	@Test(expected=com.cg.exception.DuplicateAccountException.class)
	public void ifAccountNoAlreadyExistThrowException() throws InsufficientInitialAmountException, DuplicateAccountException, Exception{
		accService.createAccount(101, "abc", 50000);
		accService.createAccount(101, "xyz", 40000);
	}
	
	@Test
	public void ifAllParametersValidThenAmtShouldDeposit() throws InsufficientInitialAmountException, DuplicateAccountException, Exception{
		accService.createAccount(101, "abc", 50000);
		
	}
	
	
}
