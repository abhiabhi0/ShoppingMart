package com.programmercave.Model;

//This is model class of customer.
public class Customer {

	private String name;
	private Integer customerId;
	private String contact;  
	private String city;   
	private String membership; //Silver, Gold, Platinum
	private Integer cartAmount; 
	
	public Customer(String name, Integer customerId, String contact, String city, String membership, Integer cartAmount) {
		super();
		this.name = name;
		this.customerId = customerId;
		this.contact = contact;
		this.city = city;
		this.membership = membership;
		this.cartAmount = cartAmount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMembership() {
		return membership;
	}
	public void setMembership(String membership) {
		this.membership = membership;
	}
	public Integer getCartAmount() {
		return cartAmount;
	}
	public void setCartAmount(Integer cartAmount) {
		this.cartAmount = cartAmount;
	}
	
	
}