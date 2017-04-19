package com.cg.service;

import com.cg.beans.Account;
import com.cg.exception.DuplicateAccountException;
import com.cg.exception.InsufficientInitialAmountException;
import com.cg.exception.InvalidAccountNumberException;

public interface AccountService {

	Account createAccount(int accNo, String name, double amt) throws InsufficientInitialAmountException, DuplicateAccountException, Exception;

	double depositeAmt(int accNo, double amt) throws InvalidAccountNumberException;

	double withdrawAmt(int accNo, double amt);

	boolean fundTransfer(int fromAcc, int toAcc, double amt);

	double viewBalance(int accNo);

}