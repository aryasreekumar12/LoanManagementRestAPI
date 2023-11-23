package com.demo.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.CustomerDetails;
import com.demo.repository.ICustomerRepo;

@Service
public class CustServiceImpl implements ICustomerService{
	
	private ICustomerRepo iCustomerRepo;
	

	@Autowired
	public CustServiceImpl(ICustomerRepo iCustomerRepo) {
		super();
		this.iCustomerRepo = iCustomerRepo;
	}

	@Override
	public List<CustomerDetails> findAll() {
		
		return iCustomerRepo.findAll();
	}

	@Override
	public CustomerDetails findById(int theId) {
		Optional<CustomerDetails>result=iCustomerRepo.findById(theId);
		CustomerDetails theCustomerDetails=null;
		if(result.isPresent()) {
			theCustomerDetails=result.get();
		}
		else {
			throw new RuntimeException("Did not find customer Id "+theId);
		}
		return theCustomerDetails;
	}

	@Override
	public void save(CustomerDetails theCustomerDetails) {
		iCustomerRepo.save(theCustomerDetails);
		
	}

	@Override
	public void deleteById(int theId) {
		iCustomerRepo.deleteById(theId);
		
	}

}
