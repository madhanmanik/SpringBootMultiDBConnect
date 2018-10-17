package com.uae.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uae.dao.TransactionDao;
 
@Service
public class TransactionImpl implements TransactionSer{

	@Autowired
	private TransactionDao txnDao;
	
	public List getTransactionDetails(String xrNo) {
		
		List getTxn = txnDao.getTransactionDetails(xrNo);
		return getTxn;
	}
     
}