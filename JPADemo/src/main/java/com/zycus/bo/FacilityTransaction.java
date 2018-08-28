package com.zycus.bo;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_TRANSACTION")
public class FacilityTransaction {

	@Id
	@GeneratedValue
	private int transNo;
	
	private Date txdate;
	private double amount;

	private String type;
	
	@ManyToOne
	@JoinColumn(name = "accNo")	
	private Account account;

	public int getTransNo() {
		return transNo;
	}

	public void setTransNo(int transNo) {
		this.transNo = transNo;
	}


	public Date getTxdate() {
		return txdate;
	}

	public void setTxdate(Date txdate) {
		this.txdate = txdate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	@Override
	public String toString() {
		return "FacilityTransaction [transNo=" + transNo + ", txdate=" + txdate + ", amount=" + amount + ", type="
				+ type + ", account=" + account + "]";
	}
}
