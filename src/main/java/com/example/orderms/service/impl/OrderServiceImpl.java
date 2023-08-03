package com.example.orderms.service.impl;


import com.example.orderms.client.CustomerClient;
import com.example.orderms.client.CustomerClientResponse;
import com.example.orderms.client.ProductClient;
import com.example.orderms.client.ProductClientResponse;
import com.example.orderms.dto.request.OrderRequest;
import com.example.orderms.dto.response.OrderResponse;
import com.example.orderms.exception.NotFoundException;
import com.example.orderms.mapper.OrderMapper;
import com.example.orderms.model.Order;
import com.example.orderms.repository.OrderRepository;
import com.example.orderms.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Ashraf on 18-Jul-23
 * @project order
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper mapper;
    private final ProductClient productClient;
    private final CustomerClient customerClient;

    @Override
    public void makeOrder(Long customerId, Long productId, int Count) {
        try{
            log.info("product is searching");
            ProductClientResponse productResponse=productClient.getProductByID(productId);
            log.info("customer is searching");
            CustomerClientResponse customerResponse=customerClient.getCustomerById(customerId);
            log.info("1");
            int productCount=productResponse.getCount();
            log.info("2");
            double price=productResponse.getPrice();
            log.info("3");
          boolean a= productClient.decreaseCountByCount(productId,Count);
          log.info("4");;
          boolean c= customerClient.decreaseBalance(customerId,Count*price);
          if(a){
              if(c){
                  Order order= Order.builder()
                          .customerId(customerId)
                          .orderedAt(LocalDateTime.now())
                          .count(Count)
                          .price(productCount*price)
                          .productId(productId).build();
                  orderRepository.save(order);
              }else{
              productClient.increaseCountByCount(productId,Count);
              }
          } else {
              customerClient.increaseBalance(customerId,Count);
          }

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void createOder(OrderRequest request) {
        log.info("order is creating");
        Order order=mapper.requestToEntity(request);
        orderRepository.save(order);

    }

    @Override
    public OrderResponse getOrder(Long id) {
        log.info("order is being searching");
        Order order=orderRepository.findById(id).orElseThrow(()->new NotFoundException("invalid Order"));
        return mapper.entityToResponse(order);
    }


}
