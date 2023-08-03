package com.example.orderms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Ashraf on 18-Jul-23
 * @project order
 */
@FeignClient(name = "productClient", url = "http://localhost:8080")
public interface ProductClient {
    @GetMapping("{id}")
    ProductClientResponse getProductByID(@PathVariable("id") Long id);

    @GetMapping("/dec/{id}/{count}")
    boolean decreaseCountByCount(@PathVariable("id") Long id,@PathVariable("count") int count);

    @GetMapping("/inc/{id}/{count}")
    void increaseCountByCount(@PathVariable Long id,@PathVariable("count") int count);
}
