package com.example.orderms.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;


/**
 * @author Ashraf on 01-Aug-23
 * @project orderms
 */

@TestConfiguration
public class WireMockConfig {
   @Bean(initMethod = "start",destroyMethod = "stop")
   public WireMockServer mockCustomerService(){
      return new WireMockServer(9561);
   }

}
