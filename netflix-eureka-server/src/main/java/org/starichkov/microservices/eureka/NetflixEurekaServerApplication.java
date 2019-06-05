package org.starichkov.microservices.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Vadim Starichkov
 * @since 05.06.2019 11:33
 */
@EnableEurekaServer
@SpringBootApplication
public class NetflixEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NetflixEurekaServerApplication.class, args);
    }
}
