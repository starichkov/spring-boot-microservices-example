package org.starichkov.microservices.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vadim Starichkov
 * @since 05.06.2019 12:28
 */
@RestController
public class ControllerTwo {

    private final FeignClientOne feignClientOne;

    @Autowired
    public ControllerTwo(FeignClientOne feignClientOne) {
        this.feignClientOne = feignClientOne;
    }

    @Value("${greetings}")
    private String greetings;

    @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello() {
        return greetings;
    }

    @GetMapping(value = "/hello1", produces = MediaType.TEXT_PLAIN_VALUE)
    public String helloFromMicroService1() {
        return feignClientOne.hello();
    }
}
