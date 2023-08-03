package com.example.orderms.controller;

import com.example.orderms.OrdermsApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ashraf on 01-Aug-23
 * @project orderms
 */

@SpringBootTest(classes = OrdermsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class OrderControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @LocalServerPort
    private int port;

    private String url;

    @BeforeEach
    void setUp() {
        this.url = "http://localhost:" + port;
    }

    @Test
    @Sql(scripts = "classpath:sql/orderms.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void givenMakeOrderWhenFoundThenReturnResult() {
        //arrange
        Long customer_id = 5L;
        Long product_id = 4L;
        int count = 2;
        //act
        ResponseEntity<Void> response = testRestTemplate.getForEntity(url + "/" + customer_id + "/" + product_id + "/" + count, Void.class);
        //assert
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }
}