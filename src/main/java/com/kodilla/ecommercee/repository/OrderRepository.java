package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Author Kamil Seweryn
 */
@Transactional
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}