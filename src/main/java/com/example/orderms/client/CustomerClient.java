package com.example.orderms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Ashraf on 19-Jul-23
 * @project order
 */


@FeignClient(name = "customer",url = "http://localhost:8081")
public interface CustomerClient {
   @GetMapping(value = "/{id}")
   CustomerClientResponse getCustomerById(@PathVariable("id") Long id);
   @GetMapping("/{id}/{amount}")
   boolean decreaseBalance(@PathVariable Long id,@PathVariable double amount);
   @GetMapping("/{id}/{amount}")
   void increaseBalance(@PathVariable Long id,@PathVariable double amount);
}
