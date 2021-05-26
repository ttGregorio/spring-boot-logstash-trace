package br.com.nex2you.api.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nex2you.api.entity.Order;
import br.com.nex2you.api.repository.OrderRepository;
import br.com.nex2you.api.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Order> findAll() {
		logger.info("[OrderService][findAll]");
		return (List<Order>) orderRepository.findAll();
	}

	@Override
	public Optional<Order> findById(int id) {
		logger.info("[OrderService][findById][id: {}]", id);
		return orderRepository.findById(id);
	}

	@Override
	public Order createUpdate(Order order) {
		logger.info("[OrderService][createUpdate][order: {}]", order.toString());
		Order createdOrder = orderRepository.save(order);

		logger.info("[OrderService][createUpdate][createdOrder: {}]", order.toString());

		return createdOrder;
	}

	@Override
	public void registerPayment(Order order) {
		logger.info("[OrderService][registerPayment][order: {}]", order.toString());
		order.setPaymentCode(UUID.randomUUID());

		orderRepository.save(order);
	}
}
