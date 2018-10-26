package com.engjob.engjob.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engjob.engjob.entity.Customer;
import com.engjob.engjob.entity.Profile;
import com.engjob.engjob.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Override
	public Customer getCustomerById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Customer> getCustomersByFirstname(String firstname) {
		return repository.findByFirstname(firstname).stream().collect(Collectors.toList());
	}

	@Override
	public Collection<Customer> getCustomersByLastname(String lastname) {
		return repository.findByFirstname(lastname).stream().collect(Collectors.toList());
	}

	@Override
	public Collection<Customer> getCustomersByProfile(String profile) {
		Collection<Customer> result = null;
		switch (profile) {
		case "ADMIN":
			result = repository.findByProfile(Profile.valueOf(profile)).stream().collect(Collectors.toList());
			break;
		case "APPLICANT":
			result = repository.findByProfile(Profile.valueOf(profile)).stream().collect(Collectors.toList());
			break;
		case "EMPLOYER":
			result = repository.findByProfile(Profile.valueOf(profile)).stream().collect(Collectors.toList());
			break;
		}
		return result;
	}

	@Override
	public Collection<Customer> getCustomers() {
		return repository.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public void resetCustomers() {
    	repository.deleteAll();

	}

	@Override
	public void createDummyData() {
		// reset data
		resetCustomers();

		// create some dummy customers
		repository.save(new Customer("Alice", "Harrell", "633306775", "novanet@icloud.com", Profile.APPLICANT));
		repository.save(new Customer("Marcel", "Marks", "837326666", "kodeman@me.com", Profile.EMPLOYER));
		repository.save(new Customer("Angel", "Allen", "626600946", "stecoop@outlook.com", Profile.APPLICANT));
		repository.save(new Customer("Rayna", "Obrien", "685854008", "stevelim@verizon.net", Profile.EMPLOYER));
		repository.save(new Customer("Melina", "Moyer", "634924417", "jsnover@comcast.net", Profile.APPLICANT));
		repository.save(new Customer("Declan", "Whitehead", "617457774", "rjones@optonline.net", Profile.EMPLOYER));
		repository.save(new Customer("Guillermo", "Galiano Sánchez", "6990411458", "guillermo.galiano88@gmail.com", Profile.ADMIN));
	}

}
