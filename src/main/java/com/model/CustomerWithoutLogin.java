package com.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customerWithoutLogin")
public class CustomerWithoutLogin implements Serializable {

	private static final long serialVersionUID = 2652327633296064144L;

	@Id
	private String customerId;
	private String firstName;
	private String lastName;
	private String customerPhone;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "shippingAddressId")
	private ShippingAddressWithoutLogin shippingAddressWithoutLogin;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "billingAddressId")
	private BillingAddressWithoutLogin billingAddressWithoutLogin;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User users;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cartId")
	@JsonIgnore
	private CartWithoutLogin cartWithoutLogin;

	public CartWithoutLogin getCartWithoutLogin() {
		return cartWithoutLogin;
	}

	public void setCartWithoutLogin(CartWithoutLogin cartWithoutLogin) {
		this.cartWithoutLogin = cartWithoutLogin;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String custmerId) {
		this.customerId = custmerId;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public ShippingAddressWithoutLogin getShippingAddressWithoutLogin() {
		return shippingAddressWithoutLogin;
	}

	public void setShippingAddressWithoutLogin(ShippingAddressWithoutLogin shippingAddressWithoutLogin) {
		this.shippingAddressWithoutLogin = shippingAddressWithoutLogin;
	}

	public BillingAddressWithoutLogin getBillingAddressWithoutLogin() {
		return billingAddressWithoutLogin;
	}

	public void setBillingAddressWithoutLogin(BillingAddressWithoutLogin billingAddressWithoutLogin) {
		this.billingAddressWithoutLogin = billingAddressWithoutLogin;
	}

}
