package com.example.nacos.dubbo.provider.nacos;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * EchoService {@link com.example.nacos.EchoController}
 *
 * @author hubo
 * @since 2019-01-12
 */
@FeignClient("discovery-provider-example")
public interface EchoService {

    @GetMapping("/echo/str")
    String echo(@RequestParam(value = "message") String message);

}
