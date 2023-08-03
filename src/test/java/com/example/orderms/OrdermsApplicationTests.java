package com.example.orderms;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.StreamUtils;

import java.io.IOException;

import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.util.FileCopyUtils.copyToString;

@SpringBootTest
@ActiveProfiles("test")
class OrdermsApplicationTests {

    @Autowired
    private WireMockServer mockService;

    void setUp() throws IOException {
        mockService.stubFor(WireMock.get(WireMock.urlEqualTo("/books"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type",
                                MediaType.APPLICATION_JSON_VALUE)
                        .withBody(StreamUtils.copyToString(
                                this.getClass().getClassLoader().getResourceAsStream("json/customer.json"),
                                defaultCharset()))));

    }

}

