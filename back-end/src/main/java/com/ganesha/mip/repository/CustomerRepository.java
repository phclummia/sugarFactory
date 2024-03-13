package com.ganesha.mip.repository;

import com.ganesha.mip.model.jpa.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<CustomerEntity, String> {

}