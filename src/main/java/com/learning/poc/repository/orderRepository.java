package com.learning.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.poc.Model.Order;

public interface orderRepository extends JpaRepository<Order, Integer>{

}
