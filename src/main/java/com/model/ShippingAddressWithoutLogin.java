package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shippingAddress")
public class ShippingAddressWithoutLogin implements Serializable {

	private static final long serialVersionUID = 7551999649936522556L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int shippingAddressId;

	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String country;

	@OneToOne(mappedBy = "shippingAddressWithoutLogin")
	private CustomerWithoutLogin customerWithoutLogin;

	public int getBillingAddressId() {
		return shippingAddressId;
	}

	public void setBillingAddressId(int billingAddressId) {
		this.shippingAddressId = billingAddressId;
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

	public int getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public CustomerWithoutLogin getCustomerWithoutLogin() {
		return customerWithoutLogin;
	}

	public void setCustomerWithoutLogin(CustomerWithoutLogin customerWithoutLogin) {
		this.customerWithoutLogin = customerWithoutLogin;
	}

}
