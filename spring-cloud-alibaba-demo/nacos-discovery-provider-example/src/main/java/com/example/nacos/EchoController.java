package com.example.nacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * EchoController
 *
 * @author hubo
 * @since 2019-01-12
 */
@Slf4j
@RestController
@RequestMapping("/echo")
public class EchoController {

    @GetMapping("/str")
    public String echo(@RequestParam String message) {
        return "discovery-provider-example,echo controller : hello, " + message;
    }
}
