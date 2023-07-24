package com.example.orderms.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ashraf on 18-Jul-23
 * @project order
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductClientResponse {
    private Long id;
    private int count;
    private double price;
}
