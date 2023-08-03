package com.example.orderms.controller;

import com.example.orderms.OrdermsApplication;
import com.example.orderms.config.WireMockConfig;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.util.StreamUtils;

import java.io.IOException;

import static java.nio.charset.Charset.defaultCharset;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ashraf on 01-Aug-23
 * @project orderms
 */

@SpringBootTest(classes = OrdermsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@ContextConfiguration(classes = {WireMockConfig.class})


public class OrderControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private WireMockServer mockService;
    @BeforeEach
    void setUpForCustomerClient() throws IOException {
        mockService.stubFor(WireMock.get(WireMock.urlEqualTo("/customer/{id}"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type",
                                MediaType.APPLICATION_JSON_VALUE)
                        .withBody(StreamUtils.copyToString(
                                this.getClass().getClassLoader().getResourceAsStream("json/customer.json"),
                                defaultCharset()))));

    }
    @BeforeEach
    void setUpForProductClient() throws IOException {
        mockService.stubFor(WireMock.get(WireMock.urlEqualTo("/product/{id}"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type",
                                MediaType.APPLICATION_JSON_VALUE)
                        .withBody(StreamUtils.copyToString(
                                this.getClass().getClassLoader().getResourceAsStream("json/product.json"),
                                defaultCharset()))));

    }
    @Test
    @Sql(scripts = "classpath:sql/orderms.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void givenMakeOrderWhenFoundThenReturnResult() {
        //arrange
        Long customer_id = 5L;
        Long product_id = 4L;
        int count = 2;
        //act
        ResponseEntity<Void> response=testRestTemplate.getForEntity("http://localhost:9561/order/"+customer_id+"/"+product_id+"/"+count,Void.class);

        //assert
        assertEquals(HttpStatus.OK,response.getStatusCode());


    }
}