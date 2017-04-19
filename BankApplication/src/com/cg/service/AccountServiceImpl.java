package com.cg.service;

import java.util.List;

import com.cg.beans.Account;
import com.cg.exception.DuplicateAccountException;
import com.cg.exception.InsufficientInitialAmountException;
import com.cg.exception.InvalidAccountNumberException;
import com.cg.repo.AccountRepository;
import com.cg.repo.AccountRepositoryImpl;

public class AccountServiceImpl implements AccountService {

	AccountRepository accRepo = new AccountRepositoryImpl();
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.service.AccountService#createAccount(com.cg.beans.Account)
	 */
	@Override
	public Account createAccount(int accNo, String name, double amt) throws Exception {
		Account account = new Account();
		account.setAccHolderName(name);
		account.setAccNO(accNo);
		account.setAmount(amt);
		
		if (account == null)
			throw new Exception();
		if(account.getAmount()<5000){
			throw new InsufficientInitialAmountException();
		}
		List<Integer> list = accRepo.getAccountNumbers();
			for(Integer i: list){
				if(account.getAccNO()== i)
					throw new DuplicateAccountException();
				
			}
		accRepo.createAccount(account);
				return account;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.service.AccountService#depositeAmt(int, double)
	 */
	@Override
	public double depositeAmt(int accNo, double amt) throws InvalidAccountNumberException {
		Account acc = accRepo.getAccount(accNo);
		if(acc == null)
			throw new InvalidAccountNumberException();
		amt += acc.getAmount();
		acc.setAmount(amt);
		return amt;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.service.AccountService#withdrawAmt(int, double)
	 */
	@Override
	public double withdrawAmt(int accNo, double amt) {
		return amt;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.service.AccountService#fundTransfer(int, int, double)
	 */
	@Override
	public boolean fundTransfer(int fromAcc, int toAcc, double amt) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cg.service.AccountService#viewBalance(int)
	 */
	@Override
	public double viewBalance(int accNo) {
		double amt = 1000;
		return amt;
	}
}
