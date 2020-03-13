package com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cartWithoutLogin")
public class CartWithoutLogin implements Serializable {

	private static final long serialVersionUID = 8436097833452420299L;

	@Id
	private String cartId;

	@OneToOne
	@JoinColumn(name = "customerId")
	@JsonIgnore
	private CustomerWithoutLogin customerWithoutLogin;

	@OneToMany(mappedBy = "cartWithoutLogin", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<CartItemWithoutLogin> cartItemWithoutLogin;

	private double totalPrice;

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public CustomerWithoutLogin getCustomerWithoutLogin() {
		return customerWithoutLogin;
	}

	public void setCustomerWithoutLogin(CustomerWithoutLogin customerWithoutLogin) {
		this.customerWithoutLogin = customerWithoutLogin;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<CartItemWithoutLogin> getCartItemWithoutLogin() {
		return cartItemWithoutLogin;
	}

	public void setCartItemWithoutLogin(List<CartItemWithoutLogin> cartItemWithoutLogin) {
		this.cartItemWithoutLogin = cartItemWithoutLogin;
	}

}
