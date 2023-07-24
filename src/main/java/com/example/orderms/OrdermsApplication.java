package com.example.orderms;

import com.example.orderms.client.CustomerClient;
import com.example.orderms.client.ProductClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients(clients = {CustomerClient.class, ProductClient.class})
//@ComponentScan("com.example.orderms") //bunu vermekle controller in yaradilmasinin qabagini alirdiz ona gore. sadece client package de olan classslara baxirdi mende no quilfier erroru verirdi clietn bean yaratmrdi ona gore vermsdm
// indi hazirda o problem var ?
public class OrdermsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdermsApplication.class, args);
	}

}
