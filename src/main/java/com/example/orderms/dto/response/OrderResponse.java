package com.example.orderms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Ashraf on 18-Jul-23
 * @project order
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderResponse {
    private Long id;
    private Long customerId;
    private Long productId;
    private int count;
    private double price;
    private LocalDateTime orderedAt;
}
