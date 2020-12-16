package org.digitalcrafting.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway/api/proxy/v1")
public class ProxyController {
    @GetMapping("/")
    public String test() {
        return "I'm alive";
    }
}
