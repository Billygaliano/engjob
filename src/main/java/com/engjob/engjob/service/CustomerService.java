package com.engjob.engjob.service;

import java.util.Collection;

import com.engjob.engjob.entity.Customer;

public interface CustomerService {

	/**
	 * Returns customer
	 * 
	 * @param id Customer id
	 * @return customer with the id param
	 */
	public Customer getCustomerById(String id);

	/**
	 * Returns customers by firstname
	 * 
	 * @param firstname Customer firstname
	 * @return all customers with the firstname of the param
	 */
	public Collection<Customer> getCustomersByFirstname(String firstname);

	/**
	 * Returns customers by lastname
	 * 
	 * @param firstname Customer lastname
	 * @return all customers with the lastname of the param
	 */
	public Collection<Customer> getCustomersByLastname(String lastname);

	/**
	 * Returns customers by profile
	 * 
	 * @param firstName Customer profile
	 * @return all customers with the profile of the param
	 */
	public Collection<Customer> getCustomersByProfile(String code);

	/**
	 * Returns all customers
	 * 
	 * @return all customers 
	 */
	public Collection<Customer> getCustomers();

	/**
	 * Deletes all customers
	 */
	public void resetCustomers();

	/**
	 * Creates customers with dummy data as example
	 */
	public void createDummyData();


}
