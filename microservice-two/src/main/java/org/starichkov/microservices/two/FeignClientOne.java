package org.starichkov.microservices.two;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Vadim Starichkov
 * @since 05.06.2019 12:34
 */
@FeignClient("microservice-one")
public interface FeignClientOne {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello();
}
