package com.uae.model;

public class Transaction {

	private String txnRefNo;
	
	private String partnerTxnRefNo;
	
	private String taxInvoiceNumber;

	public String getTxnRefNo() {
		return txnRefNo;
	}

	public void setTxnRefNo(String txnRefNo) {
		this.txnRefNo = txnRefNo;
	}

	public String getPartnerTxnRefNo() {
		return partnerTxnRefNo;
	}

	public void setPartnerTxnRefNo(String partnerTxnRefNo) {
		this.partnerTxnRefNo = partnerTxnRefNo;
	}

	public String getTaxInvoiceNumber() {
		return taxInvoiceNumber;
	}

	public void setTaxInvoiceNumber(String taxInvoiceNumber) {
		this.taxInvoiceNumber = taxInvoiceNumber;
	}
	
	
	
}
