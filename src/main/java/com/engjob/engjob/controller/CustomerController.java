package com.engjob.engjob.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engjob.engjob.constanst.Constants;
import com.engjob.engjob.entity.Response;
import com.engjob.engjob.service.CustomerService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@CrossOrigin
	@GetMapping("customers")
	public Response getCustomers() {
		Response response = null;

		try {
			response = buildSuccessMessage(customerService.getCustomers(), Constants.ALL_CUSTOMERS);
		}catch (Exception e) {
			response = buildFailureMessage(e.getMessage());
		}

		return response;
	}
	
	@CrossOrigin
	@GetMapping("customers/firstname/{firstname}")
	public Response getCustomersByFirstname(@PathVariable("firstname") String firstname) {
		Response response = null;

		try {
			response = buildSuccessMessage(customerService.getCustomersByFirstname(firstname), Constants.CUSTOMERS_BY_FIRSTNAME);
		}catch (Exception e) {
			response = buildFailureMessage(e.getMessage());
		}

		return response;
	}
	
	@CrossOrigin
	@GetMapping("customers/lastname/{lastname}")
	public Response getCustomersByLastname(@PathVariable("lastname") String lastname) {
		Response response = null;

		try {
			response = buildSuccessMessage(customerService.getCustomersByLastname(lastname), Constants.CUSTOMERS_BY_LASTNAME);
		}catch (Exception e) {
			response = buildFailureMessage(e.getMessage());
		}

		return response;
	}
	
	@CrossOrigin
	@GetMapping("customers/profile/{profile}")
	public Response getCustomersByProfile(@PathVariable("profile") String profile) {
		Response response = null;

		try {
			response = buildSuccessMessage(customerService.getCustomersByProfile(profile), Constants.CUSTOMERS_BY_PROFILE);
		}catch (Exception e) {
			response = buildFailureMessage(e.getMessage());
		}

		return response;
	}

	@CrossOrigin
	@PutMapping("/create-customers")
	public Response createCustomersData() {
		customerService.createDummyData();
		Response response = null;

		try {
			response = buildSuccessMessage(customerService.getCustomers(), Constants.ALL_CUSTOMERS);
		}catch (Exception e) {
			response = buildFailureMessage(e.getMessage());
		}

		return response;
	}

	@CrossOrigin
	@DeleteMapping("/reset-customers")
	public Response resetCustomersData() {
		customerService.resetCustomers();
		Response response = null;

		try {
			response = buildSuccessMessage(customerService.getCustomers(), Constants.ALL_CUSTOMERS);
		}catch (Exception e) {
			response = buildFailureMessage(e.getMessage());
		}

		return response;
	}

	/**
	 * Build a success message (JSON Object) to return it as a HTTP Response
	 * 
	 * @param data Set of data (movements) to return
	 * @param msg Response success message 
	 * @return Response
	 */
	private Response buildSuccessMessage(Collection<?> data, String msg) {
		Response response = new Response();
		response.setSuccess(Boolean.TRUE);
		response.setData(data);
		response.setMessage(msg);

		return response;
	}

	/**
	 * Build a failure message (JSON Object) to return it as a HTTP Response
	 * 
	 * @param msg Response failure message (cause)
	 * @return Response
	 */
	private Response buildFailureMessage(String msg) {
		Response response = new Response();
		response.setSuccess(Boolean.FALSE);
		response.setData(null);
		response.setMessage(msg);

		return response;
	}

}
