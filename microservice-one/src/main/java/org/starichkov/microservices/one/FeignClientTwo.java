package org.starichkov.microservices.one;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Vadim Starichkov
 * @since 05.06.2019 12:30
 */
@FeignClient("microservice-two")
public interface FeignClientTwo {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello();
}
