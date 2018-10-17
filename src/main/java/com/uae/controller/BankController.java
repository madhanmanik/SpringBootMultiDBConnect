package com.uae.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uae.service.TransactionSer;

@RestController
@RequestMapping("/bank")
@CrossOrigin
public class BankController {

	@Autowired
	private TransactionSer trSer;
	
	 @GetMapping("/txn")
	    public List getTransactionDetails(@RequestParam String xrNo) {
		 List getTrn =  trSer.getTransactionDetails(xrNo);
	        return getTrn;
	    }
	 
}
