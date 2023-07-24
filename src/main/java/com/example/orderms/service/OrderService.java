package com.example.orderms.service;


import com.example.orderms.dto.request.OrderRequest;
import com.example.orderms.dto.response.OrderResponse;

/**
 * @author Ashraf on 18-Jul-23
 * @project order
 */

public interface OrderService {

    void makeOrder(Long customerId,Long productId,int Count);
    void createOder(OrderRequest request);
    OrderResponse getOrder(Long id);


}
