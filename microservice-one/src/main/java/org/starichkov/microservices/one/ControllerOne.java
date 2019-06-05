package org.starichkov.microservices.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vadim Starichkov
 * @since 05.06.2019 12:27
 */
@RestController
public class ControllerOne {

    private final FeignClientTwo feignClientTwo;

    @Autowired
    public ControllerOne(FeignClientTwo feignClientTwo) {
        this.feignClientTwo = feignClientTwo;
    }

    @Value("${greetings}")
    private String greetings;

    @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello() {
        return greetings;
    }

    @GetMapping(value = "/hello2", produces = MediaType.TEXT_PLAIN_VALUE)
    public String helloFromMicroService2() {
        return feignClientTwo.hello();
    }
}
