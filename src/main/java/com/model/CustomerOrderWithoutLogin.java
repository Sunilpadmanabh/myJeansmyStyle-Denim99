package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customerorderWithoutLogin")
public class CustomerOrderWithoutLogin implements Serializable {

	private static final long serialVersionUID = -6571020025726257858L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerOrderId;

	@OneToOne
	@JoinColumn(name = "cartId")
	private CartWithoutLogin cartWithoutLogin;

	@OneToOne
	@JoinColumn(name = "customerId")
	private CustomerWithoutLogin customerWithoutLogin;

	@OneToOne
	@JoinColumn(name = "shippingAddressId")
	private ShippingAddressWithoutLogin shippingAddressWithoutLogin;

	@OneToOne
	@JoinColumn(name = "billingAddressId")
	private BillingAddressWithoutLogin billingAddressWithoutLogin;

	public int getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public CartWithoutLogin getCartWithoutLogin() {
		return cartWithoutLogin;
	}

	public void setCartWithoutLogin(CartWithoutLogin cartWithoutLogin) {
		this.cartWithoutLogin = cartWithoutLogin;
	}

	public CustomerWithoutLogin getCustomerWithoutLogin() {
		return customerWithoutLogin;
	}

	public void setCustomerWithoutLogin(CustomerWithoutLogin customerWithoutLogin) {
		this.customerWithoutLogin = customerWithoutLogin;
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
