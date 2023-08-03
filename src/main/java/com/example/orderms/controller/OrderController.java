package com.example.orderms.controller;


import com.example.orderms.client.CustomerClient;
import com.example.orderms.client.CustomerClientResponse;
import com.example.orderms.client.ProductClient;
import com.example.orderms.client.ProductClientResponse;
import com.example.orderms.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * @author Ashraf on 18-Jul-23
 * @project order
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
@Slf4j
public class OrderController {
    private final OrderService orderService;
    private  final CustomerClient client;
    private final ProductClient productClient;
    @PostMapping("/{customerId}/{productId}/{count}")
   public void makeOrder(@PathVariable Long customerId, @PathVariable Long productId, @PathVariable int count){
        orderService.makeOrder(customerId,productId,count);
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerClientResponse> getClient(@PathVariable Long id){
        return ResponseEntity.ok(client.getCustomerById(id));
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductClientResponse> getProduct(@PathVariable Long id){
        return ResponseEntity.ok(productClient.getProductByID(id));
    }
//    @GetMapping("/")



}
