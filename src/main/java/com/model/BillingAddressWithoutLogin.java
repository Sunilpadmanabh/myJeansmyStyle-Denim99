package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "billingAddress")
public class BillingAddressWithoutLogin implements Serializable {

	private static final long serialVersionUID = 1028098616457762754L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billindAddressId;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String country;

	@OneToOne(mappedBy = "billingAddressWithoutLogin")
	private CustomerWithoutLogin customerWithoutLogin;

	public CustomerWithoutLogin getCustomerWithoutLogin() {
		return customerWithoutLogin;
	}

	public void setCustomerWithoutLogin(CustomerWithoutLogin customerWithoutLogin) {
		this.customerWithoutLogin = customerWithoutLogin;
	}

	public int getBillindAddressId() {
		return billindAddressId;
	}

	public void setBillindAddressId(int billindAddressId) {
		this.billindAddressId = billindAddressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
