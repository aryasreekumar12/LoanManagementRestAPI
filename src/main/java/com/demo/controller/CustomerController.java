package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.CustomerDetails;
import com.demo.service.ICustomerService;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class CustomerController {
	private ICustomerService iCustServ;

	@Autowired
	public CustomerController(ICustomerService iCustServ) {
		super();
		this.iCustServ = iCustServ;
	}

	@GetMapping("/customers")
	public List<CustomerDetails>findAll(){
		return iCustServ.findAll();
		}
	
	@GetMapping("/customers/{custId}")
	public CustomerDetails getCustomer(@PathVariable int custId){
		CustomerDetails theCustomerDetails=iCustServ.findById(custId);
        if(theCustomerDetails==null) {
        	throw new RuntimeException("Customer id not found-"+custId);
        }
        return theCustomerDetails;	
}
	
	@PostMapping("/customers")
	public CustomerDetails addCustomer(@RequestBody CustomerDetails theCustomerDetails){
		theCustomerDetails.setCustNo(0);
		iCustServ.save(theCustomerDetails);
		return theCustomerDetails;
		
	}
	
	
	
	@DeleteMapping("/customers/{custId}")
	public String deleteCustomer(@PathVariable int custId){
		CustomerDetails theCustomerDetails=iCustServ.findById(custId);
        if(theCustomerDetails==null) {
        	throw new RuntimeException("customer id not found-"+custId);
        }
        iCustServ.deleteById(custId);
        return "Deleted custId: "+custId;	 
	
}
	

}
