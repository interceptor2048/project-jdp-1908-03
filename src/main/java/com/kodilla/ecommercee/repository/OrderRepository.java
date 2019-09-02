package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Author Kamil Seweryn
 */
@Transactional
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
<<<<<<< HEAD
    List<Order> findAll();
=======

>>>>>>> b10fef649581f82a855b411eaf00d0d987ff230f
}