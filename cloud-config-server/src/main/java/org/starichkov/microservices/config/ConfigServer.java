package org.starichkov.microservices.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Vadim Starichkov
 * @since 05.06.2019 11:51
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer {
    public static void main(String[] arguments) {
        SpringApplication.run(ConfigServer.class, arguments);
    }
}
