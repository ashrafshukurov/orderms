package com.example.orderms.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Ashraf on 18-Jul-23
 * @project order
 */
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Order {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private Long customerId;
   private Long productId;
   private int count;
   private double price;
   private LocalDateTime orderedAt;




}
