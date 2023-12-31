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
   @GetMapping(value = "/customer/{id}")
   CustomerClientResponse getCustomerById(@PathVariable("id") Long id);
   @GetMapping("/dec/{id}/{amount}")
   boolean decreaseBalance(@PathVariable Long id,@PathVariable double amount);
   @GetMapping("/inc/{id}/{amount}")
   boolean increaseBalance(@PathVariable Long id,@PathVariable double amount);
}
