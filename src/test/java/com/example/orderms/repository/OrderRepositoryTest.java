package com.example.orderms.repository;

import com.example.orderms.model.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ashraf on 01-Aug-23
 * @project orderms
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "test")
@EnableConfigurationProperties
@EnableJpaRepositories
class OrderRepositoryTest {
    @Autowired
    private OrderRepository repository;
    @Test
    @Sql(scripts = "classpath:sql/orderms.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void givenFindByIdOrderMsWhenFoundThenReturnEntity(){
        //arrange
        Long order_id=3L;

        //act
        Optional<Order> result=repository.findById(order_id);
        //assert
        assertNotNull(result.get());
        Order order=result.get();
        assertEquals(order_id,order.getId());
    }



}