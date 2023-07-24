package com.example.orderms.repository;

import com.example.orderms.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ashraf on 18-Jul-23
 * @project order
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
