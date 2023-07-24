package com.example.orderms.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ashraf on 19-Jul-23
 * @project order
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerClientResponse {
   private Long id;
   private Long pinCode;
   private String name;
   private String surName;
   private int age;
   private String address;
   private double balance;
}
