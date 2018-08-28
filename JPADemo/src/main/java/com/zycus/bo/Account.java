package com.zycus.bo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ACCOUNT")
public class Account {
	
	@Id
	@GeneratedValue
	private int accNo;
	
	private String name;
	private String type;
	private double balance;
	
	@OneToMany(mappedBy = "account"/*, cascade=CascadeType.ALL, fetch=FetchType.EAGER*/)
	private Set<FacilityTransaction> transaction;

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Set<FacilityTransaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(Set<FacilityTransaction> transaction) {
		this.transaction = transaction;
	}

}
