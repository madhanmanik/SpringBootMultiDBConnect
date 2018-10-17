package com.uae.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.uae.model.Transaction;

@Repository
public class TransactionDaoImpl implements TransactionDao {

	@Autowired
	@Qualifier("sqlDbTrJdbcTemplate")
	private JdbcTemplate sqlDbTrJdbcTemplate;
	
	@Autowired
	@Qualifier("sqlDbPrJdbcTemplate")
	private JdbcTemplate sqlDbPrJdbcTemplate;


	public List getTransactionDetails(String xrNo) {

       		SimpleJdbcCall jdbcCall = new 
		         SimpleJdbcCall(sqlDbTrJdbcTemplate).withSchemaName("dbo").withCatalogName("xremit").withProcedureName("p_sampleSP");

		      SqlParameterSource in = new MapSqlParameterSource()
		    		  .addValue("aXRNo", "0009911806831950")
		    		  .addValue("aInstrumentType", "XR");
		      Map<String, Object> out = jdbcCall.execute(in);
		      
		     
		      
		      System.out.println("out" + out);
		      Transaction txn = null;
		      List finalList = new ArrayList<String>();
		      
		      for (Map.Entry<String, Object> entry : out.entrySet())
		      {
		          System.out.println(entry.getKey() + "/" + entry.getValue().toString());
		          
		          List<Map<String, Object>> list = (List<Map<String, Object>>) entry.getValue();
		          
		          if(list==null || list.isEmpty()) {
			    	  System.out.println("empty");
			    	  
			    	 //write logic for procedure call
			      }
		          
		          for (Map<String, Object> map : list) {
		        	   txn = new Transaction();
		        	   txn.setTxnRefNo((String)map.get("txnRefNo"));
		        	   txn.setPartnerTxnRefNo((String)map.get("partnerTxnRefNo"));
				    	 txn.setTaxInvoiceNumber((String)map.get("taxInvoiceNumber"));
		        	}
		          
		    	  finalList.add(txn);
		    	  break;
		          
		      }
		      

		return finalList;
	}
	


}
