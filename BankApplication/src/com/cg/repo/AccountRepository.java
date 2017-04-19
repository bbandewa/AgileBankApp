package com.cg.repo;

import java.util.List;

import com.cg.beans.Account;

public interface AccountRepository {

	boolean createAccount(Account acc);

	boolean deleteAccount(int accNo);
	List<Integer> getAccountNumbers();
	Account getAccount(int accNo);
}