package com.duker.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author xiebq
 * @create 2019/9/23 0023
 * @since 1.0.0
 */
@RestController
@RequestMapping("/webflux")
public class WebfluxController {

    @RequestMapping("/helloworld")
    public Mono<String> helloWord(){
        return Mono.just("hello WebFlux!");
    }
}
