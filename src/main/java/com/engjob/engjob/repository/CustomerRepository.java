package com.engjob.engjob.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.engjob.engjob.entity.Customer;
import com.engjob.engjob.entity.Profile;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAll()
	 */
	public List<Customer> findAll();

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#existsById(ID id)
	 */
	public boolean existsById(String id);

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findById(ID id)
	 */
	public Optional<Customer> findById(String id);

	/**
	 * Returns a list of customers by his/her firstname
	 * 
	 * @param firstname
	 * @return a list of customers with the firstname param
	 */
	public List<Customer> findByFirstname(String firstname);

	/**
	 * Returns a list of customers by his/her lastname
	 * 
	 * @param lastname
	 * @return a list of customers with the lastname param
	 */
    public List<Customer> findByLastname(String lastname);

	/**
	 * Returns a list of customers by his/her firstname
	 * 
	 * @param firstname
	 * @return a list of customers with the firstname param
	 */
	public List<Customer> findByProfile(Profile profile);

}
