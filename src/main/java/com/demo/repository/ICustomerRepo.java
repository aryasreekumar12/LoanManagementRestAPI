package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.CustomerDetails;

public interface ICustomerRepo extends  JpaRepository<CustomerDetails, Integer>{

}
