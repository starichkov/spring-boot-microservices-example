package org.starichkov.microservices.two;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author Vadim Starichkov
 * @since 05.06.2019 12:20
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MicroServiceTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceTwoApplication.class, args);
    }
}
