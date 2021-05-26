package br.com.nex2you.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.nex2you.api.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>{

}
