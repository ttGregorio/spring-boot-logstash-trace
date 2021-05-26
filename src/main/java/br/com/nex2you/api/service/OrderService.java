package br.com.nex2you.api.service;

import java.util.List;
import java.util.Optional;

import br.com.nex2you.api.entity.Order;

public interface OrderService {

	List<Order> findAll();

	Optional<Order> findById(int id);

	Order createUpdate(Order order);

	void registerPayment(Order order);

}