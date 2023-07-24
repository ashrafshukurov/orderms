package com.example.orderms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Ashraf on 18-Jul-23
 * @project order
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Long customerId;
    private Long productId;
    private int count;
    private double price;
    private LocalDateTime orderedAt;
}
