package com.example.nacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * TestController
 *
 * @author hubo
 * @since 2019-01-12
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private EchoService echoService;

    /**
     * 通过 feign 调用 provider 的 echoService
     * @param message
     * @return
     */
    @GetMapping("/echo")
    public String testEcho(String message) {
        return echoService.echo(message);
    }

}
