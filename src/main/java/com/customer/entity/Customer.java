package com.customer.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customerid")
	private Integer customerId;
	@Column(name = "customername")
	private String customerName;
	@Column(name = "customerage")
	private Integer customerAge;
	@Column(name = "customerno")
	private Long customerNumber;
	@Column(name = "customeremail")
	private String customerEmail;

	public Customer() {
		super();
	}

	public Customer(Integer customerId, String customerName, Integer customerAge,Long customerNumber,
			String customerEmail) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerNumber = customerNumber;
		this.customerEmail = customerEmail;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}

	public Long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAge=" + customerAge
				+ ", customerNumber=" + customerNumber + ", customerEmail=" + customerEmail + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerAge, customerEmail, customerId, customerName, customerNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(customerAge, other.customerAge) && Objects.equals(customerEmail, other.customerEmail)
				&& Objects.equals(customerId, other.customerId) && Objects.equals(customerName, other.customerName)
				&& Objects.equals(customerNumber, other.customerNumber);
	}

}
