package com.cg.repo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.cg.beans.Account;

public class AccountRepositoryImpl implements AccountRepository  {

	Map<Integer,Account> map = new ConcurrentHashMap<>();
	/* (non-Javadoc)
	 * @see com.cg.repo.AccountRepository#createAccount(com.cg.beans.Account)
	 */
	@Override
	public boolean createAccount(Account acc){		
		if(acc==null)
			return false;

		map.put(acc.getAccNO(),acc);
		return true;

	}

	/* (non-Javadoc)
	 * @see com.cg.repo.AccountRepository#deleteAccount(int)
	 */
	@Override
	public boolean deleteAccount(int accNo){
		return false;
	}

	@Override
	public List<Integer> getAccountNumbers(){
		List<Integer> list = new ArrayList<>();
		Iterator<Integer> it = map.keySet().iterator();

		while(it.hasNext()){
			Integer key = it.next();
			//	if(key.equals("3")) map.put(key+"new", "new3");
			list.add(key);

		}
		return list;
	}

	public Account getAccount(int accNo){
		return map.get(accNo);

	}
}
